package com.java.backend.app.spring_java_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

import java.util.List;

@Entity
@Table
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull(message = "Venue name cannot be null")
    String name;

    String address;

    @Min(value = 1, message = "Capacity must be greater than 0")
    Long capacity;

    Long adminId;

    @OneToMany(mappedBy = "venue")
    @JsonIgnoreProperties("venue")
    private List<EventDetails> events;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public @NotNull(message = "Venue name cannot be null") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Venue name cannot be null") String name) {
        this.name = name;
    }

    public @Min(value = 1, message = "Capacity must be greater than 0") Long getCapacity() {
        return capacity;
    }

    public void setCapacity(@Min(value = 1, message = "Capacity must be greater than 0") Long capacity) {
        this.capacity = capacity;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public List<EventDetails> getEvents() {
        return events;
    }

    public void setEvents(List<EventDetails> events) {
        this.events = events;
    }
}
