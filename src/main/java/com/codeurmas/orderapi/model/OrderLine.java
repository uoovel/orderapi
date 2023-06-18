package com.codeurmas.orderapi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderLine implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	
	
    public OrderLine() {
		
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	 ///////////////
	@ManyToOne
	@JoinColumn(name = "orders_id")
	private Orders order;
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	///////////////////
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public void setId(Long id) {
		this.id = id;
	}
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", quantity=" + quantity +  "]";
	}
    
}
