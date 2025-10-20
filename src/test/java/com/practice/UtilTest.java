package com.practice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UtilTest {

	@ParameterizedTest
	@ValueSource(ints= {2,4,6,8,})
	@DisplayName("IsEven should return true if number is even")
	void testIsEven(int num) {
		assertTrue(Util.isEven(num));
	}
	
	@Test
	@DisabledOnOs(OS.WINDOWS)
	void testOutputMatches() {
	    List<String> expected = List.of("Line 1", "Line 2", "Line 3");
	    List<String> actual = List.of("Line 1", "Line 2", "Line 3");
	    assertLinesMatch(expected, actual);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
	    "user@example.com",
	    "john.doe@gmail.com",
	    "hello.world@company.org"
	})
	void testValidEmails(String email) {
	    assertTrue(Util.isValidEmail(email));
	}

	@ParameterizedTest
	@ValueSource(strings = {
	    "invalid-email",
	    "noatsymbol.com",
	    "@missinguser.com"
	})
	void testInvalidEmails(String email) {
	    assertFalse(Util.isValidEmail(email));
	}
}
