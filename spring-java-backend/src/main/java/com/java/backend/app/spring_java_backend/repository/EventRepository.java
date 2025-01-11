package com.java.backend.app.spring_java_backend.repository;

import com.java.backend.app.spring_java_backend.model.EventDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<EventDetails, Long> {
	List<EventDetails> findByVenueId(Long venueId);
}
