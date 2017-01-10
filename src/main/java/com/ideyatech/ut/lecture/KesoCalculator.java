package com.ideyatech.ut.lecture;

public class KesoCalculator implements Calculator
{

	public long add(long a, long b)
	{
		return a + b;
	}

	public long subtract(long a, long b)
	{
		return a - b;
	}

	public long multiply(long a, long b)
	{
		return a * b;
	}

	public double divide(double a, double b)
	{
		return a / b;
	}

	public double sqrt(double a)
	{
		return Math.sqrt(a);
	}

	public double power(double a, double pow)
	{
		return Math.pow(a, pow);
	}

}
