package com.codeurmas.orderapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeurmas.orderapi.model.Orders;
import com.codeurmas.orderapi.model.Product;
import com.codeurmas.orderapi.service.OrderService;

@Controller
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	
	@PostMapping(value = "/orders", produces = {"application/json"}, consumes = { "application/json"})
	public ResponseEntity<Orders> createOrder(@RequestBody Orders order ){
		if (order == null) {
            //throw new ProductException("Product data are missing");
        }		
        return ResponseEntity
                .ok()
                .body(orderService.save(order));		
	}
	
	@PutMapping("/orders/{id}")
	public ResponseEntity<Orders> update(@RequestBody Orders order, @PathVariable Long id){
		
		if (order == null) {
            //throw new CroductException("User data are missing");
        }
		order.setId(id);
		return ResponseEntity
                .ok()
                .body(orderService.update(order));
	}
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
		orderService.delete(id);
	    return ResponseEntity.noContent().build();       
	}
	
	
	
	
	

}