package com.java.backend.app.spring_java_backend.controller;

import com.java.backend.app.spring_java_backend.dto.request.BookingRequest;
import com.java.backend.app.spring_java_backend.model.BookingDetails;
import com.java.backend.app.spring_java_backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;


    @PostMapping("/ticket")
    public ResponseEntity<BookingDetails> bookTicket(@RequestBody BookingRequest bookingRequest) {
    BookingDetails bookingObj = bookingService.bookTicket(bookingRequest);

    return new ResponseEntity<>(bookingObj, HttpStatus.CREATED);
    }

    @PatchMapping("/cancel")
    public void cancelTicket(@PathVariable Long id) {
    }

    @GetMapping
    public void getAllBookings() {

    }
}
