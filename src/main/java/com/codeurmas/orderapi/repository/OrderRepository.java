package com.codeurmas.orderapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codeurmas.orderapi.model.Ordermodel;

@Repository
public interface OrderRepository extends JpaRepository<Ordermodel, Long>{
	
	@Query("SELECT o FROM Ordermodel o WHERE o.datestring LIKE %?1%")
	public List<Ordermodel> findAll(String dateString);
	
}
