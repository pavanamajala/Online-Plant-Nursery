package com.spring.plantnursery.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring.plantnursery.demo.entity.Customer;
import com.spring.plantnursery.demo.repository.ICustomerRepository;

@Service
public class ICustomerService {
	@Autowired
	private ICustomerRepository icp; 
	public Customer addCustomer(Customer customer) {
		return icp.save(customer);
	}
	public Customer updateCustomer(Customer tenant) {
		int custId=tenant.getCustomerId();
		Optional<Customer> custContainer = icp.findById(custId);
		if(custContainer.isPresent()) {
			Customer old=custContainer.get();
			old.setAddress(tenant.getAddress());
			old.setCustomerEmail(tenant.getCustomerEmail());
			old.setCustomerId(tenant.getCustomerId());
			old.setPassword(tenant.getPassword());
			old.setCustomername(tenant.getCustomername());
			old.setUsername(tenant.getUsername());
			return icp.save(old);
		} else {
			return icp.save(tenant);
		}
	}
	public Customer deleteCustomer(Customer tenant) {
		int custId=tenant.getCustomerId();
		Optional<Customer> custContainer = icp.findById(custId);
		if(custContainer.isPresent()) {
			Customer cust=custContainer.get();
			icp.delete(cust);
			return cust;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Is Not Found");
		}
	}
	public Customer viewCustomer(int customerid) {
		return icp.getById(customerid);
	}
	public List<Customer> viewAllCustomers() {
		return icp.findAll();
	}
	public  void validateCustomer(String userName, String password) {
		List<Customer> cust=icp.findAll();
		for(int i=0;i<cust.size();i++) {
			if(cust.get(i).getUsername().equals(userName)) {
				cust.get(i).setPassword(password);
			}
		}
	}
	public Customer deleteCustomer(int id) {
		Optional<Customer> custContainer = icp.findById(id);
		if(custContainer.isPresent()) {
			Customer cust=custContainer.get();
			icp.delete(cust);
			return cust;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Is Not Found");
		}
	}
}