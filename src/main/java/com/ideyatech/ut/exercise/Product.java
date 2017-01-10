package com.ideyatech.ut.exercise;

public class Product
{

	private String name;
	private String id;
	private double price;

	public Product(String id, String name, double price)
	{
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

}
