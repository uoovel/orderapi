package com.codeurmas.orderapi.service.dto;

public class CustomerDto {
	private Long id;
	private String FullName;
	
	private CustomerDto() {
		
	}
	
	private Long getId() {
		return id;
	}
	private void setId(Long id) {
		this.id = id;
	}
	private String getFullName() {
		return FullName;
	}
	private void setFullName(String fullName) {
		FullName = fullName;
	}

	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", FullName=" + FullName + "]";
	}
	
}
