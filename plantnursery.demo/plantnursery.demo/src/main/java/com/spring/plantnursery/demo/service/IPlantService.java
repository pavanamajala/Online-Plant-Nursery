package com.spring.plantnursery.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring.plantnursery.demo.entity.Plant;
import com.spring.plantnursery.demo.repository.IPlantRepository;

@Service
public class IPlantService {
	
	@Autowired
	private IPlantRepository ipr;
	public Plant addPlant(Plant plant) {
		return ipr.save(plant);
	}
	public Plant updatePlant(Plant plant) {
		int plantId=plant.getPlantId();
		Optional<Plant> pc=ipr.findById(plantId);
		if(pc.isPresent()) {
			Plant old=pc.get();
			old.setBloomTime(plant.getBloomTime());
			old.setCommonName(plant.getCommonName());
			old.setDifficultyLevel(plant.getDifficultyLevel());
			old.setMedicinalOrCullinaryUse(plant.getMedicinalOrCullinaryUse());
			old.setPantDescription(plant.getPantDescription());
			old.setPlantHeight(plant.getPlantHeight());
			old.setPlantsCost(plant.getPlantsCost());
			old.setPlantSpread(plant.getPlantSpread());
			old.setPlantsStock(plant.getPlantsStock());
			old.setTemperature(plant.getTemperature());
			old.setTypeOfPlant(plant.getTypeOfPlant());
			old.setPlantId(plantId);
			return ipr.save(old);
		} else {
			return ipr.save(plant);
		}
	}
	public Plant deletePlant(Plant plant){
		int plantId=plant.getPlantId();
		Optional<Plant> pc=ipr.findById(plantId);
		if(pc.isPresent()) {
			Plant old=pc.get();
			ipr.delete(old);
			return old;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Plant Is Not Found");
		}
	}
	public Plant viewPlant(int plantId) {
		return ipr.getById(plantId);
	}
	public Plant viewPlant(String commonName) {
		List<Plant> plant=ipr.findAll();
		for(int i=0;i<plant.size();i++) {
			if(plant.get(i).getCommonName().equals(commonName)) {
				return plant.get(i);
			} 
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"commonName Is Not Found");
	}
	public List<Plant> viewAllPlants(){
		return ipr.findAll();
	}
	public List<Plant> viewAllPlants(String typeOfPlant){
		List<Plant> plant=ipr.findAll();
		for(int i=0;i<plant.size();i++) {
			if(!(plant.get(i).getTypeOfPlant().equals(typeOfPlant))) {
				plant.remove(i);
			}
		}
		return plant;
	}
	public Plant deletePlant(int id) {
		Optional<Plant> pc=ipr.findById(id);
		if(pc.isPresent()) {
			Plant old=pc.get();
			ipr.delete(old);
			return old;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Plant Is Not Found");
		}
	}
}
