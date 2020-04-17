package io.duotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import io.duotech.utils.ConfigReader;
import io.duotech.utils.Driver;

public class LoginPage {
	
	public LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "ctl00_MainContent_username")
	public WebElement usernameField;

	@FindBy(id = "ctl00_MainContent_password")
	public WebElement passwordField;

	@FindBy(id = "ctl00_MainContent_login_button")
	public WebElement loginButton;
	
	@FindBy (id = "ctl00_MainContent_login_button")
	public List<WebElement> list;
	
	public void login() {
		usernameField.sendKeys(ConfigReader.getProperty("username"));
		passwordField.sendKeys(ConfigReader.getProperty("password"));
		loginButton.click();
		
		
	}

}
