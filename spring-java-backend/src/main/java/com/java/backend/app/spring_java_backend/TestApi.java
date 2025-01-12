package com.java.backend.app.spring_java_backend;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

	@GetMapping("/getDescription")
	public String getName(){
		return "Hi the bible and best practice";
	}

	@GetMapping("/divide")
	public String divide(@RequestParam int numerator, @RequestParam int denominator) {
		// This will throw an ArithmeticException if denominator is zero
		int result = numerator / denominator;
		return "Result: " + result;
	}

}
