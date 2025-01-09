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
	Long userId;
	Long eventId;
	Long numberOfSeats;
	Long phone;

}
