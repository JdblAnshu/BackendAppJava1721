package com.java.backend.app.spring_java_backend.service;

import com.java.backend.app.spring_java_backend.model.Venue;
import com.java.backend.app.spring_java_backend.repository.VenueRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {
    @Autowired
    private VenueRepository venueRepository;
    public Venue addVenue(Venue venue) {
        return venueRepository.save(venue);
    }
}
