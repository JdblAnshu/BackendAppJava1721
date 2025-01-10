package com.java.backend.app.spring_java_backend.repository;

import com.java.backend.app.spring_java_backend.model.EventDetails;
import com.java.backend.app.spring_java_backend.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventDetails, Long> {
}
