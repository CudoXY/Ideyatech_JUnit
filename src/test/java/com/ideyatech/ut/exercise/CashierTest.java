package com.ideyatech.ut.exercise;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ideyatech.ut.lecture.SharpCalculator;

public class CashierTest {

		private Cashier cashier;
		private Product small ;
		private Product medium;
		private Product large ;
		private Product add1GB;
		
		@BeforeClass
		public static void initClass()
		{
			System.out.println("[TEST] Cashier Class Start");
			
		}
		
		@Before
		public void init()
		{
			small = new Product("UNLI_1GB", "SMALL", 1000d);
			medium = new Product("UNLI_2GB", "MEDIUM", 1500d);
			large = new Product("UNLI_5GB", "LARGE", 3000d);
			add1GB = new Product("1GB_ADDTL", "1GB", 500d);
			cashier = new Cashier();
			Promo promoList[] = { new PromoDiscount("Buy 3 SMALL for the price of 2", small, 3, small.getPrice() * 2),
					new PromoFreeProduct("Buy 5 LARGE Get 1 SMALL free", large, 5, small, 1),
					new PromoFreeProduct("For every MEDIUM you get 1GB additional for free", medium, 1, add1GB, 1) };

			for (int i = 0; i < promoList.length; i++)
				cashier.addPromo(promoList[i]);
		}
		
		@Test
		public void testGetTotalPrice()
		{
			ArrayList<Product> products = new ArrayList<Product>();
			
			products.add(small);
			products.add(medium);
			products.add(large);
			products.add(add1GB);
			double result = cashier.getTotalPrice(products);
			//System.out.println("[RESULT] " + result);
			assertEquals( 6000, result,0);
		}
		
		@Test
		public void test1()
		{
			ArrayList<Product> products = new ArrayList<Product>();
			products.add(small);
			products.add(small);
			products.add(large);
			products.add(large);
			products.add(large);
			products.add(large);
			
			double result = cashier.getTotalPrice(products);
			System.out.println("[RESULT] " + result);
			assertEquals( 14000, result,0);
		}
		
		@Test
		public void test2()
		{
			ArrayList<Product> products = new ArrayList<Product>();
			products.add(small);
			products.add(small);
			products.add(small);
			products.add(medium);
			
			double result = cashier.getTotalPrice(products);
			System.out.println("[RESULT] " + result);
			assertEquals( 3500, result,0);
		}
		
		@Test
		public void test3()
		{
			ArrayList<Product> products = new ArrayList<Product>();
			products.add(small);
			products.add(small);
			products.add(small);
			products.add(medium);
			products.add(medium);
			products.add(large);
			products.add(large);
			products.add(large);
			products.add(large);
			products.add(large);
			
			double result = cashier.getTotalPrice(products);
			System.out.println("[RESULT] " + result);
			assertEquals(20000, result,0);
		}
		
		@Test
		public void testGetPromoItemPrice()
		{
			Promo promo = new PromoFreeProduct("5 LARGE Get 1 SMALL free", large, 5, small, 1);
			double result = cashier.getPromoItemPrice(promo);
			assertEquals( 15000, result,0);
		}
}
