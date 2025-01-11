package com.java.backend.app.spring_java_backend.dto.request;

import com.java.backend.app.spring_java_backend.dto.response.EventResponse;
import com.java.backend.app.spring_java_backend.model.BookingDetails;
import com.java.backend.app.spring_java_backend.model.EventDetails;

public class BookingRequest {
	Long numberOfSeats;

	Long phone;

	Long userId;

	Long eventId;

//	public static BookingDetails to(BookingRequest bookingRequest) {
//		return new BookingDetails();
//	}


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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
}
