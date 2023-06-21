package com.codeurmas.orderapi.model;
//import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String skuCode;
	
	@Column
	private double unitPrice;
	
    public Product() {
		
	}
	
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
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", skuCode=" + skuCode + ", unitPrice=" + unitPrice + "]";
	}    
}
