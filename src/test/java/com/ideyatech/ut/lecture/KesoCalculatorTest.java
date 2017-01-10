package com.ideyatech.ut.lecture;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class KesoCalculatorTest
{
	private KesoCalculator calc;

	// @BeforeClass
	// public static void initClass()
	// {
	// System.out.println("Before Class poh");
	// }

	@Before
	public void init()
	{
		calc = new KesoCalculator();

	}

	@Test
	public void testAdd()
	{
		assertEquals("Sum should be 15", 15l, calc.add(10, 5));
	}

	@Test
	public void testSubtract()
	{
		assertEquals("Difference should be 5", 5l, calc.subtract(10, 5));
	}

	@Test
	public void testMultiply()
	{
		assertEquals("Product should be 50", 50l, calc.multiply(10, 5));
	}

	@Test
	public void testDivide()
	{
		assertEquals("Quotient should be 10", 10d, calc.divide(50, 5), 0);
	}

	@Test
	public void testDivideByZero()
	{
		calc.divide(50, 0);
	}

	@Test
	public void testPow()
	{
		assertEquals("Result should be 32", 32d, calc.power(2, 5), 0);
	}

	// @After
	// public void cleanUp()
	// {
	// System.out.println("After poh");
	// }
	//
	// @AfterClass
	// public static void afterClass()
	// {
	// System.out.println("After Class poh");
	// }

}
