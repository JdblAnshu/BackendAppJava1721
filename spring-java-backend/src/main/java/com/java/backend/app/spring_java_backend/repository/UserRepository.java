package com.java.backend.app.spring_java_backend.repository;

import com.java.backend.app.spring_java_backend.model.User;
import com.java.backend.app.spring_java_backend.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
