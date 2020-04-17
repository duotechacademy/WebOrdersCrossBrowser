package io.duotech.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.duotech.pages.LoginPage;
import io.duotech.utils.BrowserUtility;
import io.duotech.utils.ConfigReader;
import io.duotech.utils.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;



public class LoginTest extends TestBase{
	
	
	
	
	
	@Test
	public void positiveLoginTest() {
	
	
	driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"));
	driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(ConfigReader.getProperty("password"));
	driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	Assert.assertTrue(driver.getTitle().equals("Web Orders"));
	}
	
	@Test
	
	public void positiveLoginUsingPOM() {
		LoginPage loginPage = new LoginPage();
		loginPage.usernameField.sendKeys(ConfigReader.getProperty("username"));
		loginPage.passwordField.sendKeys(ConfigReader.getProperty("password"));
		loginPage.loginButton.click();
		Assert.assertTrue(driver.getTitle().equals("Web Orders"));
	}
	
	@Test
	public void positiveLoginUsingPOMMethods() throws IOException  {
		LoginPage loginPage = new LoginPage();
		loginPage.login();
		BrowserUtility.takeFullScreenshot("AfterLogin");
		Assert.assertTrue(driver.getTitle().equals("Web Orders"));
	}
	
	
	@Test
	
	public void negativeLoginUsingPOM() throws IOException  {
		LoginPage loginPage = new LoginPage();
		loginPage.usernameField.sendKeys(ConfigReader.getProperty("username")+"asd");
		loginPage.passwordField.sendKeys(ConfigReader.getProperty("password") + "dbas");
		loginPage.loginButton.click();
		BrowserUtility.takeFullScreenshot("AfterClick");
		Assert.assertFalse(driver.getTitle().equals("Web Orders"));
		
	}
	
	

	
	
	
}
