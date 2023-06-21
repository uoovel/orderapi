package com.codeurmas.orderapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeurmas.orderapi.repository.OrderlineRepository;
import com.codeurmas.orderapi.exception.OrderException;
import com.codeurmas.orderapi.model.Orderline;
import com.codeurmas.orderapi.model.Ordermodel;


@Service
@Transactional
public class OrderlineService {
	    @Autowired
	    private OrderlineRepository repo;
	     
	    public List<Orderline> listAll() {
	        return repo.findAll();
	    }
	     
	    public Orderline save(Orderline orderline) {
	        return repo.save(orderline);
	    }
	     
	    public Orderline get(long id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(long id) {
	        repo.deleteById(id);
	    }
	    
	    public Orderline update(Orderline orderline) {
			Orderline orderlineChecked = repo.findById(orderline.getId()).orElseThrow(() -> new OrderException("Orderline#" + orderline.getId() + " not found"));
			Orderline orderlineSaved = repo.save(orderline);
			return orderlineSaved;
		}
	    
	    public Orderline partialUpdate(Orderline orderline) {
			Orderline orderlineChecked = repo.findById(orderline.getId()).orElseThrow(() -> new OrderException("Orderline#" + orderline.getId() + " not found"));
	        repo.save(orderlineChecked);
	        return orderlineChecked;
		}	
	     
}
