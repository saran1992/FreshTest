package com.hellofresh.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hellofresh.pages.SigninPage;
import com.hellofresh.utils.TestDataUtils;
import com.hellofresh.utils.TestUtils;
import com.hellofresh.webframe.BaseTest;

public class SigninTest extends BaseTest {
	static List<String> propertyFiles = new ArrayList<String>();
	Map<String, String> dataTable = new HashMap<String, String>();

	@BeforeClass(alwaysRun = true)
	public void dataSetup() {
		propertyFiles.add("signin");
		dataTable = TestDataUtils.initData(propertyFiles);
	}

	@BeforeMethod(alwaysRun = true)
	public void launchApp() {
		getDriver().get(dataTable.get("domain_url"));
		getDriver().manage().window().maximize();
	}

	@Test(testName = "Verify new sign up", description = "Verify whether user is able to create a new account")
	public void newSignUp() {

		String email = dataTable.get("email").replace("TEMP", TestUtils.getDateString("yyyyMMddHHmmssSSS"));
		SigninPage signin = new SigninPage(getDriver());
		signin.clickSignInButton().setNewEmail(email).setGender(dataTable.get("gender"))
				.setName(dataTable.get("firstname"), dataTable.get("lastname"))
				.setPassword(dataTable.get("newpassword"))
				.setDateOfBirth(dataTable.get("day"), dataTable.get("month"), dataTable.get("year"))
				.setCompanyName(dataTable.get("company"))
				.setAddress(dataTable.get("address"), dataTable.get("address2"), dataTable.get("city"))
				.setState(dataTable.get("state")).setPostCode(dataTable.get("postcode"))
				.setOther(dataTable.get("other")).setContactInfo(dataTable.get("phone"), dataTable.get("mobile"))
				.setAlias(dataTable.get("alias")).submitSignUpForm();

		Assert.assertEquals(signin.getAccountName(), dataTable.get("firstname") + " " + dataTable.get("lastname"),
				"Verify first and last name");
		Assert.assertEquals(signin.getHeaderString(), dataTable.get("accountHeader"),"Verify account header");
		Assert.assertTrue(signin.getAccountInfo().contains(dataTable.get("welcomeText")),"Verify welcome text");
		Assert.assertTrue(signin.isLogOutButtonDisplayed(),"Verify logout button");
		Assert.assertTrue(getDriver().getCurrentUrl().contains(dataTable.get("urlController")),"Verify URL controller");

	}

	@Test(testName = "Verify login", description = "Verify whether user is able to login with valid credentials", groups = "Sanity")
	public void validLogin() {
		SigninPage signin = new SigninPage(getDriver());
		signin.clickSignInButton().signIn(dataTable.get("existingUserEmail"), dataTable.get("existingUserPassword"));

		Assert.assertTrue(signin.isLogOutButtonDisplayed(),"Verify logout button");
		Assert.assertEquals(signin.getAccountName(), dataTable.get("fullname"),"Verify firstname and last name");
		Assert.assertEquals(signin.getHeaderString(), dataTable.get("accountHeader"),"Verify account header");
		Assert.assertTrue(signin.getAccountInfo().contains(dataTable.get("welcomeText")),"Verify welcome text");
		Assert.assertTrue(getDriver().getCurrentUrl().contains(dataTable.get("urlController")),"Verify url controller");
		//False failure to demonstrate screenshot on failed test step
		Assert.assertTrue(false,"Failure to demonstrate screenshot in reports");
	}

}
