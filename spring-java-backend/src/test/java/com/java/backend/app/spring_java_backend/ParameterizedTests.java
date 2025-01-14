package com.java.backend.app.spring_java_backend;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedTests {

	@org.junit.jupiter.params.ParameterizedTest
	@ValueSource(ints = {2, 4, 6, 8, 10})
	void testEvenNumbers(int number) {
		assertTrue(TestApi.isEven(number), "The number should be even");
	}

	@org.junit.jupiter.params.ParameterizedTest
	@CsvSource({
			"2, 4",
			"3, 9",
			"4, 16"
	})
	void testSquare(int input, int expected) {
		assertEquals(expected, input * input);
	}
//Check syntax for below example
//	static Stream<String> provideStrings() {
//		return Stream.of("racecar", "radar", "level");
//	}
//
//	@ParameterizedTest
//	@MethodSource("provideStrings")
//	void testPalindrome(String word) {
//		assertTrue(new StringBuilder(word).reverse().toString().equals(word), "The word should be a palindrome");
//	}
}
