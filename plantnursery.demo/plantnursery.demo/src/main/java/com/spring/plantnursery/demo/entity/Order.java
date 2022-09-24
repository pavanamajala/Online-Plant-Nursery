package com.spring.plantnursery.demo.entity;

import java.time.LocalDate;

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
@Table(name="myorder")

//Lombok annotaions
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Order {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bookingOrderId")
	private int bookingOrderId;
	
	@Column(name="orderDate")
	private LocalDate orderDate;
	
	@Column(name="transactionMode")
	private String transactionMode;

	@Column(name="quantity")
	private int quantity;
	
	@Column(name="totalCost")
	private Double totalCost;
	
	@OneToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="planters") 
	private Planter planters;
	
}