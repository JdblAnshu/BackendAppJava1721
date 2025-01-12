package com.java.backend.app.spring_java_backend.dto.response;


import com.java.backend.app.spring_java_backend.model.EventDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class EventResponse {

    Long id;

    String name;

    LocalDateTime startTime;

    LocalDateTime endTime;

    Boolean isActive;

    public static EventResponse to(EventDetails eventDetails) {
        return new EventResponse(eventDetails.getId(), eventDetails.getName(), eventDetails.getStartTime(),
                eventDetails.getEndTime(), eventDetails.getIsActive());
    }
}
