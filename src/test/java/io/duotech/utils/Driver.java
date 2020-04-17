package io.duotech.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;


import io.duotech.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	private Driver() {}

	private static WebDriver driver;

	public static WebDriver getDriver(String browser) {
		if (driver == null) {
			
			if(browser==null) {
				browser = ConfigReader.getProperty("browser");
			}
			
			
			
			switch (browser) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "opera":
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			
			case "headlessChrome": 
				WebDriverManager.chromedriver().setup();
				final ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless" );
				options.addArguments("--disable-gpu"); // --> only for Windows
				driver = new ChromeDriver(options);
				break;
				
			case "headlessFirefox": 
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions foptions = new FirefoxOptions();
				foptions.addArguments("--headless" );
				driver = new FirefoxDriver(foptions);
				break;
			
			
			
			}
		}
		return driver;
	}
	
	
	public static WebDriver getDriver() {
		return getDriver(null);
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
