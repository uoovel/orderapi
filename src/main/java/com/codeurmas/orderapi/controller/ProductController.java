package com.codeurmas.orderapi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeurmas.orderapi.exception.OrderException;
import com.codeurmas.orderapi.model.Orderline;
import com.codeurmas.orderapi.model.Product;
import com.codeurmas.orderapi.service.ProductService;
//import com.codeurmas.orderapi.service.dto.ProductDto;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/products/all", produces = {"application/json"})
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> productList = productService.listAll();	
		return ResponseEntity
				.ok()
				.body(productList);
	}
	
	@PostMapping(value = "/products", produces = {"application/json"}, consumes = { "application/json"})
	public ResponseEntity<Product> createProduct(@RequestBody Product product ){
		if (product == null) {
            throw new OrderException("Product data are missing");
        }		
        return ResponseEntity
                .ok()
                .body(productService.save(product));		
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> get(@PathVariable Long id){
		Product product = productService.get(id);
		return ResponseEntity
				.ok()
				.body(product);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id){
		if (product == null) {
            throw new OrderException("Product data are missing");
        }
		product.setId(id);
		return ResponseEntity
                .ok()
                .body(productService.update(product));
	}	
	
	@PatchMapping(value = "/products/{id}",  produces = {"application/json"}, consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Product> partialUpdateCustomer(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody Product product){
        if (product == null) {
            throw new OrderException("Orderline data are missing");
        }
        product.setId(id);
        return ResponseEntity
                .ok()
                .body(productService.partialUpdate(product));
    }
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.delete(id);
	    return ResponseEntity.noContent().build();       
	}
	
}
