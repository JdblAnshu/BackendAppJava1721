package com.java.backend.app.spring_java_backend.controller;

import com.java.backend.app.spring_java_backend.model.Venue;
import com.java.backend.app.spring_java_backend.service.VenueService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Slf4j
@RestController
@RequestMapping("/venue")
public class VenueController {
	@Autowired
	private VenueService venueService;

	@PostMapping("/add")
	public ResponseEntity<Venue> addVenue(@RequestBody @Valid Venue venue) {
		//log.info("Adding venue with venue id {}", venue.getId());
		Venue savedVenue = venueService.addVenue(venue);
		return new ResponseEntity<>(savedVenue, HttpStatus.CREATED);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Venue> updateVenue(@PathVariable Long id, @RequestBody Venue venue) {
		Venue updatedVenue = venueService.updateVenue(id, venue);
		return  new ResponseEntity<>(updatedVenue, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteVenue(@PathVariable Long id) {
		String msg = venueService.deleteVenue(id);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
