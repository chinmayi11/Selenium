package com.RestaurentTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DataHandlers.ExcelUtility;
import com.RestaurentPages.HomePage;
import com.RestaurentPages.LoginPage;
import com.RestaurentPages.WaiterPage;

public class WaiterTest extends BaseTest{

	public WaiterTest() {
		super();
	}
	
	LoginPage loginPageObject;
	HomePage homePageObject;
	WebDriver driver;
	WaiterPage waiterPageObject;
	SoftAssert softAssertion;

	
	@Parameters("browserType")
	@BeforeMethod
	public void setup(String browserType) throws IOException {
		driver = launchBrowser(browserType);
		
		loginPageObject=new LoginPage(driver);
		loginPageObject.login();
		homePageObject = new HomePage(driver);
		homePageObject.selectWaiters();
		waiterPageObject=new WaiterPage(driver);
	}
	
    @AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}


	
	@Test(enabled=false, priority=1)
	public void validateWaiterTableHeaders()
	{
		softAssertion=new SoftAssert();
		softAssertion.assertTrue(waiterPageObject.isWaiterNameDisplayed());
		softAssertion.assertTrue(waiterPageObject.isWaiterPhoneDisplayed());
		softAssertion.assertTrue(waiterPageObject.isWaiterEmailDisplayed());
		softAssertion.assertTrue(waiterPageObject.isWaiterStoreDisplayed());
		softAssertion.assertTrue(waiterPageObject.isWaiterActionDisplayed());
		softAssertion.assertTrue(waiterPageObject.isWaiterCreatedAtDisplayed());
		softAssertion.assertAll();
		
		}
		

	  
	@Test(enabled=false, priority=2)
	public void validateValidUserSearch() throws Exception
	{
		String ValidName="test";
		waiterPageObject.searchUsers(ValidName);
		//String searchData=wp.searchTableUserName.getText();
		//Assert.assertEquals(searchData, ValidName,"**both elements are not same***");
	}
	
	@Test(enabled=false, priority=3)
	public void validateNullValueSearch() throws Exception
	{
		String invalidName="sfsdg";
		waiterPageObject.searchUsers(invalidName);
		String searchData=waiterPageObject.searchTableUserName.getText();
		Assert.assertEquals(searchData, "No matching records found","No such user found in table");
	}
	
	@Test(enabled=false,priority=4)
	public void validationOfAddWatierFields()
	{
		try {
		Assert.assertTrue(waiterPageObject.isNameInputFieldEnabled());
		Assert.assertTrue(waiterPageObject.isPhoneInputFieldEnabled());
		Assert.assertTrue(waiterPageObject.isEmailFieldEnabled());
		Assert.assertTrue(waiterPageObject.isStoreFieldEnabled());
		Assert.assertTrue(waiterPageObject.isSubmitButtonEnabled());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test(priority=1, enabled = false)
	public void validateAddNewWaiter() throws Exception
	{
		try {
		waiterPageObject.clickonAddWaiters();
		waiterPageObject.typeWaiterName("gokul");
		waiterPageObject.typeEmail("gokul@gmail.com");
		waiterPageObject.typePhone("985677644");
		waiterPageObject.selectStoreID("Le_CAFE");	
		waiterPageObject.clickSubmitButton();
		waiterPageObject.searchUsers("gokul");
		String searchData=waiterPageObject.searchTableUserName.getText();
		Assert.assertEquals(searchData, "gokul","Waiter addition failed");
		
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Test(priority=6,enabled=false)
	public void validateDeleteWaiter() throws Exception
	{
		waiterPageObject.searchUsers("test");
		waiterPageObject.clickDeleteButton();
		waiterPageObject.searchUsers("test");
		String searchData=waiterPageObject.searchTableUserName.getText();
		Assert.assertEquals(searchData, "No matching records found","Deleyion unsuccfull");		
		
	}
		
	@Test(enabled=false)
	public void validateEditUserDetails() throws Exception
	{
		
		String actualName="Test";
		String updatedName="Test2";
		waiterPageObject.searchUsers(actualName);		
		waiterPageObject.clickEditButton();
		waiterPageObject.typeWaiterName(updatedName);
		waiterPageObject.typeEmail("test@gmail.com");
		waiterPageObject.typePhone("985677644");
		waiterPageObject.selectStoreID("Le_CAFE");
		waiterPageObject.clickSubmitButton();
		waiterPageObject.searchUsers("Test2");
		softAssertion.assertEquals(actualName, updatedName, "Name not updated");
		softAssertion.assertAll();
	}
	
	@Test(enabled=false)
	public void validateEditPageFields() throws Exception
	{
		String actualName="Faisal";
		waiterPageObject.searchUsers(actualName);		
	    waiterPageObject.clickEditButton();
	    softAssertion=new SoftAssert();
	    softAssertion.assertTrue(waiterPageObject.isNameInputFieldEnabled(),"Name field is disabled");
		softAssertion.assertTrue(waiterPageObject.isEmailFieldEnabled(),"Email field is disabled");
		softAssertion.assertTrue(waiterPageObject.isPhoneInputFieldEnabled(),"Phone field is disabled");
		softAssertion.assertTrue(waiterPageObject.isStoreFieldEnabled(),"Store field is disabled");
		softAssertion.assertTrue(waiterPageObject.isSubmitButtonEnabled(),"Submit button is disabled");
		softAssertion.assertAll();

	}
	
	@Test
	public void excelRead() throws IOException
	{
		ExcelUtility excelda=new ExcelUtility();
		excelda.setExcelFileSheet("Waiter");
		System.out.println("********"+excelda.getCellData(1, 0));
	}
	
}
