package com.java.backend.app.spring_java_backend;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;

@TestMethodOrder(OrderAnnotation.class)
public class OrderedTests {


	@Test
	@Order(1)
	void testA() {
		System.out.println("Test A executed");
	}

	@Test
	@Order(2)
	void testB() {
		System.out.println("Test B executed");
	}

	@Test
	@Order(3)
	void testC() {
		System.out.println("Test C executed");
	}

	@Test
	void testD() {
		System.out.println("Test D executed");
	}

	@Test
	void testE() {
		System.out.println("Test E executed");
	}
}
