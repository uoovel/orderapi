package com.codeurmas.orderapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeurmas.orderapi.repository.ProductRepository;
import com.codeurmas.orderapi.exception.OrderException;
import com.codeurmas.orderapi.model.Customer;
import com.codeurmas.orderapi.model.Product;

@Service
@Transactional
public class ProductService {
	   
	   @Autowired
	    private ProductRepository repo;
	     
	    public List<Product> listAll() {
	        return repo.findAll();
	    }
	     
	    public Product save(Product product) {
	        return repo.save(product);
	    }
	     
	    public Product get(Long id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(Long id) {
	        repo.deleteById(id);
	    }
	    
	    public Product update(Product product) {
			Product productChecked = repo.findById(product.getId()).orElseThrow(() -> new OrderException("Product#" + product.getId() + " not found"));
			return repo.save(product);
		}
	    
}
