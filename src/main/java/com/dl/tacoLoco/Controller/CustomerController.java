package com.dl.tacoLoco.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dl.tacoLoco.Entity.Customer;
import com.dl.tacoLoco.Exception.ResourceNotFoundException;
import com.dl.tacoLoco.Repository.CustomerRepository;

// Enables Angular app to communicate with H2 that is alive on port 8080
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));
		return ResponseEntity.ok().body(customer);
	}
	
	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		System.out.println(customer.getId());
		return customerRepository.save(customer);
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateEmployee(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		
		customer.setName(customerDetails.getName());
		customer.setAddress(customerDetails.getAddress());
		customer.setState(customerDetails.getState());
		customer.setCity(customerDetails.getCity());
		customer.setZip(customerDetails.getZip());
		
		final Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
	
	@DeleteMapping("/customers/{id}")
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
