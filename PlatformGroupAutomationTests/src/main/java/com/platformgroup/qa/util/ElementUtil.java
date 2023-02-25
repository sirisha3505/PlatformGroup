package com.platformgroup.qa.util;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.platformgroup.qa.base.BasePage;

public class ElementUtil extends BasePage {

	WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			System.out.println("locator is : " + locator);
			element = driver.findElement(locator);
			System.out.println("WebElement is created successfully : " + locator);

		} catch (Exception e) {
			System.out.println("some exception got occurred with this locator: " + locator);
		}
		return element;
	}

	public void doSendKeys(By locator, String value) {
		elementToBeClickable(locator, 50);
		getElement(locator).sendKeys(value);
	}
	public String doGetattributetext(By locator){

		waitForElementPresent(locator, 30);
		return getElement(locator).getAttribute("value");
	}


	public void doClick(By locator) {

		elementToBeClickable(locator,30);
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		waitForElementPresent(locator, 30);
		return getElement(locator).getText();
	}

	public boolean doIsDisplayed(By locator) {
		waitForElementPresent(locator, 30);
		return getElement(locator).isDisplayed();
	}
	// **********************************Actions class Utils
	// *********************************

	public void doActionsClick(By locator) {
		elementToBeClickable(locator, 30);
		Actions action = new Actions(driver);
		action.click(getElement(locator)).build().perform();
	}

	// ***************************** Wait Utils
	// *******************************************


	public WebElement waitForElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}
	public WebElement elementToBeClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}
	public WebElement waitForElementToBeClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}

	// clickWhenReady:
	public void clickWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

}
