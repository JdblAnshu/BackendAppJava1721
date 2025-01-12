package com.java.backend.app.spring_java_backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class EventDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;

	String name;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	LocalDateTime startTime;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	LocalDateTime endTime;

	@Min(value = 1, message = "Capacity must be greater than 0")
	Long capacity;

	Boolean isActive;

	@ManyToOne
	@JsonIgnoreProperties("events")
	@JoinColumn(name="venue_id", nullable = false, referencedColumnName = "id")
	Venue venue;
}