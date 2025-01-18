package com.java.backend.app.spring_java_backend.controller;

import com.java.backend.app.spring_java_backend.model.Venue;
import com.java.backend.app.spring_java_backend.service.VenueService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/venue")
public class VenueController {
	@Autowired
	private VenueService venueService;

	@PostMapping("/add")
	public ResponseEntity<Venue> addVenue(@RequestBody @Valid Venue venue) {
		Venue savedVenue = venueService.addVenue(venue);
		log.info("Venue added with id {}", venue.getId());
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

	@GetMapping("/page")
	public  ResponseEntity<Page<Venue>> getAllVenues(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String sortOrder
	) {
		Sort sort = sortOrder.equalsIgnoreCase(Sort.Direction.ASC.name())
				? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Venue> venues = venueService.getAllVenues(pageable);

		return new ResponseEntity<>(venues, HttpStatus.OK);
	}

	@GetMapping("/slice")
	public  ResponseEntity<Slice<Venue>> getAllVenuesSlice(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String sortOrder
	) {
		Sort sort = sortOrder.equalsIgnoreCase(Sort.Direction.ASC.name())
				? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable pageable = PageRequest.of(page, size, sort);
		Slice<Venue> venues = venueService.getAllVenuesSlice(pageable);

		return new ResponseEntity<>(venues, HttpStatus.OK);
	}
}
