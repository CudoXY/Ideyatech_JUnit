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
		displayAndComputeTotal(products);
	}

	public void displayAndComputeTotal(ArrayList<Product> products)
	{
		double totalCost = 0;
		ArrayList<Promo> promoList = checkPromo(products);

		if (promoList != null)
		{
			for (int i = 0; i < promoList.size(); i++)
			{
				Promo currPromo = promoList.get(i);

				System.out.println(currPromo.getName() + "\t"
						+ (currPromo instanceof PromoDiscount ? ((PromoDiscount) currPromo).getNewPrice()
								: currPromo.getRequiredProduct().getPrice() * currPromo.getRequiredQuantity()));

				for (int j = 0; j < currPromo.getRequiredQuantity(); j++)
					System.out.println("\t" + currPromo.getRequiredProduct().getName());

				if (promoList.get(i) instanceof PromoDiscount)
				{
					System.out.println(currPromo.getName());
					totalCost += ((PromoDiscount) promoList.get(i)).getNewPrice();
				}
				else
				{
					for (int x = 0; x < ((PromoFreeProduct) promoList.get(i)).getFreeQuantity(); x++)
					{
						System.out.println("\t" + ((PromoFreeProduct) promoList.get(i)).getFreeProduct().getName());
					}

					totalCost += currPromo.getRequiredQuantity() * currPromo.getRequiredProduct().getPrice();
				}
			}
		}

		for (int i = 0; i < products.size(); i++)
		{
			System.out.println(products.get(i).getName() + "\t" + products.get(i).getPrice());
			totalCost += products.get(i).getPrice();
		}
		System.out.println();
		System.out.println("Total Cost: \t" + totalCost);
	}

	public void addPromo(Promo promo)
	{
		promoList.add(promo);
	}

	public ArrayList<Promo> checkPromo(ArrayList<Product> products)
	{
		ArrayList<Promo> promoCheckout = new ArrayList<Promo>();
		boolean hasPromo;

		do
		{

			hasPromo = false;
			for (int i = 0; i < promoList.size(); i++)
			{
				if (!promoList.get(i).isValid(products))
					continue;

				hasPromo = true;
				promoCheckout.add(promoList.get(i));

				int prodToRemove = promoList.get(i).getRequiredQuantity();

				for (int j = 0; j < products.size(); j++)
				{
					if (prodToRemove <= 0)
						break;

					if (!products.get(j).equals(promoList.get(i).getRequiredProduct()))
						continue;

					products.remove(j);
					prodToRemove--;
				}

			}

		}
		while (hasPromo);

		return promoCheckout;
	}

}
