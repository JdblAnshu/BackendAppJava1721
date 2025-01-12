package com.java.backend.app.spring_java_backend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {
	Long numberOfSeats;

	Long phone;

	Long userId;

	Long eventId;

//	public static BookingDetails to(BookingRequest bookingRequest) {
//		return new BookingDetails();
//	}
}
