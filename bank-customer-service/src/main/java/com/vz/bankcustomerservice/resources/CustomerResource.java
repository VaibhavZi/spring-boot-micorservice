/**
 * 
 */
package com.vz.bankcustomerservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vz.bankcustomerservice.domain.Bank;
import com.vz.bankcustomerservice.domain.Branch;
import com.vz.bankcustomerservice.domain.Customer;
import com.vz.bankcustomerservice.service.CustomerService;

/**
 * @author Vaibhav Zingade
 *
 */

@RestController
@PropertySource("classpath:customer-app.properties")
public class CustomerResource {

	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	@Value("${isBankValidationRequired}")
	private boolean isBankValidationRequired;

	@Autowired
	CustomerService customerService;

	@GetMapping(path = "/bank/{bankId}/customers")
	public List<Customer> getAllCustomersForBank(@PathVariable("bankId") int bankCode) {
		List<Customer> allCustomers = null;
		Bank bank = null;
		if (isBankValidationRequired) {
			bank = restTemplate.getForObject("http://bank-service/bank/" + bankCode, Bank.class);
		}
		if (isBankValidationRequired && bank == null) {
			return null;
		} else
			allCustomers = customerService.getAllCustomers();
		return allCustomers;
	}

	@GetMapping(path = "/customerinfo/bank/{bankId}/{customerId}")
	public ResponseEntity<Customer> getCustomerByCustomerId(@PathVariable("bankId") int bankCode,
			@PathVariable("customerId") int customerId) {
		Bank bank = null;
		if (isBankValidationRequired)
			bank = restTemplate.getForObject("http://bank-service/bank/" + bankCode, Bank.class);

		if (isBankValidationRequired && bank == null) {
			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
		}
		Customer customerById = customerService.getCustomerById(bank.getBankCode(), customerId);
		return new ResponseEntity<Customer>(customerById, HttpStatus.FOUND);

	}

	@PutMapping(path = "/customerinfo", consumes = "application/json")
	public ResponseEntity<Customer> updateCustomerInformation(@RequestBody Customer customer) {
		Bank bank = null;
		if (isBankValidationRequired)
			bank = restTemplate.getForObject("http://bank-service/bank/" + customer.getBankCode(), Bank.class);
		if (isBankValidationRequired && bank == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_MODIFIED);
		}
		Customer customer2 = customerService.updateCustomerInformation(customer);
		return new ResponseEntity<Customer>(customer2, HttpStatus.OK);

	}

	@PostMapping(path = "/customer", consumes = "application/json", produces = "application/jason")
	public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer) {
		if (customer.getBankCode() != null && customer.getBranchId() != null) {
			// Check if bank and branch are valid by calling a service available for branch
			// enquire
			Branch branchInfo = null;
			if (isBankValidationRequired) {
				branchInfo = restTemplate.getForObject("http://bank-branch-service/bank/" + customer.getBankCode()
						+ "/branch/" + customer.getBranchId(), Branch.class);
			}
			if (isBankValidationRequired && branchInfo == null) {
				return new ResponseEntity<Customer>(HttpStatus.FORBIDDEN);
			}
			customerService.addCustomer(customer);
			return new ResponseEntity<Customer>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Customer>(HttpStatus.FORBIDDEN);
	}

	@DeleteMapping(path = "/deletecustomer/bank/{bankId}/branch/{branchId}/customer/{customerId}")
	public ResponseEntity<Customer> deleteCustomerInformation(@PathVariable("bankId") int bankId,
			@PathVariable("branchId") String branchId, @PathVariable("customerId") int customerId) {
		// lookup branch info if it is correct
		Branch branchInfo = restTemplate
				.getForObject("http://bank-branch-service/bank" + bankId + "/branch/" + branchId, Branch.class);
		if (branchInfo != null) {
			customerService.delete(customerId);
			return new ResponseEntity<Customer>(HttpStatus.OK);
		}
		return new ResponseEntity<Customer>(HttpStatus.FORBIDDEN);
	}
}
