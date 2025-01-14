package com.java.backend.app.spring_java_backend;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

//
//
//@ExtendWith(MockitoExtension.class)
public class SampleTests {

	@Mock
	TestApi testApi;

	@DisplayName("Test MessageService.get()")
	@Test
	void testGet() {
		assertEquals("Hello JUnit 5", testApi.get());
	}
}
