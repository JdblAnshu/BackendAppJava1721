package com.java.backend.app.spring_java_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table
public class BookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	UUID id;

//	@ManyToOne
//	@JoinColumn(name="user_id", nullable = false)
//	User user;

	@ManyToOne
	@JoinColumn(name="event_id", nullable = false)
	EventDetails event;

	Long numberOfSeats;

	Long phone;

	@Enumerated(EnumType.STRING)
	Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public EventDetails getEvent() {
		return event;
	}

	public void setEvent(EventDetails event) {
		this.event = event;
	}

	public Long getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Long numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
}
