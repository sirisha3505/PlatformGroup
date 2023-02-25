package com.platformgroup.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.platformgroup.qa.base.BasePage;
import com.platformgroup.qa.util.ElementUtil;
import com.platformgroup.qa.util.JavaScriptUtil;

public class CheckOutPage extends BasePage {
	private WebDriver driver;
	By firstName = By.cssSelector("input[id='first-name']");
	By lastName = By.cssSelector("input[id='last-name']");
	By postalCode = By.cssSelector("input[id='postal-code']");
	By continueButton = By.cssSelector("input[id='continue']");
	By finishButton = By.cssSelector("button[id='finish']");
	By orderSucessMessage = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		javaScriptUtil = new JavaScriptUtil(this.driver);
	}

	public String placeOrder(String Firstname, String Lastname, String PostalCode) {
		elementUtil.waitForElementPresent(firstName, 20);
		elementUtil.doSendKeys(firstName, Firstname);
		elementUtil.doSendKeys(lastName, Lastname);
		elementUtil.doSendKeys(postalCode,PostalCode);
		javaScriptUtil.scrollPageDown();
		elementUtil.doClick(continueButton);
		elementUtil.waitForElementPresent(finishButton, 20);
		javaScriptUtil.scrollPageDown();
		elementUtil.doClick(finishButton);
		String Sucessmessage = elementUtil.doGetText(orderSucessMessage);
		return Sucessmessage;


	}
}


