package com.codeurmas.orderapi.service.dto;

public class OrderlineDto {
	private String productName;
	private Integer quantity;
    public OrderlineDto() {
		  
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderlineDto [productName=" + productName + ", quantity=" + quantity + "]";
	}    

}
