package io.duotech.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.duotech.utils.ConfigReader;
import io.duotech.utils.Driver;


public abstract class TestBase {
	
	protected WebDriver driver;
	
	@Parameters ("browser")
	@BeforeMethod (alwaysRun =true)
	
	public void setUp(@Optional String browser) {

		driver = Driver.getDriver(browser);
		driver.get(ConfigReader.getProperty("url"));
	}
	
	@AfterMethod (alwaysRun=true)
	
	public void tearDownTest() {

	    Driver.closeDriver();
	}

}
