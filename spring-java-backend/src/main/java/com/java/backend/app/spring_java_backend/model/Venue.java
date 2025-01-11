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
