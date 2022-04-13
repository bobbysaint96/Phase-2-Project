package com.bah.mcc.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.mcc.domain.Event;
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

	@GetMapping
	public Iterable<Registration> getAll() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Registration> getById(@PathVariable("id") long id) {
		return repo.findById(id);
	}

	long id;
	long event_id;
	long customer_id;
	String registration_date;
	String notes;

	@PostMapping
	public ResponseEntity<?> addRegistration(@RequestBody Registration newRegistration, UriComponentsBuilder uri) {
		if (newRegistration.getId() != 0 || newRegistration.getEvent_id() != 0 || newRegistration.getCustomer_id() != 0
				|| newRegistration.getRegistration_date() == null || newRegistration.getNotes() != null) {
			return ResponseEntity.badRequest().build();
		}
		newRegistration = repo.save(newRegistration);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newRegistration.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	@PutMapping("/{eventId}")
	public ResponseEntity<?> putRegistration(@RequestBody Registration newRegistration,
			@PathVariable("eventId") long eventId) {
		if (newRegistration.getId() != 0 || newRegistration.getEvent_id() != 0 || newRegistration.getCustomer_id() != 0
				|| newRegistration.getRegistration_date() == null || newRegistration.getNotes() != null) {
			return ResponseEntity.badRequest().build();
		}
		newRegistration = repo.save(newRegistration);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{eventId}")
	public ResponseEntity<?> deleteRegistrationById(@PathVariable("eventId") long id) {
		repo.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
