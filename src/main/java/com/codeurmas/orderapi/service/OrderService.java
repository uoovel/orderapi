package com.codeurmas.orderapi.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeurmas.orderapi.repository.CustomerRepository;
import com.codeurmas.orderapi.repository.OrderlineRepository;
import com.codeurmas.orderapi.repository.OrderRepository;
import com.codeurmas.orderapi.repository.ProductRepository;
import com.codeurmas.orderapi.service.dto.OrderDto;
import com.codeurmas.orderapi.service.dto.OrderlineDto;
import com.codeurmas.orderapi.exception.OrderException;
import com.codeurmas.orderapi.model.Customer;
import com.codeurmas.orderapi.model.Orderline;
import com.codeurmas.orderapi.model.Ordermodel;
import com.codeurmas.orderapi.model.Product;

@Service
@Transactional
public class OrderService {
	    @Autowired
	    private OrderRepository repo;
	    @Autowired
	    private CustomerRepository repoCustomer;
	    @Autowired
	    private ProductRepository repoProduct;
	    @Autowired
	    private OrderlineRepository repoOrderline;   
	    
	    public List<OrderDto> listAll() {
			List<Ordermodel> orderList = repo.findAll();			
			List<OrderDto> finalList = new ArrayList();
			for (Ordermodel ord : orderList) {	
				OrderDto orderdto = new OrderDto();
				Long id = ord.getId();
				orderdto.setId(id);
				orderdto.setDateString(ord.getDatestring());						
				orderdto.setCustomer(ord.getCustomer());
				//create lists for all Orders
				List<Orderline> linesForEach  = new ArrayList();
				linesForEach = repoOrderline.findByOrdermodel(ord);
				List<OrderlineDto> listofrowDto = new ArrayList();
				for(Orderline line: linesForEach) {
					OrderlineDto dtoLine = new OrderlineDto();
					dtoLine.setProductName(line.getProduct().getName());
					dtoLine.setQuantity(line.getQuantity());
					listofrowDto.add(dtoLine);
				}
				if(!linesForEach.isEmpty()) {
					orderdto.setLineDto(listofrowDto);
				}else {
					linesForEach = null;
				}	
				finalList.add(orderdto);
			}			
			
			return finalList;
		}		
	    
	    public Ordermodel save(Ordermodel ordermodel) {
	        return repo.save(ordermodel);
	    }   
	     
	    public Ordermodel get(long id) {
	        return repo.findById(id).get();
	    }
	    
	    public Ordermodel update(Ordermodel ordermodel) {
			Ordermodel orderChecked = repo.findById(ordermodel.getId()).orElseThrow(() -> new OrderException("Ordermodel#" + ordermodel.getId() + " not found"));
			return repo.save(ordermodel);
		}
	    
	    public Ordermodel partialUpdate(Ordermodel ordermodel) {
			Ordermodel ordermodelChecked = repo.findById(ordermodel.getId()).orElseThrow(() -> new OrderException("Ordermodel#" + ordermodel.getId() + " not found"));
	        repo.save(ordermodelChecked);
	        return ordermodelChecked;
		}	
	     
	    public void delete(long id) {
	        repo.deleteById(id);
	    }
	
		public List<Ordermodel> getOrdersByDate(String dateString) {
			return repo.findAll(dateString);
		}
		
}
