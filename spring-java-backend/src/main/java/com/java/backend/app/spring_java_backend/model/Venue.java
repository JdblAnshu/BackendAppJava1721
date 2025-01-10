package com.java.backend.app.spring_java_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

import java.util.List;

@Entity
@Table
@Getter
@Setter
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
    private List<EventDetails> events;

}
