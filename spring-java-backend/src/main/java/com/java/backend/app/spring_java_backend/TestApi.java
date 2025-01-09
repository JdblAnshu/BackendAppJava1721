package com.java.backend.app.spring_java_backend;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

	@GetMapping("/getDescription")
	public String getName(){
		return "Hi the bible and best practice";
	}

}
