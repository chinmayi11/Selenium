package com.RestaurentTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DataHandlers.ExcelUtility;
import com.RestaurentPages.CustomerPage;
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
	ExcelUtility excelObject;

	

	
	@Parameters("browserType")
	@BeforeTest
	public void setup(String browserType) throws IOException {
		driver = launchBrowser(browserType);
		
		loginPageObject=new LoginPage(driver);
		loginPageObject.login();
	}
	
	@BeforeMethod
	public void launch() throws IOException {
		
		homePageObject = new HomePage(driver);
		homePageObject.selectWaiters();
		waiterPageObject=new WaiterPage(driver);
		softAssertion = new SoftAssert();
		
	}
	
    //@AfterMethod
	//public void closeBrowser()
	//{
		//driver.quit();
	//}


	
	@Test(enabled=true, priority=0)
	public void validateWaiterTableHeaders()
	{
		//softAssertion=new SoftAssert();
		softAssertion.assertTrue(waiterPageObject.isWaiterNameDisplayed());
		softAssertion.assertTrue(waiterPageObject.isWaiterPhoneDisplayed());
		softAssertion.assertTrue(waiterPageObject.isWaiterEmailDisplayed());
		softAssertion.assertTrue(waiterPageObject.isWaiterStoreDisplayed());
		softAssertion.assertTrue(waiterPageObject.isWaiterActionDisplayed());
		softAssertion.assertTrue(waiterPageObject.isWaiterCreatedAtDisplayed());
		softAssertion.assertAll();
	
	}
	
	@Test(enabled=true, priority=1)
	public void validationOfWaiterPageElements()
	{
		softAssertion.assertTrue(waiterPageObject.isAddWaiterButtonDisplayed(),"Add waiter button not displayed");
		softAssertion.assertTrue(waiterPageObject.isSearchBarDisplayed(),"Search bar not displayed");
		softAssertion.assertTrue(waiterPageObject.isShowEntriesDropdown(),"Show entries dropdown not displayed");
		softAssertion.assertAll();



	}

	  
	@Test(enabled=true, priority=2)
	public void validateValidWaiterSearch() throws Exception
	{
		String ValidName="henry";
		waiterPageObject.searchUsers(ValidName);
		String searchData=waiterPageObject.searchTableUserName.getText();
		Assert.assertEquals(searchData, ValidName,"**both elements are not same***");
	}
	
	@Test(enabled=true, priority=3)
	public void validateWrongValueSearch() throws Exception
	{
		String invalidName="sfsdg";
		waiterPageObject.searchUsers(invalidName);
		String searchData=waiterPageObject.searchTableUserName.getText();
		Assert.assertEquals(searchData, "No matching records found","No such user found in table");
	}
	
	@Test(enabled=true,priority=4)
	public void validationOfAddWatierInputFields()
	{
		
		softAssertion.assertTrue(waiterPageObject.isNameInputFieldEnabled());
		softAssertion.assertTrue(waiterPageObject.isPhoneInputFieldEnabled());
		softAssertion.assertTrue(waiterPageObject.isEmailFieldEnabled());
		softAssertion.assertTrue(waiterPageObject.isStoreFieldEnabled());
		softAssertion.assertTrue(waiterPageObject.isSubmitButtonEnabled());
		softAssertion.assertAll();
		
		
	}
	
	@Test(priority=5, enabled = true)
	public void validationOfAddNewWaiter() throws Exception
	{
		waiterPageObject.clickonAddWaiters();
		excelObject=new ExcelUtility();
		excelObject.setExcelFileSheet("Waiter");
		waiterPageObject.typeWaiterName(excelObject.getCellData(1, 0));
		waiterPageObject.typePhone(excelObject.getCellData(1, 1));
		waiterPageObject.typeEmail(excelObject.getCellData(1, 2));
		waiterPageObject.selectStoreID(excelObject.getCellData(1, 3));	
		waiterPageObject.clickSubmitButton();
		waiterPageObject.searchUsers(excelObject.getCellData(1, 0));
		String searchData=waiterPageObject.searchTableUserName.getText();
		String cellDataName=excelObject.getCellData(1, 0);
		Assert.assertEquals(searchData, cellDataName,"Waiter addition failed");
	
		
		
	}

	@Test(priority=6,enabled=true)
	public void validateDeleteWaiter() throws Exception
	{
		waiterPageObject.searchUsers("gauri");
		waiterPageObject.clickDeleteButton();
		waiterPageObject.searchUsers("gauri");
		String searchData=waiterPageObject.searchTableUserName.getText();
		Assert.assertEquals(searchData, "No matching records found","Deletion unsuccessfull");		
		
	}
		
	@Test(enabled=true, priority=7)
	public void validateEditPageFields() throws Exception
	{
			
	    waiterPageObject.clickEditButton();
	    softAssertion=new SoftAssert();
	    softAssertion.assertTrue(waiterPageObject.isNameInputFieldEnabled(),"Name field is disabled");
		softAssertion.assertTrue(waiterPageObject.isEmailFieldEnabled(),"Email field is disabled");
		softAssertion.assertTrue(waiterPageObject.isPhoneInputFieldEnabled(),"Phone field is disabled");
		softAssertion.assertTrue(waiterPageObject.isStoreFieldEnabled(),"Store field is disabled");
		softAssertion.assertTrue(waiterPageObject.isSubmitButtonEnabled(),"Submit button is disabled");
		softAssertion.assertAll();

	}
	
	
	@Test(enabled=true, priority=8)
	public void validateEditUserDetails() throws Exception
	{
		excelObject=new ExcelUtility();
		String actualName="meenu";
		
		excelObject.setExcelFileSheet("Waiter");
		waiterPageObject.searchUsers(actualName);		
		waiterPageObject.clickEditButton();
		waiterPageObject.typeWaiterName(excelObject.getCellData(2, 0));
		waiterPageObject.typePhone(excelObject.getCellData(2, 1));
		waiterPageObject.typeEmail(excelObject.getCellData(2, 2));
		waiterPageObject.selectStoreID(excelObject.getCellData(2, 3));
		waiterPageObject.clickSubmitButton();
		String updatedName=excelObject.getCellData(2, 0);
		waiterPageObject.searchUsers(updatedName);
		softAssertion.assertEquals(actualName, updatedName, "Name not updated");
		softAssertion.assertAll();
	}


	
}
