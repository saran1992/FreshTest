package com.hellofresh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hellofresh.pageobjects.CheckOutPageObjects;
import com.hellofresh.webframe.CommonFunctions;

public class CheckOutPage extends CommonFunctions {

	CheckOutPageObjects _checkout = new CheckOutPageObjects();

	public CheckOutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, _checkout);
	}
	
	public CheckOutPage proceedToCheckOut() {
		clickOnElement(_checkout.btn_proceedToCheckout,"Checkout 1");
		clickOnElement(_checkout.btn_checkout,"Checkout 2");
		clickOnElement(_checkout.btn_processAddress,"Process Address");
		clickOnElement(_checkout.checkBox_agreeTerms,"Agree terms and conditions");
		clickOnElement(_checkout.btn_proceedToPayment,"Proceed to payment");
		clickOnElement(_checkout.btn_bankwire,"Bankwire");
		clickOnElement(_checkout.btn_confirmOrder,"Confirm order");
		return this;
	}
	
	public String getHeader() {
		return _checkout.header_heading.getText();
	}
	
	public boolean isLastStepTabDisplayed() {
		return _checkout.nav_laststep.isDisplayed();
	}
	
	public boolean isCurrentStepTabDisplayed() {
		return _checkout.nav_currentstep.isDisplayed();
	}
	
	public String getConfirmationString() {
		return _checkout.text_confirmation.getText();
	}

}
