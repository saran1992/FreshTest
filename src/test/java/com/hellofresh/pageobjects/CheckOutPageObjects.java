package com.hellofresh.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPageObjects {

	@FindBy(xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
	public WebElement btn_proceedToCheckout;

	@FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
	public WebElement btn_checkout;

	@FindBy(name = "processAddress")
	public WebElement btn_processAddress;

	@FindBy(id = "uniform-cgv")
	public WebElement checkBox_agreeTerms;

	@FindBy(name = "processCarrier")
	public WebElement btn_proceedToPayment;

	@FindBy(className = "bankwire")
	public WebElement btn_bankwire;

	@FindBy(xpath = "//*[@id='cart_navigation']/button")
	public WebElement btn_confirmOrder;

	@FindBy(css = "h1")
	public WebElement header_heading;

	@FindBy(xpath = "//li[@class='step_done step_done_last four']")
	public WebElement nav_laststep;

	@FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
	public WebElement nav_currentstep;

	@FindBy(xpath = "//*[@class='cheque-indent']/strong")
	public WebElement text_confirmation;

}
