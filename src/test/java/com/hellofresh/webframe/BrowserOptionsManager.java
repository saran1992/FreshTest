package com.hellofresh.webframe;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BrowserOptionsManager {
	//Get Chrome Options
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options=new ChromeOptions();
        
        /* Enable the below option when there is chromedriver version mismatch 
        ('Timed out receiving message from renderer: 0.100) */
        
        //options.setPageLoadStrategy(PageLoadStrategy.NONE);  
        options.addArguments("start-maximized"); 
        options.addArguments("enable-automation"); 
        options.addArguments("--disable-infobars"); 
        options.addArguments("--disable-dev-shm-usage"); 
        return options;
    }
 
    //Get Firefox Options
    public static FirefoxOptions getFirefoxOptions () {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Set Firefox profile to capabilities
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }

}
