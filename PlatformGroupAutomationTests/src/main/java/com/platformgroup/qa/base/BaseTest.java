package com.platformgroup.qa.base;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.platformgroup.qa.pages.BasketPage;
import com.platformgroup.qa.pages.CheckOutPage;
import com.platformgroup.qa.pages.HomePage;
import com.platformgroup.qa.pages.LoginPage;

public class BaseTest extends BasePage{
	public BasePage basePage;
	public LoginPage loginPage;
	public HomePage homePage;
	public BasketPage basketPage;
	public CheckOutPage checkOutPage;
	public WebDriver driver;
	public Properties prop;

	@BeforeClass
	public void setup(){
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);	
		loginPage.doLoginSwaglabs(prop.getProperty("Username"), prop.getProperty("Password"));
		homePage = new HomePage(driver);
		basketPage = new BasketPage(driver);
		checkOutPage = new CheckOutPage(driver);
	}	

	@AfterClass  
	public void tearDown() {
		driver.quit();
	}

}

