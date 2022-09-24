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

import com.spring.plantnursery.demo.entity.Order;
import com.spring.plantnursery.demo.service.IOrderService;

@RestController
@RequestMapping("/api")
public class OrderControl {

	@Autowired
	IOrderService iOrderService;
	@PostMapping("/order")
	public Order addOrder(@RequestBody Order order) {
		return iOrderService.addOrder(order);
	}
	@DeleteMapping("/order/{id}")
	public Order getOrder(@PathVariable int id){
		return iOrderService.deleteOrder(id);
	}
	@PutMapping("/order")
	public Order updateOrder(@RequestBody Order order) {
		return iOrderService.updateOrder(order);
	}
	@GetMapping("/order")
	public List<Order> getOrder(){
		return iOrderService.viewAllOrders();
	}
	@GetMapping("/orders/{id}")
	public Order getOrderById(@PathVariable int id){
		return iOrderService.viewOrder(id);
	}
 }
