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
@Table(name="planter")

//Lombok annotaions
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Planter {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="planterId")
	private int planterId;
	
	@Column(name="planterHeight")
	private float planterHeight;
	
	@Column(name="planterCapacity")
	private int planterCapacity;
	
	@Column(name="drainageHoles")
	private int drainageHoles;
	
	@Column(name="planterColour")
	private int planterColour;
	
	@Column(name="planterShape")
	private String planterShape;
	
	@Column(name="planterStock")
	private int planterStock;
	
	@Column(name="planterCost")
	private int planterCost;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="plants")
	private Plant plants;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="seeds")
	private Seed seeds;
	
}