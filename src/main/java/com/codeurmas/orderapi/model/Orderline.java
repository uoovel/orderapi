package com.codeurmas.orderapi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Orderline implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Integer quantity;	
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "ordermodel_id")
	private Ordermodel ordermodel;	
	
    public Orderline() {
		
	}  
    
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}	
	
	public Ordermodel getOrdermodel() {
		return ordermodel;
	}
	public void setOrdermodel(Ordermodel ordermodel) {
		this.ordermodel = ordermodel;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public void setId(Long id) {
		this.id = id;
	}

    public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Orderline [id=" + id + ", quantity=" + quantity + ", product=" + product + ", ordermodel=" + ordermodel + "]";
	}

	
    
}
