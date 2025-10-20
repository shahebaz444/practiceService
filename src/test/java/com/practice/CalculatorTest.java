package com.practice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    @BeforeAll
    static void setupAll() {
        System.out.println("Before all tests");
    }

    @BeforeEach
    void setup() {
        System.out.println("Before each test");
    }
	
	
	@Test
	@DisplayName("Addition should return correct sum")
	void testAdd() {
		Calculator cal = new Calculator();
		assertEquals(5, cal.add(2, 3), "2+3 should equal 5");
	}
	
	
	@ParameterizedTest
	@CsvSource({
		"1,2,3",
		"2,4,6",
		"3,7,10"
	})
	void testAddition(int a, int b, int expected) {
		Calculator cal = new Calculator();
		assertEquals(cal.add(a, b),expected);
	}
	
	@Test
	void testMultiple() {
		Calculator cal = new Calculator();
		assertEquals(6,cal.multiply(2, 3), "2*3 should equal 6");
		assertNotEquals(7,cal.multiply(2, 3), "2*3 should not equal 7");
	}
	
	@Test
	void testDivide() {
		Calculator cal =new Calculator();
		assertEquals(3,cal.divide(7, 2), "7/2 should equal 3");
		assertThrows(ArithmeticException.class,()->cal.divide(10, 0) );
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4})
	void testIsEven(int number) {
	    assertTrue(number > 0);
	}
	
	
	@ParameterizedTest
	@MethodSource("numberProvider")
	void testSquare(int input, int expected) {
	    assertEquals(expected, input * input);
	}

	static Stream<Arguments> numberProvider() {
	    return Stream.of(
	        Arguments.of(2, 4),
	        Arguments.of(3, 9),
	        Arguments.of(4, 16)
	    );
	}
	
    @AfterEach
    void tearDown() {
        System.out.println("After each test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("After all tests");
    }

}
