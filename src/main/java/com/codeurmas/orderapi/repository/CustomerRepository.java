package com.codeurmas.orderapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeurmas.orderapi.model.Customer;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
	//@Query("SELECT c FROM Customer c WHERE c.fullname LIKE %?1%")
	//public List<Customer> search(String keyCustomer);

	//@Query("SELECT c FROM Customer c WHERE c.fullname LIKE %?1%")
	//public Customer getByName(String testCustomerName);
}
