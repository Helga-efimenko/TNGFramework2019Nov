package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BasePage.BasePage;
import Utilities.ElementUtil;

public class HomePage extends BasePage {
	
	public WebDriver driver;
	ElementUtil elementUtil;
	By header = By.xpath("//i18n-string[contains(text(),'Set up')]");
	By userInfo = By.xpath("//span[contains(text(),'Olga')]");
	By contactsMainTab =By.id("nav-primary-contacts-branch");
	By contactsChildTab = By.id("nav-secondary-contacts");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
	}
	
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyLoggedinUserInfoName(){
		return driver.findElement(userInfo).isDisplayed();
	}
	
	public String getHomePageHeaderValue(){
		return driver.findElement(header).getText();
	}
	
	public String getLoggedinUserName(){
		return driver.findElement(userInfo).getText();
	}
	
	private void clickOnContacts(){
		elementUtil.doClick(contactsMainTab);
		elementUtil.doClick(contactsChildTab);
	}
	
	public ContactsPage gotoContactsPage(){
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	
}
