package com.platformgroup.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.platformgroup.qa.base.BasePage;
import com.platformgroup.qa.util.ElementUtil;
import com.platformgroup.qa.util.JavaScriptUtil;

public class HomePage extends BasePage {

	private WebDriver driver;

	// 1. By Locators:
	private By homepageTitle = By.xpath("//span[text()='Products']");
	private By addSauceLabsBackPacktoBasket = By.cssSelector("button[id='add-to-cart-sauce-labs-backpack']");
	private By addSauceLabsOnesietoBasket = By.cssSelector("button[id='add-to-cart-sauce-labs-onesie']");
	private By numberofItemsInBasket = By.xpath("//span[@class='shopping_cart_badge'][text()='2']");
	private By gotobasketPage = By.xpath("//a[@class='shopping_cart_link']");


	//2.Constructor of the page class

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		javaScriptUtil = new JavaScriptUtil(this.driver);
	}

	public boolean getHomepageTitle() {
		return elementUtil.doIsDisplayed(homepageTitle);
	}

	public void addProductsToBasket() throws InterruptedException {

		elementUtil.waitForElementToBeClickable(addSauceLabsBackPacktoBasket, 30);
		elementUtil.doClick(addSauceLabsBackPacktoBasket);
		javaScriptUtil.scrollPageDown();
		elementUtil.waitForElementToBeClickable(addSauceLabsOnesietoBasket, 30);
		elementUtil.doClick(addSauceLabsOnesietoBasket);
		javaScriptUtil.scrollPageUp();
	}
	public boolean verifyProductsAddedToTheBasket()	{

		elementUtil.waitForElementPresent(numberofItemsInBasket, 30);
		return elementUtil.doIsDisplayed(numberofItemsInBasket); 

	}
	public BasketPage gotoBasketpage() {

		elementUtil.clickWhenReady(gotobasketPage, 20);
		return new BasketPage(driver); }
}
