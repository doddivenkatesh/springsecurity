package com.springsecurity.springsecurity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springsecurity.springsecurity.junit.Calculator;

public class CalculatorTest {

	Calculator calculator;
	
	@BeforeEach
	public void setup() {
		calculator = new Calculator();
	}
	
	@Test
	public void testAdd() {
		assertEquals(20, calculator.addTwoNumbers(10, 10));
	}
}
