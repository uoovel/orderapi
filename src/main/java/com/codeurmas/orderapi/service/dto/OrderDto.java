package com.codeurmas.orderapi.service.dto;

import java.util.List;

import com.codeurmas.orderapi.model.Customer;

public class OrderDto {
	private Long id;
	private String dateString;
	private Customer customer;
	private List<OrderlineDto> lineDto;
	
	public OrderDto() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderlineDto> getLineDto() {
		return lineDto;
	}
	public void setLineDto(List<OrderlineDto> lineDto) {
		this.lineDto = lineDto;
	}

	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", customer=" + customer + ", lineDto=" + lineDto + "]";
	}
	
}
