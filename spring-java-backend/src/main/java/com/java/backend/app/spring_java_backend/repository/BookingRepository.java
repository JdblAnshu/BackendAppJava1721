package com.java.backend.app.spring_java_backend.repository;

import com.java.backend.app.spring_java_backend.model.BookingDetails;
import com.java.backend.app.spring_java_backend.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<BookingDetails, UUID> {
}
