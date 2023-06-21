package com.codeurmas.orderapi.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fullName;
	private String regCode;
	private String email;
	private String phone;
	
	public Customer() {
		
	}	
	
	public Customer(Long id, String fullName) {
		this.id = id;
		this.fullName = fullName;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getRegCode() {
		return regCode;
	}
	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fullName=" + fullName + "]";
	}
	
}
