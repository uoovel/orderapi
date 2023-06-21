package com.codeurmas.orderapi.model;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;

@Entity
@Table
public class Ordermodel implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
		
	@Column	
	private String datestring;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(mappedBy = "ordermodel")
	private List<Orderline> orderlines = new ArrayList<>(); 	
	
	public Ordermodel() {
		
	}
	
	public List<Orderline> getOrderlines() {
		return orderlines;
	}
	
	public void setOrderlines(List<Orderline> orderlines) {
		this.orderlines = orderlines;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	
    public Long getId() {
		return id;
	}
    
	@Override
	public String toString() {
		return "Ordermodel [id=" + id + ", datestring=" + datestring + ", customer=" + customer + "]";
	}
}
