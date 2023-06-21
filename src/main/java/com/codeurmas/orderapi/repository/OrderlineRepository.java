package com.codeurmas.orderapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codeurmas.orderapi.model.Orderline;
import com.codeurmas.orderapi.model.Ordermodel;

@Repository
public interface OrderlineRepository extends JpaRepository<Orderline, Long>{

	//@Query("SELECT o FROM Orderline o WHERE o.ordermodel_id = ?1")
	List<Orderline> findByOrdermodel(Ordermodel ordermodel);

}
