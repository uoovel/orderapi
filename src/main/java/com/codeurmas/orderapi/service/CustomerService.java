//https://www.codejava.net/frameworks/spring-boot/spring-boot-restful-crud-api-examples-with-mysql-database

package com.codeurmas.orderapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeurmas.orderapi.exception.OrderException;
import com.codeurmas.orderapi.model.Customer;

import com.codeurmas.orderapi.repository.CustomerRepository;
import com.codeurmas.orderapi.service.dto.CustomerDto;
import com.codeurmas.orderapi.service.mapper.CustomerMapper;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> listAll() {
		
		return customerRepository.findAll();
	}
	
	public Customer save(Customer customer) {
		Customer customerSaved = customerRepository.save(customer);		
		return customerSaved;		
	}
	
	public Customer get(Long id) {
		return customerRepository.findById(id).get();
	}
	
	public void delete(Long id) {
        customerRepository.deleteById(id);
    }
	
	public Customer update(Customer customer) {
		Customer customerChecked = customerRepository.findById(customer.getId()).orElseThrow(() -> new OrderException("Customer#" + customer.getId() + " not found"));
		return customerRepository.save(customer);
	}	

}
