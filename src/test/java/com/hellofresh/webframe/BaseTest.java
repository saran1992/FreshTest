package com.hellofresh.webframe;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	// Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@BeforeMethod(alwaysRun = true)
	public void setup() throws MalformedURLException {
		// Set Browser to ThreadLocalMap
		driver.set(DriverFactory.initDriver());
	}

	public WebDriver getDriver() {
		// Get driver from ThreadLocalMap
		return driver.get();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		getDriver().quit();
	}
	

	@AfterClass
	void terminate() {
		// Remove the ThreadLocalMap element
		driver.remove();
	}

}
