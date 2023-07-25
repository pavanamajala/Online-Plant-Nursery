package com.spring.plantnursery.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.*;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Customer")

//Lombok annotaions
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Customer {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CustomerId")
	private int CustomerId;
	
	@Column(name="Customername")
	private String Customername;
	
	@Column(name="CustomerEmail")
	private String CustomerEmail;

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address")
	private Address address;
	
}