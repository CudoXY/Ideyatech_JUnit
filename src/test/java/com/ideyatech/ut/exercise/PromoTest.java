package com.ideyatech.ut.exercise;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ideyatech.ut.exercise.Product;
import com.ideyatech.ut.exercise.Promo;
import com.ideyatech.ut.exercise.PromoDiscount;
import com.ideyatech.ut.exercise.PromoFreeProduct;

public class PromoTest {
	
	private Promo promo;
	private Product small ;
	private Product medium;
	private Product large ;
	private Product add1GB;
	
	@BeforeClass
	public static void initClass()
	{
		System.out.println("[TEST] Promo Class Start");
	}
	
	@Before
	public void init()
	{
		small = new Product("UNLI_1GB", "SMALL", 1000d);
		medium = new Product("UNLI_2GB", "MEDIUM", 1500d);
		large = new Product("UNLI_5GB", "LARGE", 3000d);
		add1GB = new Product("1GB_ADDTL", "1GB", 500d);
	}
	
	@Test
	public void testPromoDiscountisNOTValid()
	{
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(small);
		products.add(medium);
		products.add(large);
		products.add(add1GB);
		promo = new PromoDiscount("3 SMALL for 2", small, 3, small.getPrice() * 2);
		
		assertEquals(promo.isValid(products), false);
	}
	
	@Test
	public void testPromoDiscountisValid()
	{
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(small);
		products.add(small);
		products.add(small);
		products.add(medium);
		products.add(large);
		products.add(add1GB);
		promo = new PromoDiscount("3 SMALL for 2", small, 3, small.getPrice() * 2);
		
		assertEquals(promo.isValid(products), true);
	}
	
	@Test
	public void testPromoFreeProductisValid()
	{
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(small);
		products.add(medium);
		products.add(large);
		products.add(add1GB);
		promo = new PromoFreeProduct("MEDIUM + 1GB", medium, 1, add1GB, 1);
		
		assertEquals(promo.isValid(products), true);
	}
	
	public void testPromoFreeProductisNOTValid()
	{
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(small);
		products.add(medium);
		products.add(large);
		products.add(add1GB);
		promo = new PromoFreeProduct("5 LARGE Get 1 SMALL free", large, 5, small, 1);
		
		assertEquals(promo.isValid(products), false);
	}
	
}
