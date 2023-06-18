package com.codeurmas.orderapi.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeurmas.orderapi.repository.CustomerRepository;
import com.codeurmas.orderapi.repository.OrderLineRepository;
import com.codeurmas.orderapi.repository.OrderRepository;
import com.codeurmas.orderapi.repository.ProductRepository;
import com.codeurmas.orderapi.exception.OrderException;
import com.codeurmas.orderapi.model.Customer;
import com.codeurmas.orderapi.model.OrderLine;
import com.codeurmas.orderapi.model.Orders;
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
	    private OrderLineRepository repoOrderLine;
	     
	    public List<Orders> listAll(String keyword, String keyCustomer, String keyProduct) {
	    	/*
	    	if(keyword != null) {	    		
	    		return repo.search(keyword);
	    	}
	    	
	    	if(keyCustomer != null) {
	    		List<Orders> listAllOrders = repo.findAll();
	    		List<Orders> listByCustomer = new ArrayList<>();
	    		List<Customer> selectedCustomerList = new ArrayList<>();	    		
	    		selectedCustomerList = repoCustomer.search(keyCustomer);	    		
	    		//koostada valiklist
	    		for (Customer customer : selectedCustomerList) {
	    			Long id = customer.getId();
	    			for(Orders order : listAllOrders) {
	    				if((order.getCustomer().getId()) == id) {
	    					listByCustomer.add(order);
	    				}
	    			}
	    		}	    		
	    		return listByCustomer;
	    	}
	    	
	    	if(keyProduct != null) {
	    		List<Orders> listAllOrders = repo.findAll();
	    		List<Orders> listByProduct = new ArrayList<>();
	    		List<Product> selectedProductList = new ArrayList<>();
	    		selectedProductList = repoProduct.search(keyProduct);
	    		List<OrderLine> listAllOrderLines = repoOrderLine.findAll();
	    		//nullida Order-ites olevad listid
				List<Orders> ordersNulledList = new ArrayList<>();
	    		for(Orders ord : listAllOrders) {
					ord.setListOrderLines(null);
					ordersNulledList.add(ord);
				}
	    		List<OrderLine> selOrderLineList = new ArrayList<>();
	    		for (Product product : selectedProductList) {
	    			Long id = product.getId();
	    			for(OrderLine ordLine : listAllOrderLines) {
	    				if((ordLine.getProduct().getId()) == id) {
	    					selOrderLineList.add(ordLine);
	    				}
	    			}
	    		}
	    		List<OrderLine> localOrderLineList = new ArrayList<>();
	    		for(Orders order : ordersNulledList) {
	    			//System.out.println("OrderService100>order.getID():" + order.getId());
	    			for (OrderLine ordLine : selOrderLineList) {
	    			Long orderId = ordLine.getOrder().getId();	    			
	    				if(orderId == order.getId()) {
	    					//System.out.println("OrderService200>Product:" + ordLine.getProduct().getName());
	    					localOrderLineList.add(ordLine);
	    				}
	    				
	    				
	    			}
	    			if(!localOrderLineList.isEmpty()) {
	    				for(OrderLine ordLine : localOrderLineList) {
	    					//System.out.println("OrderService>300: " + ordLine.getProduct().getName());
	    				}
	    				Orders orderSelect = new Orders();
	    				orderSelect.setListOrderLines(localOrderLineList);
	    				orderSelect.setCustomer(order.getCustomer());
	    				orderSelect.setDatestring(order.getDatestring());
	    				orderSelect.setId(order.getId());
		    			listByProduct.add(orderSelect);
	    			}  			
	    			
	    			localOrderLineList = new ArrayList<>();
	    		}
	    		
				return listByProduct;
	    	}*/
	    		
	        return repo.findAll();
	    }	    
	    
	    public Orders save(Orders order) {
	        return repo.save(order);
	    }
	     
	    public Orders get(long id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(long id) {
	        repo.deleteById(id);
	    }
	    
	    public Orders update(Orders order) {
			Orders orderChecked = repo.findById(order.getId()).orElseThrow(() -> new OrderException("Order#" + order.getId() + " not found"));
			return repo.save(order);
		}

		//public Orders getOrderByOrderDate(String randDate) {
		//	// TODO Auto-generated method stub
		//	return repo.getByDate(randDate);
		//}

		public List<Orders> getOrdersByDate(String dateString) {
			// TODO Auto-generated method stub
			return repo.findAll(dateString);
		}

		public List<Orders> listAll() {
			// TODO Auto-generated method stub
			return repo.findAll();
		}

		
}
