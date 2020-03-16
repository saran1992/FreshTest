package com.hellofresh.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPageObjects {
	
	@FindBy(className = "login")
	public WebElement btn_signin;
	
	@FindBy(id = "email_create")
	public WebElement textbox_newEmail;
	
	@FindBy(id = "SubmitCreate")
	public WebElement btn_submitNewEmail;
	
	@FindBy(id = "id_gender2")
	public WebElement btn_gender_female;
	
	@FindBy(id = "id_gender1")
	public WebElement btn_gender_male;
	
	@FindBy(id = "customer_firstname")
	public WebElement textbox_firstName;
	
	@FindBy(id = "customer_lastname")
	public WebElement textbox_lastName;
	
	@FindBy(id = "passwd")
	public WebElement textbox_newpassword;
	
	@FindBy(id = "days")
	public WebElement dropdown_day;
	
	@FindBy(id = "months")
	public WebElement dropdown_month;
	
	@FindBy(id = "years")
	public WebElement dropdown_year;
	
	@FindBy(id = "address1")
	public WebElement textbox_addressLine1;
	
	@FindBy(id = "address2")
	public WebElement textbox_addressLine2;
	
	@FindBy(id = "city")
	public WebElement textbox_city;
	
	@FindBy(id = "company")
	public WebElement textbox_company;

	@FindBy(id = "id_state")
	public WebElement dropdown_state;
	
	@FindBy(id = "postcode")
	public WebElement textbox_postcode;
	
	@FindBy(id = "other")
	public WebElement textbox_other;
	
	@FindBy(id = "phone")
	public WebElement textbox_phone;
	
	@FindBy(id = "phone_mobile")
	public WebElement textbox_mobile;
	
	@FindBy(id = "alias")
	public WebElement textbox_alias;
	
	@FindBy(id = "submitAccount")
	public WebElement btn_submitForm;
	
	@FindBy(css = "h1")
	public WebElement heading_accountCreated;
	
	@FindBy(className = "account")
	public WebElement text_accountName;
	
	@FindBy(className = "info-account")
	public WebElement text_accountInfo;
	
	@FindBy(className = "logout")
	public WebElement btn_logout;
	
	@FindBy(id = "email")
	public WebElement textbox_email;
	
	@FindBy(id = "passwd")
	public WebElement textbox_password;
	
	@FindBy(id = "SubmitLogin")
	public WebElement btn_submitLogin;

}
