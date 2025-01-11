package com.java.backend.app.spring_java_backend.dto.response;


import com.java.backend.app.spring_java_backend.model.EventDetails;

import java.time.LocalDateTime;


public class EventResponse {

	Long id;

	String name;

	LocalDateTime startTime;

	LocalDateTime endTime;

	Boolean isActive;

	public EventResponse(Long id, String name, LocalDateTime startTime, LocalDateTime endTime, Boolean isActive) {
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isActive = isActive;
	}

	public static EventResponse to(EventDetails eventDetails) {
		return new EventResponse(eventDetails.getId(), eventDetails.getName(), eventDetails.getStartTime(), eventDetails.getEndTime(), eventDetails.getActive());
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
}
