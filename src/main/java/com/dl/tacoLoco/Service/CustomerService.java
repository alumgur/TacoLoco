package com.dl.tacoLoco.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.dl.tacoLoco.Repository.CustomerRepository;
import com.dl.tacoLoco.Entity.Customer;

@Component
public class CustomerService {
	private CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void removeCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
	
	public void updateCustomer(Customer customer) {
		
	}
}
