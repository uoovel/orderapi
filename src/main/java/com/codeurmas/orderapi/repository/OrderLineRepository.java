package com.codeurmas.orderapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeurmas.orderapi.model.OrderLine;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long>{

}
