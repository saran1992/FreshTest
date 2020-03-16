package com.hellofresh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hellofresh.pageobjects.SignInPageObjects;
import com.hellofresh.webframe.CommonFunctions;

public class SigninPage extends CommonFunctions {

	SignInPageObjects _signin = new SignInPageObjects();

	public SigninPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, _signin);
	}

	public SigninPage clickSignInButton() {
		clickOnElement(_signin.btn_signin,"Sign in button");
		return this;
	}

	public SigninPage setNewEmail(String email) {
		typeText(_signin.textbox_newEmail, email,"New email");
		clickOnElement(_signin.btn_submitNewEmail, "New email submit button");
		return this;
	}

	public SigninPage setGender(String gender) {
		if (gender.equalsIgnoreCase("female")) {
			clickOnElement(_signin.btn_gender_female,"Female checkbox");
		} else {
			clickOnElement(_signin.btn_gender_male,"Male checkbox");
		}
		return this;
	}

	public SigninPage setName(String firstName, String lastName) {
		typeText(_signin.textbox_firstName, firstName,"First name");
		typeText(_signin.textbox_lastName, lastName,"last name");
		return this;
	}

	public SigninPage setPassword(String password) {
		typeText(_signin.textbox_newpassword, password,"Password");
		return this;
	}

	public SigninPage setDateOfBirth(String day, String month, String year) {
		selectByValue(_signin.dropdown_day, day,"Day");
		selectByValue(_signin.dropdown_month, month,"Month");
		selectByValue(_signin.dropdown_year, year,"Year");
		return this;
	}

	public SigninPage setCompanyName(String company) {
		typeText(_signin.textbox_company, company,"Company");
		return this;
	}

	public SigninPage setAddress(String address1, String address2, String city) {
		typeText(_signin.textbox_addressLine1, address1,"Address line 1");
		typeText(_signin.textbox_addressLine2, address2,"Address line 2");
		typeText(_signin.textbox_city, city,"City");
		return this;
	}
	
	public SigninPage setState(String state) {
		selectByVisibleText(_signin.dropdown_state, state,"State");
		return this;
	}
	
	public SigninPage setPostCode(String postCode) {
		typeText(_signin.textbox_postcode, postCode,"Post code");
		return this;
	}
	
	public SigninPage setOther(String other) {
		typeText(_signin.textbox_other, other,"Other");
		return this;
	}
	
	public SigninPage setContactInfo(String phone,String mobile) {
		typeText(_signin.textbox_phone, phone,"Phone");
		typeText(_signin.textbox_mobile, mobile,"Mobile number");
		return this;
	}
	
	public SigninPage setAlias(String alias) {
		typeText(_signin.textbox_alias, alias,"alias");
		return this;
	}
	
	public SigninPage submitSignUpForm() {
		clickOnElement(_signin.btn_submitForm,"submit");
		return this;
	}
	
	public String getHeaderString() {
		waitForElement(_signin.heading_accountCreated);
		return _signin.heading_accountCreated.getText();
	}
	
	public String getAccountName() {
		waitForElement(_signin.text_accountName);
		return _signin.text_accountName.getText();
	}
	
	public String getAccountInfo() {
		waitForElement(_signin.text_accountInfo);
		return _signin.text_accountInfo.getText();
	}
	
	public boolean isLogOutButtonDisplayed() {
		waitForElement(_signin.btn_logout);
		return _signin.btn_logout.isDisplayed();
	}
	
	public SigninPage signIn(String email,String password) {
		typeText(_signin.textbox_email, email,"Email");
		typeText(_signin.textbox_password, password,"Password");
		clickOnElement(_signin.btn_submitLogin,"Sign in");
		return this;
	}

	

}
