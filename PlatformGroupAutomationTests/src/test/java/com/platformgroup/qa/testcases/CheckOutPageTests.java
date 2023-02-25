package com.platformgroup.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.platformgroup.qa.base.BaseTest;

public class CheckOutPageTests extends BaseTest{
	
	@Test(priority = 1) 
	public void verifyOrderConformationTest
	() throws InterruptedException { 
		homePage.addProductsToBasket();
		Assert.assertTrue(homePage.verifyProductsAddedToTheBasket());
		homePage.gotoBasketpage();
		basketPage.verifyBasketPageTitle();
		basketPage.verifyProductsInBasketPage();
		basketPage.gotoCheckOutPage();
		String OrderConfirmationText = checkOutPage.placeOrder(prop.getProperty("Firstname"), prop.getProperty("Lastname"), prop.getProperty("Postcode"));
		System.out.println("Order Sucessfull text = " + OrderConfirmationText);
		Assert.assertEquals(OrderConfirmationText, "THANK YOU FOR YOUR ORDER");
		
	}
	
}
