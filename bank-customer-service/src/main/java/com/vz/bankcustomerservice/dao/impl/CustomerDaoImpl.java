/**
 * 
 */
package com.vz.bankcustomerservice.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vz.bankcustomerservice.dao.CustomerDao;
import com.vz.bankcustomerservice.domain.Customer;
import com.vz.bankcustomerservice.repository.CustomerRepository;

/**
 * @author 10640143
 *
 */

@Service
@Transactional
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers(int bankCode) {
		//TODO currently getting all customers, need to implement logic to get All customers for specific bank only.
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(int bankCode, int customerId) {
		return customerRepository.getOne(customerId);
	}

	@Override
	public List<Customer> findCustomersByFirstNameAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomerInformation(Customer customer) {
		if(customerRepository.findById(customer.getCustomerNumber())!=null) {
			Customer updated = customerRepository.save(customer);
			return updated;
		}
		return null;
	}

	@Override
	public void delete(int customerId) {
		Optional<Customer> findById = customerRepository.findById(customerId);
		if(findById!=null) {
			customerRepository.deleteById(customerId);
		}		
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	

}
