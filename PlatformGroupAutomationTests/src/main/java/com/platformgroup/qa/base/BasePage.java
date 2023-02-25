package com.platformgroup.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.platformgroup.qa.util.ElementUtil;
import com.platformgroup.qa.util.JavaScriptUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

		public WebDriver driver;
		public Properties prop;
		public ElementUtil elementUtil;
		public JavaScriptUtil javaScriptUtil;

		/**
		 * This method is used to initialize the browser on the basis of given browser
		 * @param browser
		 * @return This return webdriver driver
		 */

		public WebDriver init_driver(String browser) {
			System.out.println("Browser value is: "+ browser);

			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("safari")) {
				WebDriverManager.chromedriver().setup();
				driver = new SafariDriver();
			}
			else {
				System.out.println("Please pass the correct browser value : " + browser);
			}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
			return driver;
		}
		
		/**
		 * This method is used to load the properties from config.properties file
		 * @return it return properties prop reference
		 */
		
		public Properties init_prop() {

			prop = new Properties();
			try {
				FileInputStream ip = new FileInputStream("./src/main/java/com/platformgroup/qa/config/config.properties");
				prop.load(ip);
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
			return prop;
		}
	}
