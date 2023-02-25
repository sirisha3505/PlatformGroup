package com.platformgroup.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.platformgroup.qa.base.BasePage;
import com.platformgroup.qa.util.ElementUtil;
import com.platformgroup.qa.util.JavaScriptUtil;

public class BasketPage extends BasePage {

	private WebDriver driver;

	private By basketPageTitle = By.xpath("//span[text()='Your Cart']");
	private By firstProductInBasket = By.xpath("//div[text()='Sauce Labs Backpack']");
	private By secondProductInBasket = By.xpath("//div[text()='Sauce Labs Onesie']");
	private By checkOut = By.cssSelector("button[id='checkout']");

	public BasketPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		javaScriptUtil = new JavaScriptUtil(this.driver);
	}

	public boolean verifyBasketPageTitle() {
		elementUtil.waitForElementPresent(basketPageTitle, 20);
		return elementUtil.doIsDisplayed(basketPageTitle);
	}

	public void verifyProductsInBasketPage() {
		elementUtil.waitForElementPresent(firstProductInBasket, 20);
		elementUtil.doIsDisplayed(firstProductInBasket);
		elementUtil.doIsDisplayed(secondProductInBasket);
	}

	public CheckOutPage gotoCheckOutPage() {

		elementUtil.clickWhenReady(checkOut, 20);
		return new CheckOutPage(driver); }


}
