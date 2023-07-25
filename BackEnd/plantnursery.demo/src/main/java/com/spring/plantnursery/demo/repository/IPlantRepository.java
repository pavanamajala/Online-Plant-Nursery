package com.spring.plantnursery.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.plantnursery.demo.entity.Plant;

public interface IPlantRepository extends JpaRepository<Plant, Integer>{

}
