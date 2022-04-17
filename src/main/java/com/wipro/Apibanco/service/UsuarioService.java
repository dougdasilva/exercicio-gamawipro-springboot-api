package com.wipro.Apibanco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.Apibanco.model.Usuario;
import com.wipro.Apibanco.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	public Usuario findById(String id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario update(String id, Usuario obj) {
		Usuario newObj = findById(id);
		newObj.setNome(obj.getNome());
		newObj.setSobrenome(obj.getSobrenome());
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(obj.getSenha());
		return repository.save(newObj);
	}

	public Usuario create(Usuario obj) {
		return repository.save(obj);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
}
