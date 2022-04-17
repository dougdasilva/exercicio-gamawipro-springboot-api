package com.wipro.Apibanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.Apibanco.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
}
