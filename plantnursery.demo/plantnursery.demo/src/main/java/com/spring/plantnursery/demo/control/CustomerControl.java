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

import com.spring.plantnursery.demo.entity.Customer;
import com.spring.plantnursery.demo.service.ICustomerService;

@RestController
@RequestMapping("/api")
public class CustomerControl {

	@Autowired
	ICustomerService iCustomerService;
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer cust) {
		return iCustomerService.addCustomer(cust);
	}
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer cust) {
		return iCustomerService.updateCustomer(cust);
	}
	@GetMapping("/customer")
	public List<Customer> viewCustomer() {
		return iCustomerService.viewAllCustomers();
	}
	@PutMapping("/customer/{userName},{password}")
	public void validateCustomer(@PathVariable String userName, String password) {
		 iCustomerService.validateCustomer(userName, password);
	}
	@DeleteMapping("/customer/{id}")
	public Customer deleteCustomer(@PathVariable int id) {
		return iCustomerService.deleteCustomer(id);
	}
	@DeleteMapping("/customer")
	public Customer deleteCustomer(Customer cust) {
		return iCustomerService.deleteCustomer(cust);
	}
	@GetMapping("/customer/{id}")
	public Customer viewById(@PathVariable int id) {
		return iCustomerService.viewCustomer(id);
	}
}
