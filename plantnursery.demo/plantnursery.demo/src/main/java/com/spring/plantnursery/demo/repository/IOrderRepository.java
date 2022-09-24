package com.spring.plantnursery.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.plantnursery.demo.entity.Order;

public interface IOrderRepository extends JpaRepository<Order, Integer>{

}
