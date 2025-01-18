package com.java.backend.app.spring_java_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringJavaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJavaBackendApplication.class, args);
	}

}
