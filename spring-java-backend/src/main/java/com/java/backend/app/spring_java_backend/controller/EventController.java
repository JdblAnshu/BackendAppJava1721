package com.java.backend.app.spring_java_backend.controller;

import com.java.backend.app.spring_java_backend.dto.request.EventRequest;
import com.java.backend.app.spring_java_backend.dto.response.EventResponse;
import com.java.backend.app.spring_java_backend.model.EventDetails;
import com.java.backend.app.spring_java_backend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	EventService eventService;

	@PostMapping("/add")
	public ResponseEntity<EventDetails> addEvent(@RequestBody EventRequest eventRequest) {
		EventDetails event = eventService.addEvent(eventRequest);
		return new ResponseEntity<>(event, HttpStatus.CREATED);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> cancelEvent(@PathVariable Long id) {
		String msg = eventService.cancelEvent(id);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@GetMapping("/{eventId}")
	public ResponseEntity<EventDetails> getEventById(@PathVariable Long eventId) {
		EventDetails eventDetails = eventService.getEventById(eventId);
		return new ResponseEntity<>(eventDetails, HttpStatus.OK);
	}

	@GetMapping("/venue/{venueId}")
	public ResponseEntity<List<EventResponse>> getEventByVenueId(@PathVariable Long venueId) {
		List<EventResponse> eventDetailsList = eventService.getEventByVenueId(venueId);
		return new ResponseEntity<>(eventDetailsList, HttpStatus.OK);
	}

}
