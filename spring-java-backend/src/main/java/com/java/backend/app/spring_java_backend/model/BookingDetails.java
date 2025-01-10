package com.java.backend.app.spring_java_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
public class BookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	UUID id;
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	User user;
	@ManyToOne
	@JoinColumn(name="event_id", nullable = false)
	EventDetails event;
	Long numberOfSeats;
	Long phone;

}
