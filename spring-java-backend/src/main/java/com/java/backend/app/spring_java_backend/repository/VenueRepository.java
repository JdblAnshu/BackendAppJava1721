package com.java.backend.app.spring_java_backend.repository;

import com.java.backend.app.spring_java_backend.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
