package com.hellofresh.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasePageObjects {
	
	@FindBy(linkText ="Women")
	public WebElement btn_category_women;
	
	@FindBy(name = "Submit")
	public WebElement btn_submit;
	

}
