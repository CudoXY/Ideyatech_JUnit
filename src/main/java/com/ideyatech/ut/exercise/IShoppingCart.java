package com.ideyatech.ut.exercise;

public interface IShoppingCart
{
	void addProduct(Product product);

	void checkout(Cashier cashier);
}
