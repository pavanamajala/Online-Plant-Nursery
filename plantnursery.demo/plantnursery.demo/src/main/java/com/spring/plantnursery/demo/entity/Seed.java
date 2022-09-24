
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
@Table(name="Seed")

//Lombok annotaions
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Seed {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="seedId")
	private int seedId;
	
	@Column(name="commonName")
	private String commonName;
	
	@Column(name="bloomTime")
	private String bloomTime;
	
	@Column(name="watering")
	private String watering;
	
	@Column(name="difficultyLevel")
	private String difficultyLevel;
	
	@Column(name="temperature")
	private String temperature;
	
	@Column(name="typeOfSeed")
	private String typeOfSeed;
	
	@Column(name="seedDescription")
	private String seedDescription;
	
	@Column(name="seedsStock")
	private int seedsStock;
	
	@Column(name="seedsCost")
	private double seedsCost;
	
	@Column(name="seedsPerPacket")
	private int seedsPerPacket;
	
}