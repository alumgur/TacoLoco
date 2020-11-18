package com.dl.tacoLoco.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.tacoLoco.Entity.CustomerEntity;
import com.dl.tacoLoco.Exception.RecordNotFoundException;
import com.dl.tacoLoco.Repository.CustomerRepository;

@Service
public class CustomerDao {
	@Autowired
	CustomerRepository customerRepository;
	
	public List<CustomerEntity> getAllCustomers() {
		List<CustomerEntity> customerList = customerRepository.findAll();
		
		if(customerList.size() > 0) {
			return customerList;
		} else {
			return new ArrayList<CustomerEntity>();
		}
	}
	
	public CustomerEntity getCustomerById(Long id) throws RecordNotFoundException {
		Optional<CustomerEntity> customer = customerRepository.findById(id);
		
		if(customer.isPresent()) {
			return customer.get();
		} else {
			throw new RecordNotFoundException("No customer record exist for given id");
		}
	}
	
	public CustomerEntity createOrUpdateCustomer(CustomerEntity customer) throws RecordNotFoundException {
		Optional<CustomerEntity> myCustomer = customerRepository.findById(customer.getId());
		
		if(myCustomer.isPresent()) {
			CustomerEntity newCustomer = myCustomer.get();
			newCustomer.setName(customer.getName());
			newCustomer.setAddress(customer.getAddress());
			newCustomer.setState(customer.getState());
			newCustomer.setCity(customer.getCity());
			newCustomer.setZipcode(customer.getZipcode());
			
			newCustomer = customerRepository.save(newCustomer);
			
			return newCustomer;
		} else {
			customer = customerRepository.save(customer);
			
			return customer;
		}
	}
	
	public void deleteCustomerByID(Long id) throws RecordNotFoundException {
		Optional<CustomerEntity> customer = customerRepository.findById(id);
		
		if(customer.isPresent()) {
			customerRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No customer record exist for given id");
		}
	}
}
