package com.platformgroup.qa.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.platformgroup.qa.base.BasePage;
import com.platformgroup.qa.pages.BasketPage;
import com.platformgroup.qa.pages.HomePage;
import com.platformgroup.qa.pages.LoginPage;

public class LoginPageTests extends BasePage {

	public BasePage basePage;
	public LoginPage loginPage;
	public HomePage homePage;
	public BasketPage basketPage;
	public WebDriver driver;
	public Properties prop;


	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);		
		homePage = new HomePage(driver);
		basketPage = new BasketPage(driver);
	}

	@Test(priority = 1)
	public void verifyUserloginTest(){
		loginPage.doLoginSwaglabs(prop.getProperty("Username"), prop.getProperty("Password"));
		Assert.assertTrue(homePage.getHomepageTitle());
	}

	@Test(priority = 2)
	public void verifyUserLoginWithInvalidCredentialsTest() {
		loginPage.doLoginSwaglabs(prop.getProperty("InvalidUsername"), prop.getProperty("Password"));
		String LoginFailedText = loginPage.getlLoginFailedtext();
		System.out.println("Login Failed Text = " + LoginFailedText);
		Assert.assertEquals(LoginFailedText, "Epic sadface: Username and password do not match any user in this service");
	}

	@AfterMethod
	public void tearDown() { 
		driver.quit();
	}


}	

