package com.hellofresh.webframe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hellofresh.listeners.ReportsListener;

@SuppressWarnings("unchecked")
public class CommonFunctions extends ReportsListener{

	protected WebDriver driver;
	@SuppressWarnings("rawtypes")
	Wait wait;

	public CommonFunctions(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(WebElement el,String elementName) {
		waitForElement(el);
		el.click();
		test.get().info("clicked on:"+elementName);
	}

	public void waitForElement(WebElement el) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	public void typeText(WebElement el, String text,String elementName) {
		waitForElement(el);
		el.sendKeys(text);
		test.get().info(elementName+"field updated with value: "+text);
	}

	public void selectByValue(WebElement dropdown, String value,String elementName) {
		Select dd = new Select(dropdown);
		dd.selectByValue(value);
		test.get().info(elementName+" updated with value: "+value);
	}

	public void selectByVisibleText(WebElement dropdown, String value,String elementName) {
		Select dd = new Select(dropdown);
		dd.selectByVisibleText(value);
		test.get().info(elementName+" updated with value: "+value);
	}

	public void waitForElementToBeClickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}

}
