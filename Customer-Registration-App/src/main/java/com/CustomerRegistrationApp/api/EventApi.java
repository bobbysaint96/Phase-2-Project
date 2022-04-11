package com.CustomerRegistrationApp.api;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerRegistrationApp.domain.Event;

@RestController
@RequestMapping("/events")
public class EventApi {
	
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
	
	@RequestMapping
	public Collection<Event> getAll() {
		return eventsList;
	}
	
	@RequestMapping("/id/{id}")
	public Event getById(@PathVariable long id) {
		Event ret = null;
		for (Event x: eventsList) {
			if (x.getId() == id) {
				ret = x;
			}
		}
		return ret;
	}
	
	
}
