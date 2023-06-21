package com.codeurmas.orderapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeurmas.orderapi.exception.OrderException;
import com.codeurmas.orderapi.model.Customer;
import com.codeurmas.orderapi.service.CustomerService;
import com.codeurmas.orderapi.service.dto.CustomerDto;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/customers/all", produces = {"application/json"})
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customerList = customerService.listAll();
		return ResponseEntity
				.ok()
				.body(customerList);
	}
	
	@PostMapping(value = "/customers", produces = {"application/json"}, consumes = { "application/json"})
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer ){
		if (customer == null) {
            //throw new CustomerException("Customer data are missing");
        }		
        return ResponseEntity
                .ok()
                .body(customerService.save(customer));
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> get(@PathVariable Long id){
		Customer customer = customerService.get(id);
		return ResponseEntity
				.ok()
				.body(customer);
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> update(@RequestBody Customer customer, @PathVariable Long id){
		if (customer == null) {
            throw new OrderException("Customer data are missing");
        }
		customer.setId(id);
		return ResponseEntity
                .ok()
                .body(customerService.update(customer));
	}
	
	@PatchMapping(value = "/customers/{id}",  produces = {"application/json"}, consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Customer> partialUpdateCustomer(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody Customer customer){
        if (customer == null) {
            throw new OrderException("Customer data are missing");
        }
        customer.setId(id);
        return ResponseEntity
                .ok()
                .body(customerService.partialUpdate(customer));
    }
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		customerService.delete(id);
	    return ResponseEntity.noContent().build();       
	}
	
}
