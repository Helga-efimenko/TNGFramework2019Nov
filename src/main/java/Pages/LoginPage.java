package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BasePage.BasePage;
import Utilities.ElementUtil;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	
	//Locators NPF
	By emailID = By.id("username");
	By passwordID = By.id("password");
	By loginBTN = By.id("loginBtn");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public  HomePage doLogin(String username, String pwd){
	 driver.findElement(emailID).sendKeys(username);
	 driver.findElement(passwordID).sendKeys(pwd);
	 driver.findElement(loginBTN).click();
	 return new HomePage(driver);
	}
	

}
