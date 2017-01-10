package com.ideyatech.ut.exercise;

import java.util.ArrayList;

public class Cashier
{

	private ArrayList<Promo> promoList;

	public Cashier()
	{
		promoList = new ArrayList<Promo>();
	}

	public void checkout(ArrayList<Product> products)
	{
		System.out.println(getReceiptString(products));

	}

	public String getReceiptString(ArrayList<Product> products)
	{
		StringBuilder receipt = new StringBuilder();

		// Get Promo Items first
		receipt.append(getAllReceiptPromoString(products));
		receipt.append(getAllReceiptString(products));

		receipt.append("Total Cost : \t" + getTotalPrice(products));

		return receipt.toString();

	}

	public String getAllReceiptPromoString(ArrayList<Product> productList)
	{
		ArrayList<Product> products = (ArrayList<Product>) productList.clone();
		StringBuilder sb = new StringBuilder();

		Promo p = getPromo(products);
		do
		{
			if (p == null)
				break;

			sb.append(getReceiptPromoItem(p)).append("\n");
			removeCountedPromoItems(products, p);
		}
		while ((p = getPromo(products)) != null);

		return sb.toString();
	}

	public String getAllReceiptString(ArrayList<Product> products)
	{
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < products.size(); i++)
			sb.append(getReceiptItem(products.get(i))).append("\n");

		return sb.toString();
	}

	public void removeCountedPromoItems(ArrayList<Product> products, Promo p)
	{
		int prodToRemove = p.getRequiredQuantity();

		for (int j = 0; j < products.size(); j++)
		{
			if (prodToRemove <= 0)
				break;

			if (!products.get(j).equals(p.getRequiredProduct()))
				continue;

			products.remove(j);
			prodToRemove--;
		}
	}

	public String getReceiptItem(Product product)
	{
		if (product == null)
			return "";

		return product.getName() + "\t" + product.getPrice() + "\n";
	}

	public String getReceiptPromoItem(Promo promo)
	{
		if (promo == null)
			return "";

		StringBuilder sb = new StringBuilder();

		sb.append(promo.getName()).append("\t").append(getPromoItemPrice(promo));

		sb.append("\n");

		// Print required products
		for (int i = 0; i < promo.getRequiredQuantity(); i++)
			sb.append("\t").append(promo.getRequiredProduct().getName()).append("\n");

		// Print free products
		if (!(promo instanceof PromoFreeProduct))
			return sb.toString();

		PromoFreeProduct p = (PromoFreeProduct) promo;

		for (int i = 0; i < p.getFreeQuantity(); i++)
			sb.append("\t").append(p.getFreeProduct().getName()).append("\n");

		return sb.toString();

	}

	public double getPromoItemPrice(Promo promo)
	{
		if (promo == null)
			return 0.0;

		if (promo instanceof PromoDiscount)
		{
			PromoDiscount p = (PromoDiscount) promo;
			return p.getNewPrice();
		}
		else
		{
			PromoFreeProduct p = (PromoFreeProduct) promo;
			return p.getRequiredProduct().getPrice() * p.getRequiredQuantity();
		}
	}

	public double getTotalPrice(ArrayList<Product> productList)
	{
		ArrayList<Product> products = (ArrayList<Product>) productList.clone();

		double totalCost = 0;

		Promo p = getPromo(products);
		do
		{
			if (p == null)
				break;

			totalCost += getPromoItemPrice(p);
			removeCountedPromoItems(products, p);
		}
		while ((p = getPromo(products)) != null);

		for (int i = 0; i < products.size(); i++)
			totalCost += products.get(i).getPrice();

		return totalCost;

	}

	public Promo getPromo(ArrayList<Product> products)
	{
		for (int i = 0; i < promoList.size(); i++)
		{
			if (!promoList.get(i).isValid(products))
				continue;

			return promoList.get(i);
		}

		return null;
	}

	// public void displayAndComputeTotal(ArrayList<Product> products)
	// {
	// double totalCost = 0;
	// ArrayList<Promo> promoList = checkPromo(products);
	//
	// if (promoList != null)
	// {
	// for (int i = 0; i < promoList.size(); i++)
	// {
	// Promo currPromo = promoList.get(i);
	//
	// System.out.println(currPromo.getName() + "\t"
	// + (currPromo instanceof PromoDiscount ? ((PromoDiscount)
	// currPromo).getNewPrice()
	// : currPromo.getRequiredProduct().getPrice() *
	// currPromo.getRequiredQuantity()));
	//
	// for (int j = 0; j < currPromo.getRequiredQuantity(); j++)
	// System.out.println("\t" + currPromo.getRequiredProduct().getName());
	//
	// if (promoList.get(i) instanceof PromoDiscount)
	// {
	// System.out.println(currPromo.getName());
	// totalCost += ((PromoDiscount) promoList.get(i)).getNewPrice();
	// }
	// else
	// {
	// for (int x = 0; x < ((PromoFreeProduct)
	// promoList.get(i)).getFreeQuantity(); x++)
	// {
	// System.out.println("\t" + ((PromoFreeProduct)
	// promoList.get(i)).getFreeProduct().getName());
	// }
	//
	// totalCost += currPromo.getRequiredQuantity() *
	// currPromo.getRequiredProduct().getPrice();
	// }
	// }
	// }
	//
	// for (int i = 0; i < products.size(); i++)
	// {
	// System.out.println(products.get(i).getName() + "\t" +
	// products.get(i).getPrice());
	// totalCost += products.get(i).getPrice();
	// }
	// System.out.println();
	// System.out.println("Total Cost: \t" + totalCost);
	// }

	public void addPromo(Promo promo)
	{
		promoList.add(promo);
	}

	// public ArrayList<Promo> checkPromo(ArrayList<Product> products)
	// {
	// ArrayList<Promo> promoCheckout = new ArrayList<Promo>();
	// boolean hasPromo;
	//
	// do
	// {
	//
	// hasPromo = false;
	// for (int i = 0; i < promoList.size(); i++)
	// {
	// if (!promoList.get(i).isValid(products))
	// continue;
	//
	// hasPromo = true;
	// promoCheckout.add(promoList.get(i));
	//
	// int prodToRemove = promoList.get(i).getRequiredQuantity();
	//
	// for (int j = 0; j < products.size(); j++)
	// {
	// if (prodToRemove <= 0)
	// break;
	//
	// if (!products.get(j).equals(promoList.get(i).getRequiredProduct()))
	// continue;
	//
	// products.remove(j);
	// prodToRemove--;
	// }
	//
	// }
	//
	// }
	// while (hasPromo);
	//
	// return promoCheckout;
	// }

}
