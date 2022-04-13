package com.bah.mcc.api;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.mcc.domain.Registration;
import com.bah.mcc.repository.RegistrationRepository;

@RestController
@RequestMapping("/registrations")
public class RegistrationApi {
	
	@Autowired
	RegistrationRepository repo;
	
	ArrayList<Registration> registrationList = new ArrayList<Registration>();
	
	public RegistrationApi() {
		
		Registration one = new Registration(1, 1, 1, "Date 1", "Note 1");
		Registration two = new Registration(2, 2, 2, "Date 2", "Note 2");
		Registration three = new Registration(3, 3, 3, "Date 3", "Note 3");
		Registration four = new Registration(4, 4, 4, "Date 4", "Note 4");
		Registration five = new Registration(5, 5, 5, "Date 5", "Note 5");
	
		registrationList.add(one);
		registrationList.add(two);
		registrationList.add(three);
		registrationList.add(four);
		registrationList.add(five);
	}
	
	@RequestMapping
	public Collection<Registration> getAll() {
		return registrationList;
	}
	
	@RequestMapping("/{id}")
	public Registration getById(@PathVariable long id) {
		Registration ret = null;
		for (Registration x: registrationList) {
			if (x.getId() == id) {
				ret = x;
			}
		}
		return ret;
	}
	
	@PostMapping
	public ResponseEntity<?> addRegistration(@RequestBody Registration newRegistration, UriComponentsBuilder uri) {
		//  Workshop:  Implementation to add a new registration; think about data validation and error handling.
		return null;
	}

	@PutMapping("/{eventId}")
	public ResponseEntity<?> putRegistration(
			@RequestBody Registration newRegistration,
			@PathVariable("eventId") long eventId) 
	{
		// Workshop: Implementation to update an event. Think about error handling.
		return null;
	}	
	
	@DeleteMapping("/{eventId}")
	public ResponseEntity<?> deleteRegistrationById(@PathVariable("eventId") long id) {
		//  Workshop:  Implementation to delete an event.  For discussion (do not implement unless
		//  you are sure you have time):  Are there checks you should make to ensure validity of 
		//  data across various entities?  Where should these checks be implemented.  Are there
		//  advantages and disadvantages to separating data into separate independent entities,
		//  each with it's own "microservice"?
		return null;
	}	

}
