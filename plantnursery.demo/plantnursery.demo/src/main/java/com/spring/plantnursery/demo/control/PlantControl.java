package com.spring.plantnursery.demo.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.plantnursery.demo.entity.Plant;
import com.spring.plantnursery.demo.service.IPlantService;

@RestController
@RequestMapping("/api")
public class PlantControl {
	@Autowired
	IPlantService iPlantService;
	@PostMapping("/plant")
	public Plant addPlant(@RequestBody Plant plant) {
		return iPlantService.addPlant(plant);
	}
	@GetMapping("/plant")
	public List<Plant> getPlant() {
		return iPlantService.viewAllPlants();
	}
	@DeleteMapping("/plant/{id}")
	public Plant deletePlant(@PathVariable int id) {
		return iPlantService.deletePlant(id);
	}
	@DeleteMapping("/plant")
	public Plant deletePlant(Plant plant) {
		return iPlantService.deletePlant(plant);
	}
	@PutMapping("/plant")
	public Plant updatePlant(@RequestBody Plant plant) {
		return iPlantService.updatePlant(plant);
	}
	@GetMapping("/plant/{id}")
	public Plant viewPlant(@PathVariable int id) {
		return iPlantService.viewPlant(id);
	}
	@GetMapping("/plant/{commonName}")
	public Plant viewPlant(@PathVariable String commonName) {
		return iPlantService.viewPlant(commonName);
	}
	@GetMapping("/plant/{typeOfPlant}")
	public List<Plant> getPlant(@PathVariable String typeOfPlant) {
		return iPlantService.viewAllPlants(typeOfPlant);
	}
}
