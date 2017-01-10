package com.ideyatech.ut.exercise;

public class Driver
{
	public static void main(String[] a)
	{
		Product small = new Product("UNLI_1GB", "SMALL", 1000d);
		Product medium = new Product("UNLI_2GB", "MEDIUM", 1500d);
		Product large = new Product("UNLI_5GB", "LARGE", 3000d);
		Product add1GB = new Product("1GB_ADDTL", "1GB", 500d);

		Promo promoList[] = { new PromoDiscount("3 SMALL for 2", small, 3, small.getPrice() * 2),
				new PromoFreeProduct("5 LARGE Get 1 SMALL free", large, 5, small, 1),
				new PromoFreeProduct("MEDIUM + 1GB", medium, 1, add1GB, 1) };

		Cashier cashier = new Cashier();

		for (int i = 0; i < promoList.length; i++)
			cashier.addPromo(promoList[i]);

		ShoppingCart shoppingCart = new ShoppingCart();

		shoppingCart.addProduct(small);
		shoppingCart.addProduct(medium);
		shoppingCart.addProduct(large);
		shoppingCart.addProduct(add1GB);

		shoppingCart.checkout(cashier);
	}

	public static void displayMenu()
	{
		System.out.println("Options");
		System.out.println("Options");
		System.out.println("Options");
		System.out.println("Options");
		System.out.println("Options");
	}

}
