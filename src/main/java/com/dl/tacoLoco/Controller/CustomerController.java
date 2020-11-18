package com.dl.tacoLoco.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dl.tacoLoco.Dao.CustomerDao;
import com.dl.tacoLoco.Entity.CustomerEntity;
import com.dl.tacoLoco.Exception.RecordNotFoundException;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerDao customerService;
	
	@GetMapping
	public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
		List<CustomerEntity> list = customerService.getAllCustomers();
		
		return new ResponseEntity<List<CustomerEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable("id") Long id) throws RecordNotFoundException {
		CustomerEntity customer = customerService.getCustomerById(id);
		
		return new ResponseEntity<CustomerEntity>(customer, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CustomerEntity> createOrUpdateCustomer(CustomerEntity customer) throws RecordNotFoundException {
		CustomerEntity updated = customerService.createOrUpdateCustomer(customer);
		
		return new ResponseEntity<CustomerEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteCustomerById(@PathVariable("id") Long id) throws RecordNotFoundException{
		customerService.deleteCustomerByID(id);
		return HttpStatus.FORBIDDEN;
	}
}
