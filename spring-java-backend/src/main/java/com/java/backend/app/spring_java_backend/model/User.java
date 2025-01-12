package com.java.backend.app.spring_java_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "UserDtl")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String address;
    Integer age;
    @Enumerated(EnumType.STRING)
    Gender gender;
    Boolean isAdmin;
}
