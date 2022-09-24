package com.spring.plantnursery.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.plantnursery.demo.entity.Customer;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
}
