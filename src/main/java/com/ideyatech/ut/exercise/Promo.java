package com.ideyatech.ut.exercise;

import java.util.ArrayList;

public abstract class Promo
{
	private String name;
	private Product requiredProduct;
	private int requiredQuantity;

	public Promo(String name, Product requiredProduct, int requiredQuantity)
	{
		this.name = name;
		this.requiredProduct = requiredProduct;
		this.requiredQuantity = requiredQuantity;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Product getRequiredProduct()
	{
		return requiredProduct;
	}

	public void setRequiredProduct(Product requiredProduct)
	{
		this.requiredProduct = requiredProduct;
	}

	public int getRequiredQuantity()
	{
		return requiredQuantity;
	}

	public void setRequiredQuantity(int requiredQuantity)
	{
		this.requiredQuantity = requiredQuantity;
	}

	public boolean isValid(ArrayList<Product> productList)
	{
		int count = 0;
		for (int i = 0; i < productList.size(); i++)
		{
			if (count == requiredQuantity)
				return true;

			if (!productList.get(i).equals(requiredProduct))
				continue;

			count++;
		}

		return count == requiredQuantity;
	}

}
