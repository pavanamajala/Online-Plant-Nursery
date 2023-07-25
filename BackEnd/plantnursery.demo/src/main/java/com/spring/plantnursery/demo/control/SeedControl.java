package com.spring.plantnursery.demo.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.plantnursery.demo.entity.Seed;
import com.spring.plantnursery.demo.service.ISeedService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SeedControl {
	@Autowired
	private ISeedService seedservice;
	
	@PostMapping("/seed")
	public Seed addSeed(@RequestBody Seed seed) {
		return seedservice.addSeed(seed);
	}
	@GetMapping("/seed")
	public List<Seed> getSeed() {
		return seedservice.viewAllSeeds();
	}
	@PutMapping("/seed")
	public Seed updateSeed(@RequestBody Seed seed) {
		return seedservice.updateSeed(seed);
	}
//	@DeleteMapping("/seed")
//	public Seed deleteSeed(Seed seed) {
//		return seedservice.deleteSeed(seed);
//	}
	@DeleteMapping("/seed/{id}")
	public Seed deleteSeed(@PathVariable int id) {
		return seedservice.deleteSeed(id);
	}
	@GetMapping("/seed/{id}")
	public Optional<Seed> viewSeed(@PathVariable int id) {
		return seedservice.viewSeed(id);
	}
//	@GetMapping("/seed/{commonName}")
//	public Seed viewSeed(@PathVariable String commonName) {
//		return seedservice.viewSeed(commonName);
//	}
//	@GetMapping("/seed/{typeOfSeed}")
//	public List<Seed> getSeed(@PathVariable String typeOfSeed) {
//		return seedservice.viewAllSeeds(typeOfSeed);
//	}
}
