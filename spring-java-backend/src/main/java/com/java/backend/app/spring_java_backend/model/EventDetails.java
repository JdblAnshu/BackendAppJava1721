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


	public @Min(value = 1, message = "Capacity must be greater than 0") Long getCapacity() {
		return capacity;
	}

	public void setCapacity(@Min(value = 1, message = "Capacity must be greater than 0") Long capacity) {
		this.capacity = capacity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Boolean getActive() {
		return isActive;
	}

	public void setActive(Boolean active) {
		isActive = active;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
}