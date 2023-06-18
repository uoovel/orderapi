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

import com.codeurmas.orderapi.model.OrderLine;
import com.codeurmas.orderapi.model.Product;
import com.codeurmas.orderapi.exception.OrderException;
import com.codeurmas.orderapi.service.OrderLineService;

@Controller
@RequestMapping("/api")
public class OrderLineController {
	
	@Autowired
	private OrderLineService orderLineService;
	
	@GetMapping(value = "/orderlines/all", produces = {"application/json"})
	public ResponseEntity<List<OrderLine>> getAllOrderLines() {
		List<OrderLine> orderLineList = orderLineService.listAll();
		
		return ResponseEntity
				.ok()
				.body(orderLineList);
	}
	
	@PostMapping(value = "/orderlines", produces = {"application/json"}, consumes = { "application/json"})
	public ResponseEntity<OrderLine> createOrderLine(@RequestBody OrderLine orderLine ){
		if (orderLine == null) {
            throw new OrderException("OrderLine data are missing");
        }		
        return ResponseEntity
                .ok()
                .body(orderLineService.save(orderLine));		
	}
	
	@PutMapping(value = "/orderlines/{id}", produces = {"application/json"}, consumes = { "application/json"})
	public ResponseEntity<OrderLine> update(@RequestBody OrderLine orderLine, @PathVariable Long id){
		
		if (orderLine == null) {
            throw new OrderException("OrderLine data are missing");
        }
		orderLine.setId(id);
		System.out.println("OrderLineController>update: 100");
		OrderLine orderLineUp = orderLineService.update(orderLine);
		System.out.println("OrderLineController>update200: " + orderLine);
		System.out.println("OrderLineController>update250: ");
		System.out.println("OrderLineController>update300: " + orderLineUp);
		return ResponseEntity
                .ok()
                .body(orderLineUp);
	}
	
	@DeleteMapping("/orderlines/{id}")
	public ResponseEntity<Void> deleteOrderLine(@PathVariable Long id) {
		orderLineService.delete(id);
	    return ResponseEntity.noContent().build();       
	}
}
