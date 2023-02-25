package com.platformgroup.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.platformgroup.qa.base.BaseTest;

public class HomePageTests extends BaseTest{
	
	@Test(priority = 1) 
	public void verifyPrintProductAddedToBasketTest() throws InterruptedException { 
		homePage.addProductsToBasket();
		Assert.assertTrue(homePage.verifyProductsAddedToTheBasket());
	}

}
