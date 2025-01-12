package com.java.backend.app.spring_java_backend.service;

import com.java.backend.app.spring_java_backend.dto.request.BookingRequest;
import com.java.backend.app.spring_java_backend.model.BookingDetails;
import com.java.backend.app.spring_java_backend.model.EventDetails;
import com.java.backend.app.spring_java_backend.model.Status;
import com.java.backend.app.spring_java_backend.model.User;
import com.java.backend.app.spring_java_backend.repository.BookingRepository;
import com.java.backend.app.spring_java_backend.repository.EventRepository;
import com.java.backend.app.spring_java_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	EventRepository eventRepository;

	@Autowired
	UserRepository userRepository;

	public BookingDetails bookTicket(BookingRequest bookingRequest) {
		EventDetails eventDetails = eventRepository.findById(bookingRequest.getEventId()).orElseThrow(() -> new RuntimeException("Event not found"));

		if (bookingRequest.getNumberOfSeats() > eventDetails.getCapacity()) {
			throw new RuntimeException("Seats not available");
		}

		User userDetails = userRepository.findById(bookingRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
		eventDetails.setCapacity(eventDetails.getCapacity() - bookingRequest.getNumberOfSeats());//TODO

		BookingDetails bd = new BookingDetails();
		bd.setEvent(eventDetails);
		bd.setStatus(Status.BOOKED);
		bd.setUser(userDetails);
		bd.setNumberOfSeats(bookingRequest.getNumberOfSeats());
		bd.setPhone(bookingRequest.getPhone());


		return bookingRepository.save(bd);
	}

	public BookingDetails cancelTicket(UUID uuid) {
		BookingDetails bd = bookingRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Booking Detail not found"));
		EventDetails ed = bd.getEvent();
		ed.setCapacity(ed.getCapacity() + bd.getNumberOfSeats());
		bd.setStatus(Status.CANCELLED);
		bd.setEvent(ed);
		return bookingRepository.save(bd);
	}

	public BookingDetails getBookingById(UUID uuid) {
		return bookingRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Booking Detail not found"));
	}
}
