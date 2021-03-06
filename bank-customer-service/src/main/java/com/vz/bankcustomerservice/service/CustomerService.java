/**
 * 
 */
package com.vz.bankcustomerservice.service;

import java.util.List;

import com.vz.bankcustomerservice.domain.Customer;

/**
 * @author 10640143
 *
 */
public interface CustomerService {
	
	void addCustomer(Customer customer);
	List<Customer> getAllCustomers(int bankCode);
	List<Customer> getAllCustomers();
	Customer getCustomerById(int bankCode, int customerId);
	List<Customer> findCustomersByFirstNameAndLastName(String firstName, String lastName);
	Customer updateCustomerInformation(Customer customer);
	void delete(int customerId);

}
