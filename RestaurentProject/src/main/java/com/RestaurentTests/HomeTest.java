package com.RestaurentTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DataHandlers.ExcelUtility;
import com.RestaurentPages.HomePage;
import com.RestaurentPages.LoginPage;

public class HomeTest extends BaseTest{
	
	HomePage homePageObject;
	WebDriver driver;
	LoginPage loginPageObject;
	ExcelUtility excelUtil;
	SoftAssert softAssertion;
	public HomeTest()
	{
		super();
	}
	
	@Parameters("browserType")
	@BeforeMethod
	public void setup(String browserType) throws IOException {
		driver = launchBrowser(browserType);
		
		loginPageObject=new LoginPage(driver);
		loginPageObject.login();
		homePageObject = new HomePage(driver);
		softAssertion=new SoftAssert();
		
		

	}
	
	@Test(priority =0, enabled=true)
	public void validateUserDetails() throws Exception 
	{
		softAssertion.assertTrue(homePageObject.isadminNameDisplayed());
		softAssertion.assertTrue(homePageObject.isadminPhotoDisplayed());
		softAssertion.assertAll();
		System.out.println("Userdetails are displayed on homepage");
	}
		
		@Test(priority=1, enabled=true)
		public void validateMainNavigationLinks() throws Exception
		{
			softAssertion.assertTrue(homePageObject.isPosDisplayed());
			softAssertion.assertTrue(homePageObject.isProductDisplayed());
			softAssertion.assertTrue(homePageObject.isStoreDisplayed());
			softAssertion.assertTrue(homePageObject.isSaleDisplayed());
			softAssertion.assertTrue(homePageObject.isPeopleDisplayed());
			softAssertion.assertTrue(homePageObject.isExpenseDisplayed());
			softAssertion.assertTrue(homePageObject.isSettingsDisplayed());
			softAssertion.assertTrue(homePageObject.isReportsDisplayed());
			softAssertion.assertAll();
				System.out.println("Main navigation links are displayed on homepage");
				
		}
		
	@Test(priority=2, enabled=true)
	public void validationOfPeopleSubLinks() throws Exception
	{
		homePageObject.clickPeople();
		softAssertion.assertTrue(homePageObject.isWaitersDisplayed(),"Waiter sublink is not displayed");
		softAssertion.assertTrue(homePageObject.isCustomersDisplayed(),"Customers sublink is not displayed");
		softAssertion.assertTrue(homePageObject.isSuppliersDisplayed(),"Suppliers sublink is not displayed");
		softAssertion.assertAll();

	}
		

	@Test(priority=3, enabled=true)
	public void validationOfHomePageElements() throws Exception
	{
		softAssertion.assertTrue(homePageObject.isChooseStoreHeaderDisplayed(),"Choose store header not displayed");
		softAssertion.assertTrue(homePageObject.isStoreTitleDisplayed(),"store title not displayed");
		softAssertion.assertAll();
		

	}
	
	@Test(priority=4,enabled=true)
	public void peopleSubWaiters() {
		homePageObject = new HomePage(driver);
		homePageObject.selectWaiters();
	}
	@Test(priority=5,enabled=false)
	public void peopleCustomers() {
		homePageObject = new HomePage(driver);
		homePageObject.selectCustomers();
	}
	@Test(priority=6,enabled=false)
	public void peopleSuppliers() {
		homePageObject = new HomePage(driver);
		homePageObject.selectSuppliers();
	}
	
	@Test()
	public void validateExcel() throws IOException {
		excelUtil=new ExcelUtility();
		excelUtil.setExcelFileSheet("Waiter");
		String name=excelUtil.getCellData(1, 0);
		System.out.println("*****data from excel = "+name);
		
	}

	

}
