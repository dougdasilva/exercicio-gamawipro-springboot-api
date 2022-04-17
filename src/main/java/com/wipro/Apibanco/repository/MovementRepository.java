package com.wipro.Apibanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.Apibanco.model.Movement;

@Repository
public interface MovementRepository extends JpaRepository<Movement, String> {
	

}
