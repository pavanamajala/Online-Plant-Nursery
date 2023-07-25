package com.spring.plantnursery.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.plantnursery.demo.entity.Planter;

public interface IPlanterRepository extends JpaRepository<Planter, Integer>{

}
