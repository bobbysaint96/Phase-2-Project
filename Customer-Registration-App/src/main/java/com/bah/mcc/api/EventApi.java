package com.bah.mcc.api;

import java.net.URI;
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
import com.bah.mcc.repository.EventRepository;

@RestController
@RequestMapping("/events")
public class EventApi {
	
	@Autowired
	EventRepository repo;
	
	/**
	ArrayList<Event> eventsList = new ArrayList<Event>();
	
	public EventApi() {
		
		Event one = new Event(1, "Code 1", "Title 1", "Desc 1");
		Event two = new Event(2, "Code 2", "Title 2", "Desc 2");
		Event three = new Event(3, "Code 3", "Title 3", "Desc 3");
		Event four = new Event(4, "Code 4", "Title 4", "Desc 4");
		Event five = new Event(5, "Code 5", "Title 5", "Desc 5");
		
		eventsList.add(one);
		eventsList.add(two);
		eventsList.add(three);
		eventsList.add(four);
		eventsList.add(five);
	}
	**/
	@GetMapping
	public Iterable<Event> getAll() {
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Event> getById(@PathVariable("eventId") long id) {
		return repo.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> addEvent(@RequestBody Event newEvent, UriComponentsBuilder uri) {
		if (newEvent.getId() != 0 || newEvent.getTitle() == null || newEvent.getDescription() == null || newEvent.getCode() == null) { 
			// Reject -	we'll assign the event id
			return ResponseEntity.badRequest().build();
		}
		newEvent = repo.save(newEvent);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newEvent.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	@PutMapping("/{eventId}")
	public ResponseEntity<?> putEvent(
			@RequestBody Event newEvent,
			@PathVariable("eventId") long eventId) 
	{
		if (newEvent.getId()!=eventId
				|| newEvent.getTitle()==null
				|| newEvent.getDescription() == null
				|| newEvent.getCode() == null) {
				return ResponseEntity.badRequest().build();
				}
				newEvent=repo.save(newEvent);
				return ResponseEntity.ok().build();
	}	
	
	@DeleteMapping("/{eventId}")
	public ResponseEntity<?> deleteEventById(@PathVariable("eventId") long id) {	
				repo.deleteById(id);
				return ResponseEntity.ok().build();
	}	
	
}
