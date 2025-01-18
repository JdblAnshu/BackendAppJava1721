package com.java.backend.app.spring_java_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

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

    Long adminId;

    @OneToMany(mappedBy = "venue")
    @JsonIgnoreProperties("venue")
    private List<EventDetails> events;

    @Override
    public String toString() {
        return "Venue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", adminId=" + adminId +
                '}';
    }
}
