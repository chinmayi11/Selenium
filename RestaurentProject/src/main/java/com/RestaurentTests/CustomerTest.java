package com.RestaurentTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.RestaurentPages.CustomerPage;
import com.RestaurentPages.HomePage;
import com.RestaurentPages.LoginPage;
import com.RestaurentPages.WaiterPage;

public class CustomerTest extends BaseTest{
	
	public CustomerTest() {
		super();
	}
	
	LoginPage loginPageObject;
	HomePage homePageObject;
	WebDriver driver;
	WaiterPage waiterPageObject;
	CustomerPage customerPageObject;
	SoftAssert softAssertion;

	
	@Parameters("browserType")
	@BeforeMethod
	public void setup(String browserType) throws IOException {
		driver = launchBrowser(browserType);
		
		loginPageObject=new LoginPage(driver);
		loginPageObject.login();
		homePageObject = new HomePage(driver);
		homePageObject.selectCustomers();
		customerPageObject=new CustomerPage(driver);
		
	}
	
	@Test
	public void validateCustomerTableFields() throws Exception
	{
		softAssertion = new SoftAssert();
		softAssertion.assertTrue(customerPageObject.isTableHeaderCustomerNameDisplayed(),"Customer name not displayed");
		softAssertion.assertTrue(customerPageObject.isTableHeaderDiscountDisplayed(),"Discount header not displayed");
		softAssertion.assertTrue(customerPageObject.isTableHeaderPhoneDisplayed(),"Phone header not displayed");
		softAssertion.assertTrue(customerPageObject.isTableHeaderEmailDisplayed(),"Email header not displayed");
		softAssertion.assertTrue(customerPageObject.isTableHeaderCreatedAtDisplayed(),"CreatedAt header not displayed");
		softAssertion.assertTrue(customerPageObject.istableHeaderActionDisplayed(),"Action header not displayed");
		softAssertion.assertAll();
	}

}
