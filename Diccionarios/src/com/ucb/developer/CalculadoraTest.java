package com.ucb.developer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {
	private Calculadora calc;
	@BeforeEach
	void setUp() throws Exception {
		calc = new Calculadora();
	}

	@Test
	void testSumar() {
		assertEquals(5, calc.sumar(2, 3));
	}

}
