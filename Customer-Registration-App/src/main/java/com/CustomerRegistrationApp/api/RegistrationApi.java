package com.CustomerRegistrationApp.api;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerRegistrationApp.domain.Registration;

@RestController
@RequestMapping("/registrations")
public class RegistrationApi {
	
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
	
	@RequestMapping("/id/{id}")
	public Registration getById(@PathVariable long id) {
		Registration ret = null;
		for (Registration x: registrationList) {
			if (x.getId() == id) {
				ret = x;
			}
		}
		return ret;
	}

}
