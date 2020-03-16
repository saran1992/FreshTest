package com.hellofresh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hellofresh.pageobjects.PurchasePageObjects;
import com.hellofresh.webframe.CommonFunctions;

public class PurchasePage extends CommonFunctions {

	PurchasePageObjects _purchase=new PurchasePageObjects();
	public PurchasePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, _purchase);
	}
	
	public PurchasePage selectCategory(String category) {
		if(category.equalsIgnoreCase("women")) {
			clickOnElement(_purchase.btn_category_women,"Category:women");
		}
		return this;
	}
	
	public PurchasePage selectProduct(String productName) {
		clickOnElement(driver.findElement(By.xpath("//h5/a[@title='"+productName+"']")),productName);
		return this;
	}
	
	public PurchasePage submit() {
		clickOnElement(_purchase.btn_submit,"Submit");
		return this;
	}

}
