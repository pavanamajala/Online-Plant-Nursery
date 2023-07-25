package com.spring.plantnursery.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.plantnursery.demo.entity.Seed;

public interface ISeedRepository extends JpaRepository<Seed, Integer>{

}
