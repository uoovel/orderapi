package com.codeurmas.orderapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import com.codeurmas.orderapi.model.Ordermodel;
import com.codeurmas.orderapi.model.Product;
import com.codeurmas.orderapi.service.OrderService;
import com.codeurmas.orderapi.service.dto.OrderDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping(value = "/orders/all", produces = {"application/json"})
	public ResponseEntity<String> getAllOrders() throws JsonProcessingException {
		List<OrderDto> orderList = orderService.listAll();		
		return ResponseEntity
				.ok()
				.body(new ObjectMapper().writeValueAsString(orderList));
	}

	@PostMapping(value = "/orders", produces = {"application/json"}, consumes = { "application/json"})
	public ResponseEntity<Ordermodel> createOrder(@RequestBody Ordermodel order ){
		if (order == null) {
            //throw new ProductException("Product data are missing");
        }		
        return ResponseEntity
                .ok()
                .body(orderService.save(order));		
	}
	
	@PutMapping("/orders/{id}")
	public ResponseEntity<Ordermodel> update(@RequestBody Ordermodel order, @PathVariable Long id){
		if (order == null) {
            //throw new CroductException("User data are missing");
        }
		order.setId(id);
		return ResponseEntity
                .ok()
                .body(orderService.update(order));
	}
	
	@PatchMapping(value = "/orders/{id}",  produces = {"application/json"}, consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Ordermodel> partialUpdateCustomer(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody Ordermodel ordermodel){
        if (ordermodel == null) {
            throw new OrderException("Order data are missing");
        }
        ordermodel.setId(id);
        return ResponseEntity
                .ok()
                .body(orderService.partialUpdate(ordermodel));
    }
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
		orderService.delete(id);
	    return ResponseEntity.noContent().build();       
	}
	
	
	@GetMapping("/orders/{dateString}")
	public ResponseEntity<List<Ordermodel>> getOrdersByDate(@PathVariable String dateString){
		List<Ordermodel> ordersListByDate = orderService.getOrdersByDate(dateString);
		return ResponseEntity
				.ok()
				.body(ordersListByDate);
	}

}
