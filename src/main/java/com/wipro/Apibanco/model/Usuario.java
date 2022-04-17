package com.wipro.Apibanco.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tb_usuarios")
public class Usuario implements Serializable {
	
	Random random = new Random();
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	String id;
	
	@Size(max = 10, min = 3)
	String nome;
	
	String email;
	
	String senha;
	
	String sobrenome;
	
	String cartao;

	public Usuario() {
		super();
		this.cartao = randomNumberCreditCard();
	}

	public Usuario(String nome, String email, String senha, String sobrenome, String cartao) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.sobrenome = sobrenome;
		this.cartao = cartao;
	}
// getters, setters, hashcode e equals ...

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	public String randomNumberCreditCard() {
		String initNumber = "5155 ";
		String numberCreditCard = "";

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				numberCreditCard += Integer.toString(random.nextInt(10));
			}
			numberCreditCard += " ";
		}
		return initNumber + numberCreditCard;
	}
	
}
