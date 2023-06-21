package com.codeurmas.orderapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeurmas.orderapi.model.Orderline;
import com.codeurmas.orderapi.model.Product;
import com.codeurmas.orderapi.exception.OrderException;
import com.codeurmas.orderapi.service.OrderlineService;

@Controller
@RequestMapping("/api")
public class OrderlineController {
	
	@Autowired
	private OrderlineService orderlineService;

	
	@PostMapping(value = "/orderlines", produces = {"application/json"}, consumes = { "application/json"})
	public ResponseEntity<Orderline> createOrderline(@RequestBody Orderline orderline ){
		if (orderline == null) {
            throw new OrderException("Orderline data are missing");
        }		
        return ResponseEntity
                .ok()
                .body(orderlineService.save(orderline));		
	}
	
	@PutMapping(value = "/orderlines/{id}", produces = {"application/json"}, consumes = { "application/json"})
	public ResponseEntity<Orderline> update(@RequestBody Orderline orderline, @PathVariable Long id){
		if (orderline == null) {
            throw new OrderException("Orderline data are missing");
        }
		orderline.setId(id);
		Orderline orderlineUp = orderlineService.update(orderline);		
		return ResponseEntity
                .ok()
                .body(orderlineUp);
	}
	
	@DeleteMapping("/orderlines/{id}")
	public ResponseEntity<Void> deleteOrderline(@PathVariable Long id) {
		orderlineService.delete(id);
	    return ResponseEntity.noContent().build();       
	}
	/*
	@GetMapping(value = "/orderlines/all", produces = {"application/json"})
	public ResponseEntity<List<Orderline>> getAllOrderlines() {
		List<Orderline> orderlineList = orderlineService.listAll();		
		return ResponseEntity
				.ok()
				.body(orderlineList);
	}*/
}
