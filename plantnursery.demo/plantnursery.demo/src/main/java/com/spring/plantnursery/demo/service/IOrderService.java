package com.spring.plantnursery.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring.plantnursery.demo.entity.Order;
import com.spring.plantnursery.demo.repository.IOrderRepository;

@Service
public class IOrderService {
	
	@Autowired
	private IOrderRepository iop;
	
	public Order addOrder(Order order) {
		return iop.save(order);
	}
	public Order updateOrder(Order order) {
		int ordId=order.getBookingOrderId();
		Optional<Order> ordContainer = iop.findById(ordId);
		if(ordContainer.isPresent()) {
			Order old=ordContainer.get();
			old.setBookingOrderId(order.getBookingOrderId());
			old.setOrderDate(order.getOrderDate());
			old.setPlanters(order.getPlanters());
			old.setQuantity(order.getQuantity());
			old.setTotalCost(order.getTotalCost());
			old.setTransactionMode(order.getTransactionMode());
			return iop.save(old);
		}else {
		return iop.save(order);
			}
	}
	public Order deleteOrder(int orderId) {
		Optional<Order> ordContainer = iop.findById(orderId);
		if(ordContainer.isPresent()) {
			Order old=ordContainer.get();
			iop.delete(old);
			return old;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Order Is Not Found");
		}
	}
	public Order viewOrder(int orderId) {
		return iop.getById(orderId);
	}
	public List<Order> viewAllOrders(){
		return iop.findAll();
	}
}