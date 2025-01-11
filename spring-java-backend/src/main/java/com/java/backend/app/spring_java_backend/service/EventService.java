package com.java.backend.app.spring_java_backend.service;

import com.java.backend.app.spring_java_backend.dto.request.EventRequest;
import com.java.backend.app.spring_java_backend.dto.response.EventResponse;
import com.java.backend.app.spring_java_backend.model.EventDetails;
import com.java.backend.app.spring_java_backend.model.Venue;
import com.java.backend.app.spring_java_backend.repository.EventRepository;
import com.java.backend.app.spring_java_backend.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	VenueRepository venueRepository;

	public EventDetails addEvent(EventRequest eventRequest) {

		Venue venue = venueRepository.findById(eventRequest.getVenueId())
				.orElseThrow(() -> new RuntimeException("Venue not found"));

		EventDetails eventDetails = new EventDetails();
		eventDetails.setName(eventRequest.getName());
		eventDetails.setStartTime(eventRequest.getStartTime());
		eventDetails.setEndTime(eventRequest.getEndTime());
		eventDetails.setActive(eventRequest.getActive());
		eventDetails.setVenue(venue);  // Setting the venue

		return eventRepository.save(eventDetails);
	}

	public String cancelEvent(Long id) {
		return null;
	}

	public EventDetails getEventById(Long eventId) {
		return eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event by Id not found"));
	}

	public List<EventResponse> getEventByVenueId(Long venueId) {
		List<EventDetails> eventDetails =  eventRepository.findByVenueId(venueId);
		return eventDetails.stream().map(EventResponse::to).toList();
	}
}
