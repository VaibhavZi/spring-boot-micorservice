/**
 * 
 */
package com.vz.bankcustomerservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vz.bankcustomerservice.dao.CustomerDao;
import com.vz.bankcustomerservice.domain.Customer;
import com.vz.bankcustomerservice.service.CustomerService;

/**
 * @author 10640143
 *
 */

@Component
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomers(int bankCode) {
		return customerDao.getAllCustomers(bankCode);
	}

	@Override
	public Customer getCustomerById(int bankCode, int customerId) {
		return customerDao.getCustomerById(bankCode, customerId);
	}

	@Override
	public List<Customer> findCustomersByFirstNameAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomerInformation(Customer customer) {
		return customerDao.updateCustomerInformation(customer);
	}

	@Override
	public void delete(int customerId) {
		customerDao.delete(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}
	

}
