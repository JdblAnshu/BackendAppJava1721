package com.java.backend.app.spring_java_backend.service;

import com.java.backend.app.spring_java_backend.exception.ResourceNotFoundException;
import com.java.backend.app.spring_java_backend.model.Venue;
import com.java.backend.app.spring_java_backend.repository.VenueRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VenueService {
	@Autowired
	private VenueRepository venueRepository;

	public Venue addVenue(Venue venue) {
		return venueRepository.save(venue);
	}

	public Venue updateVenue(Long id, Venue venue) {

		Venue existingVenue = venueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Venue not found"));

		if (null != venue.getAddress()) {
			existingVenue.setAddress(venue.getAddress());
		}

		if (null != venue.getName()) {
			existingVenue.setName(venue.getName());
		}

		if (null != venue.getAdminId()) {
			existingVenue.setAdminId(venue.getAdminId());
		}

        return venueRepository.save(existingVenue);

	}

	public String deleteVenue(Long id) {
		venueRepository.deleteById(id);
		return "Delete " + id + " Successfully";
	}
}
