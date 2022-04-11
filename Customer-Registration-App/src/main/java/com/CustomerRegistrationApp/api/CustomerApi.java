package com.CustomerRegistrationApp.api;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerRegistrationApp.domain.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerApi {

	ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public CustomerApi() {
		Customer one = new Customer(1, "One", "One@bah.com", "1_Password");
		Customer two = new Customer(2, "Two", "Two@bah.com", "2_Password");
		Customer three = new Customer(1, "Three", "Three@bah.com", "3_Password");
		Customer four = new Customer(1, "Four", "Four@bah.com", "4_Password");
		Customer five = new Customer(1, "Five", "Five@bah.com", "5_Password");
		
		customerList.add(one);
		customerList.add(two);
		customerList.add(three);
		customerList.add(four);
		customerList.add(five);
	}
	
	@RequestMapping
	public Collection<Customer> getAll() {
		return customerList;
	}
	
	@RequestMapping("/id/{id}")
	public Customer getById(@PathVariable long id) {
		Customer ret = null;
		for (Customer x: customerList) {
			if (x.getId() == id) {
				ret = x;
			}
		}
		return ret;
	}
	
	
	
}
