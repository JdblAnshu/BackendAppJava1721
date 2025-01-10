package com.java.backend.app.spring_java_backend.controller;

import com.java.backend.app.spring_java_backend.model.Venue;
import com.java.backend.app.spring_java_backend.service.VenueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController
@RequestMapping("/venue")
public class VenueController {
	@Autowired
	private VenueService venueService;

	@PostMapping("/add")
	public ResponseEntity<Venue> addVenue(@RequestBody Venue venue){
		//log.info("Adding venue with venue id", venue.getId());
		Venue savedVenue = venueService.addVenue(venue);
		return new ResponseEntity<>(savedVenue, HttpStatus.CREATED);
	}

	public void updateVenue() {}
	public void deleteVenue() {}
}
