package com.wipro.Apibanco.model;

import java.util.Objects;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tb_usuarios2")
public class Movement {

	Random rand = new Random();
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	String numberCard;
	
	String date;
	
	Double balance;
	
	public Movement() {
		super();
		this.numberCard = generator();
	}

	public Movement(String numberCard, String date, Double balance) {
		super();
		this.numberCard = numberCard;
		this.date = date;
		this.balance = balance;
	}

	public String getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, date, numberCard);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movement other = (Movement) obj;
		return Objects.equals(balance, other.balance) && Objects.equals(date, other.date)
				&& Objects.equals(numberCard, other.numberCard);
	}
	public String generator() {
		String initNumber = "5555 ";
		String number = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				number += Integer.toString(rand.nextInt(10));
			}
			number += " ";
		}
		return initNumber + number;
	}
	public void deposit(double amount) {
		balance += amount;
	}
	public void withdraw(double amount) {
		balance -= amount * 0.02;
	}
	
	

}
