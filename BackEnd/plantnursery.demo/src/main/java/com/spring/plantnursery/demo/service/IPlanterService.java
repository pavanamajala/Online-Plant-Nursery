package com.spring.plantnursery.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring.plantnursery.demo.entity.Planter;
import com.spring.plantnursery.demo.repository.IPlanterRepository;

@Service
public class IPlanterService {
	
	@Autowired
	private IPlanterRepository ipr;
	public Planter addPlanter(Planter planter) {
		return ipr.save(planter);
	}
	public Planter updatePlanter(Planter planter) {
		int planterId=planter.getPlanterId();
		Optional<Planter> pc=ipr.findById(planterId);
		if(pc.isPresent()) {
			Planter old=pc.get();
			old.setDrainageHoles(planter.getDrainageHoles());
			old.setPlanterCapacity(planter.getPlanterCapacity());
			old.setPlanterColour(planter.getPlanterColour());
			old.setPlanterCost(planter.getPlanterCost());
			old.setPlanterHeight(planter.getPlanterHeight());
			old.setPlanterId(planter.getPlanterId());
			old.setPlanterShape(planter.getPlanterShape());
			old.setPlanterStock(planter.getPlanterStock());
			old.setPlants(planter.getPlants());
			old.setSeeds(planter.getSeeds());
			return ipr.save(old);
		} else {
			return ipr.save(planter);
		}
	}
	public Planter deletePlanter(Planter planter){
		int planterId=planter.getPlanterId();
		Optional<Planter> pc=ipr.findById(planterId);
		if(pc.isPresent()) {
			Planter old=pc.get();
			ipr.delete(old);
			return old;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Planter Is Not Found");
		}
	}
	public Planter viewPlanter(int  planterid) {
		return ipr.getById(planterid);
	}
	public Planter viewPlanter(String  planterShape) {
		List<Planter> planter=ipr.findAll();
		for(int i=0;i<planter.size();i++) {
			if(planter.get(i).getPlanterShape().equals(planterShape)) {
				return planter.get(i);
			} 
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"PlanterShape Is Not Found");
	}
	public List<Planter> viewAllPlanter(){
		return ipr.findAll();
	}
	public List<Planter> viewAllPlanter(double minCost, double maxCost){
		List<Planter> planter=ipr.findAll();
		for(int i=0;i<planter.size();i++) {
			if(!(planter.get(i).getPlanterCost()>minCost && planter.get(i).getPlanterCost()<maxCost)) {
				planter.remove(i);
			}
		}
		return planter;
	}
	public Planter deletePlanter(int id) {
		Optional<Planter> pc=ipr.findById(id);
		if(pc.isPresent()) {
			Planter old=pc.get();
			ipr.delete(old);
			return old;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Planter Is Not Found");
		}
	}
}
