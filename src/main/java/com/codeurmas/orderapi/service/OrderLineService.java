package com.codeurmas.orderapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeurmas.orderapi.repository.OrderLineRepository;
import com.codeurmas.orderapi.exception.OrderException;
import com.codeurmas.orderapi.model.OrderLine;
import com.codeurmas.orderapi.model.Orders;

@Service
@Transactional
public class OrderLineService {
	    @Autowired
	    private OrderLineRepository repo;
	     
	    public List<OrderLine> listAll() {
	        return repo.findAll();
	    }
	     
	    public OrderLine save(OrderLine orderLine) {
	        return repo.save(orderLine);
	    }
	     
	    public OrderLine get(long id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(long id) {
	        repo.deleteById(id);
	    }
	    
	    public OrderLine update(OrderLine orderLine) {
			OrderLine orderLineChecked = repo.findById(orderLine.getId()).orElseThrow(() -> new OrderException("OrderLine#" + orderLine.getId() + " not found"));
			
			OrderLine orderLineSaved = repo.save(orderLine);
			
			System.out.println("OrderLineService update100: " + orderLine);
			System.out.println("OrderLineService update200: " + orderLineSaved);
			return orderLineSaved;
		}
}
