package com.ideyatech.ut.exercise;

import java.util.ArrayList;

public class ShoppingCart implements IShoppingCart
{
	private ArrayList<Product> productList;

	public ShoppingCart()
	{
		productList = new ArrayList<Product>();
	}

	public void addProduct(Product product)
	{
		productList.add(product);
	}

	public void checkout(Cashier cashier)
	{
		cashier.checkout(productList);
	}

}
