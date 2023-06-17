package com.codeurmas.orderapi.model;
//import org.hibernate.validator.constraints.Length;
import javax.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	//@Length(min=1, max=100, message="{Check name}")
	private String name;
	
	@Column
	private String skuCode;
	
	@Column
	private double unitPrice;
	
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Product() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
    public Long getId() {
		return id;
	}
}
