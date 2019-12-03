package Tests;
//package com.hubspot.tests

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners(com.hubspot.listeners.TestAllureListiner.class)
public class LoginPageTest {
	
	Logger logger = Logger.getLogger("LoginPageTest");
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		basePage = new BasePage();
		logger.info("Browser is launching...");
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		logger.info("Set up is configure");
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	 }
	}
	
	@Test(priority=1, description="this method get page title")
	public void loginPageTitleTest(){
	 String title = loginPage.getLoginPageTitle();	
	 System.out.println(title);
	 Assert.assertEquals(title, "HubSpot Login");
	 //Assert.assertEquals(title, "HubSpot Login", "any message will appear on the consul if the test fails");
	}
	
	//@Test(priority=2, enable=false) ---> this test won't be executed
	@Test(priority=2)
	public void loginWithInvalidPassword() throws InterruptedException{
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
	}
	
	@Test(priority=3, enabled=true, description=" helga Valid username, valid password")
	@Description("login test with correct user and correct pass")
	@Severity(SeverityLevel.CRITICAL)
	public void loginTest() throws InterruptedException{
		loginPage.doLogin("helgaefimenko@gmail.com", "Rzy040814.");
		logger.info("Login test logs: correct user, correct pass");
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
 
}
