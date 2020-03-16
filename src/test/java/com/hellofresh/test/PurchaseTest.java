package com.hellofresh.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hellofresh.pages.CheckOutPage;
import com.hellofresh.pages.PurchasePage;
import com.hellofresh.pages.SigninPage;
import com.hellofresh.utils.TestDataUtils;
import com.hellofresh.webframe.BaseTest;

public class PurchaseTest extends BaseTest {

	static List<String> propertyFiles = new ArrayList<String>();
	Map<String, String> dataTable = new HashMap<String, String>();
	SigninPage signin;
	PurchasePage purchase;
	CheckOutPage checkout;

	@BeforeClass(alwaysRun = true)
	public void dataSetup() {
		propertyFiles.add("purchase");
		propertyFiles.add("checkout");
		dataTable = TestDataUtils.initData(propertyFiles);
	}

	@BeforeMethod(alwaysRun = true)
	public void launchApp() {
		getDriver().get(dataTable.get("domain_url"));
		getDriver().manage().window().maximize();
	}

	@Test(testName = "Verify tshirt purchase" , description = "Verify whether user is able place order")
	public void purchaseTshirt() {
		
		signin = new SigninPage(getDriver());
		signin.clickSignInButton().signIn(dataTable.get("purchase_username"), dataTable.get("purchase_password"));
		purchase = new PurchasePage(getDriver());

		purchase.selectCategory(dataTable.get("category")).selectProduct(dataTable.get("product")).submit();

		checkout = new CheckOutPage(getDriver());

		checkout.proceedToCheckOut();

		Assert.assertEquals(checkout.getHeader(), dataTable.get("confirmationHeader"));

		Assert.assertTrue(checkout.isLastStepTabDisplayed());
		Assert.assertTrue(checkout.isCurrentStepTabDisplayed());
		Assert.assertTrue(checkout.getConfirmationString().contains(dataTable.get("orderConfirmationText")),"Verify order confirmation");
		Assert.assertTrue(getDriver().getCurrentUrl().contains(dataTable.get("urlController")),"Verify URL controller"); 	
	}

}
