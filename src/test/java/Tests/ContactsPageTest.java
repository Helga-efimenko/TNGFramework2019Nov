package Tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.ContactsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.Constants;
import Utilities.ExcelUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.Properties;


import org.openqa.selenium.WebDriver;

public class ContactsPageTest {


	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	@BeforeMethod

	public void setUp(){
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.gotoContactsPage();
	}
	
	@Test(priority=1)
	
	public void verifyContactsPageTitle(){
		String title = contactsPage.getContactsPageTitle();
		System.out.println("conatcts page title is "+ title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}
	
	@DataProvider()
	public Object[][] getContactData(){
		Object data [][]= ExcelUtil.getTestData("createcontact");
		return data;
	}
	
	@Test(priority=2, dataProvider="getContactData")
	public void createNewPOMContactTest(String email, String firstname, String lastname, String jobtitle) throws InterruptedException{
		contactsPage.createNewContact(email, firstname, lastname, jobtitle);
	}
	
	
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}
}
