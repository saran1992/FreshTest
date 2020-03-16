package com.hellofresh.webframe;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.base.Strings;

public class DriverFactory {
	 
		public static WebDriver initDriver () throws MalformedURLException {
	    	String browser=System.getProperty("browser");
	    	RemoteWebDriver driver = null;
	    	
	    	if(Strings.isNullOrEmpty(browser) || browser.equals("chrome")) {
	    		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
	    		driver=new ChromeDriver(BrowserOptionsManager.getChromeOptions());
	    		
	    	}else if (browser.equals("firefox")) {
	    		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
	    		driver=new FirefoxDriver(BrowserOptionsManager.getFirefoxOptions());
	    	}
	        return driver;
	    }
	    

}
