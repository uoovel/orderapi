package com.codeurmas.orderapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeurmas.orderapi.repository.OrderLineRepository;
import com.codeurmas.orderapi.model.OrderLine;

@Service
@Transactional
public class OrderLineService {
	    @Autowired
	    private OrderLineRepository repo;
	     
	    public List<OrderLine> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(OrderLine orderLine) {
	        repo.save(orderLine);
	    }
	     
	    public OrderLine get(long id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(long id) {
	        repo.deleteById(id);
	    }
}
