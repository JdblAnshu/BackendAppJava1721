package com.java.backend.app.spring_java_backend.dto.request;

import lombok.Builder;

import java.time.LocalDateTime;


public class EventRequest {

	private String name;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Boolean isActive;
	private Long venueId;  // Foreign key for venue

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

	public Long getVenueId() {
		return venueId;
	}

	public void setVenueId(Long venueId) {
		this.venueId = venueId;
	}
}
