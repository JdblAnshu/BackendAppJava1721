package com.java.backend.app.spring_java_backend.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventRequest {

    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isActive;
    private Long venueId;  // Foreign key for venue
    private Long capacity;
}
