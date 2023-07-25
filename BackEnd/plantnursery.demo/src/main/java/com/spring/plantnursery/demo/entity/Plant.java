
package com.spring.plantnursery.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Plant")

//Lombok annotaions
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Plant {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="plantId")
	private int plantId;
	
	@Column(name="plantHeight")
	private int plantHeight;
	
	@Column(name="plantSpread")
	private String plantSpread;
	
	@Column(name="commonName")
	private String commonName;
	
	@Column(name="bloomTime")
	private String bloomTime;
	
	@Column(name="medicinalOrCullinaryUse")
	private String medicinalOrCullinaryUse;
	
	@Column(name="difficultyLevel")
	private String difficultyLevel;
	
	@Column(name="temperature")
	private String temperature;
	
	@Column(name="typeOfPlant")
	private String typeOfPlant;
	
	@Column(name="pantDescription")
	private String pantDescription;
	
	@Column(name="plantsStock")
	private int plantsStock;
	
	@Column(name="plantCost")
	private double plantsCost;

	
}