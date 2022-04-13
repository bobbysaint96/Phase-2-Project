package com.bah.mcc.api;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.mcc.domain.Customer;
import com.bah.mcc.repository.CustomersRepository;

@RestController
@RequestMapping("/customers")
public class CustomerApi {

	@Autowired
	CustomersRepository repo;

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

	@RequestMapping("/{id}")
	public Customer getById(@PathVariable long id) {
		Customer ret = null;
		for (Customer x : customerList) {
			if (x.getId() == id) {
				ret = x;
			}
		}
		return ret;
	}

	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer, UriComponentsBuilder uri) {
		// Workshop: Write an implementation that adds a new customer. Your
		// implementation should check to make sure that the name and email fields are
		// not null and that no id was passed (it will be auto generated when the record
		// is inserted. Remember REST semantics - return a reference to the newly
		// created
		// entity as a URI.
		return null;
	}

	// lookupCustomerByName GET
	@GetMapping("/byname/{username}")
	public ResponseEntity<?> lookupCustomerByNameGet(@PathVariable("username") String username,
			UriComponentsBuilder uri) {
		// Workshop: Write an implemenatation to look up a customer by name. Think about
		// what
		// your response should be if no customer matches the name the caller is
		// searching for.
		// With the data model implemented in CustomersRepository, do you need to handle
		// more than
		// one match per request?
		return null;
	}

	// lookupCustomerByName POST
	@PostMapping("/byname")
	public ResponseEntity<?> lookupCustomerByNamePost(@RequestBody String username, UriComponentsBuilder uri) {
		// Workshop: Write an implementation to look up a customer by name, using POST
		// semantics
		// rather than GET. You should be able to make use of most of your implmentation
		// for
		// lookupCustomerByNameGet().
		return null;
	}

	@PutMapping("/{customerId}")
	public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer,
			@PathVariable("customerId") long customerId) {
		// Workshop: Write an implementation to update or create a new customer with an
		// HTTP PUT, with the
		// requestor specifying the customer ID. Are there error conditions to be
		// handled? How much data
		// validation should you implement considering that customers are stored in a
		// CustomersRepository object.
		return null;
	}

	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") long id) {
		// Implement a method to delete a customer. What is an appropriate response?
		//
		// For discussion (do not worry about implementation): What are some ways of
		// handling
		// a "delete"? Is it always the right thing from a business point of view to
		// literally
		// delete a customer entry? If you did actually delete a customer entry, are
		// there issues
		// you could potentially run into later?
		return null;
	}

}
