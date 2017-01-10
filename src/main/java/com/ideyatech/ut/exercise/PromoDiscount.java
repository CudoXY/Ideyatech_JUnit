package com.ideyatech.ut.exercise;

public class PromoDiscount extends Promo
{
	private double newPrice;

	public PromoDiscount(String name, Product requiredProduct, int requiredQuantity, double newPrice)
	{
		super(name, requiredProduct, requiredQuantity);
		this.setNewPrice(newPrice);
	}

	public double getNewPrice()
	{
		return newPrice;
	}

	public void setNewPrice(double newPrice)
	{
		this.newPrice = newPrice;
	}

}
