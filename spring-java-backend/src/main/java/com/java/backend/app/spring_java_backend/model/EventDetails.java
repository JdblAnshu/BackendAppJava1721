package com.java.backend.app.spring_java_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
public class EventDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;
	String name;
	LocalDateTime startTime;
	LocalDateTime endTime;
	Boolean isActive;
	@ManyToOne
	@JoinColumn(name="venue_id", nullable = false, referencedColumnName = "id")
	Venue venue;
}