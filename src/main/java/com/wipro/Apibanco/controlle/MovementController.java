package com.wipro.Apibanco.controlle;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wipro.Apibanco.model.Movement;
import com.wipro.Apibanco.service.MovementService;

@RestController
@RequestMapping("/movements")
@CrossOrigin("*")
public class MovementController {

	@Autowired
	private MovementService service;
	
	@GetMapping("/{date}")
	public ResponseEntity<Movement> GetById(@PathVariable String date) {
		Movement obj = this.service.findByDate(date);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Movement>> GetAll() {
		List<Movement> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Movement> Post(@RequestBody Movement movement) {
		Movement newObj = service.create(movement);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{date}").buildAndExpand(newObj.getDate()).toUri();
		return ResponseEntity.status(HttpStatus.GONE).body(service.create(movement));
		//return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{date}")
	public ResponseEntity<Movement> Put(@PathVariable String date, @RequestBody Movement obj) {
		Movement newMovement = service.update(date, obj);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newMovement);
	}

	@DeleteMapping("/{date}")
	public ResponseEntity<Void> Delete(@PathVariable String date) {
		service.deleteByDate(date);
		return ResponseEntity.noContent().build();
	}
}
