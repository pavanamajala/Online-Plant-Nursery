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

import com.spring.plantnursery.demo.entity.Planter;
import com.spring.plantnursery.demo.service.IPlanterService;

@RestController
@RequestMapping("/api")
public class PlanterControl {
	
	@Autowired
	IPlanterService iPlanterService;
	@PostMapping("/planter")
	public Planter addPlanter(@RequestBody Planter planter) {
		return iPlanterService.addPlanter(planter);
	}
	@GetMapping("/planter")
	public List<Planter> getPlanter(){ 
		return iPlanterService.viewAllPlanter();
	}
	@DeleteMapping("/planter")
	public Planter deletePlanter(Planter planter) {
		return iPlanterService.deletePlanter(planter);
	}
	@DeleteMapping("/planter/{id}")
	public Planter deletePlanter( @PathVariable int id) {
		return iPlanterService.deletePlanter(id);
	}
	@PutMapping("/planter")
	public Planter updatePlanter(@RequestBody Planter planter) {
		return iPlanterService.updatePlanter(planter);
	}
	@GetMapping("/planter/{id}")
	public Planter viewPlanter( @PathVariable int id) {
		return iPlanterService.viewPlanter(id);
	}
	@GetMapping("/plant/{planterShape}")
	public Planter viewPlant(@PathVariable String planterShape) {
		return iPlanterService.viewPlanter(planterShape);
	}
	@GetMapping("/plant/{mincost}/{maxcost}")
	public List<Planter> viewPlant(@PathVariable double  mincost, double maxcost) {
		return iPlanterService.viewAllPlanter(mincost, maxcost);
	}
}
