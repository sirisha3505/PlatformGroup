package com.platformgroup.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.platformgroup.qa.base.BasePage;
import com.platformgroup.qa.util.ElementUtil;

public class LoginPage extends BasePage {

	WebDriver driver;
	By userName = By.cssSelector("input[id='user-name']");
	By passWord = By.cssSelector("input[id='password']");
	By loginButton = By.cssSelector("input[id='login-button']");
	By UserloginFailed = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");


	public LoginPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public HomePage doLoginSwaglabs(String username, String password){

		elementUtil.doSendKeys(userName, username);
		elementUtil.doSendKeys(passWord,password );
		elementUtil.doClick(loginButton);	
		return new HomePage(driver);
	}
	
	public String getlLoginFailedtext() {
		elementUtil.waitForElementPresent(UserloginFailed, 20);
		String LoginFailedtext = elementUtil.doGetText(UserloginFailed);
		return LoginFailedtext;
	}
}
