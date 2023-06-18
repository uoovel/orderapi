package com.codeurmas.orderapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codeurmas.orderapi.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{

	@Query("SELECT o FROM Orders o WHERE o.datestring LIKE %?1%")
	public List<Orders> search(String keyword);

	@Query("SELECT o FROM Orders o WHERE o.datestring LIKE %?1%")
	public Orders getByDate(String randDate);

	@Query("SELECT o FROM Orders o WHERE o.datestring LIKE %?1%")
	public List<Orders> findAll(String dateString);
}
