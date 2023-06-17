package com.codeurmas.orderapi.model;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;

@Entity
public class Orders implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column	
	private String datestring;
	
	
	
	@OneToMany(mappedBy = "order")
	private List<OrderLine> listOrderLines = new ArrayList<>();
	
	public List<OrderLine> getListOrderLines() {
		return listOrderLines;
	}
	public void setListOrderLines(List<OrderLine> listOrderLines) {
		this.listOrderLines = listOrderLines;
	}
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Orders() {
		
	}
	public String getDatestring() {
		return datestring;
	}
	public void setDatestring(String date) {
		this.datestring = date;
	}
	public void setId(Long id) {
		this.id = id;
	}
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
		return id;
	}
}
