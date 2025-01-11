package com.java.backend.app.spring_java_backend.service;

import com.java.backend.app.spring_java_backend.model.User;
import com.java.backend.app.spring_java_backend.model.Venue;
import com.java.backend.app.spring_java_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User registerUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long id, User user) {

		User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

		if (null != user.getAddress()) {
			existingUser.setAddress(user.getAddress());
		}

		if (null != user.getName()) {
			existingUser.setName(user.getName());
		}

		if (null != user.getAdmin()) {
			existingUser.setAdmin(user.getAdmin());
		}

		return userRepository.save(existingUser);

	}
}
