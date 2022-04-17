package com.wipro.Apibanco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.Apibanco.model.Movement;
import com.wipro.Apibanco.repository.MovementRepository;

@Service
public class MovementService {
	@Autowired
	private MovementRepository repository;
	
	public Movement findByDate(String date) {
		Optional<Movement> obj = repository.findById(date);
		return obj.orElse(null);
	}
	
	public List<Movement> findAll(){
		return repository.findAll();
	}
	
	public Movement update(String date, Movement obj) {
		Movement newObj = findByDate(date);
		newObj.setBalance(obj.getBalance());
		newObj.setDate(obj.getDate());
		newObj.setNumberCard(obj.getNumberCard());
		return repository.save(newObj);
	}
	public Movement create(Movement obj) {
		return repository.save(obj);
	}
	public void deleteByDate(String date) {
		findByDate(date);
		repository.deleteById(date);
	}
}
