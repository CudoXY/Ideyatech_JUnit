package com.ideyatech.ut.exercise;

public class PromoFreeProduct extends Promo
{
	private Product freeProduct;
	private int freeQuantity;

	public PromoFreeProduct(String name, Product requiredProduct, int requiredQuantity, Product freeProduct,
			int freeQuantity)
	{
		super(name, requiredProduct, requiredQuantity);
		this.freeProduct = freeProduct;
		this.freeQuantity = freeQuantity;
	}

	public Product getFreeProduct()
	{
		return freeProduct;
	}

	public void setFreeProduct(Product freeProduct)
	{
		this.freeProduct = freeProduct;
	}

	public int getFreeQuantity()
	{
		return freeQuantity;
	}

	public void setFreeQuantity(int freeQuantity)
	{
		this.freeQuantity = freeQuantity;
	}

}
