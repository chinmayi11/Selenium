package com.RestaurentTests;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DataHandlers.ExcelUtility;
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
		homePageObject.selectCustomers();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		customerPageObject=new CustomerPage(driver);
		softAssertion = new SoftAssert();
		
	}
	
	@Test(enabled=true, priority=0)
	public void validateCustomerTableFields() 
	{
		
		softAssertion.assertTrue(customerPageObject.isTableHeaderCustomerNameDisplayed(),"Customer name not displayed");
		softAssertion.assertTrue(customerPageObject.isTableHeaderDiscountDisplayed(),"Discount header not displayed");
		softAssertion.assertTrue(customerPageObject.isTableHeaderPhoneDisplayed(),"Phone header not displayed");
		softAssertion.assertTrue(customerPageObject.isTableHeaderEmailDisplayed(),"Email header not displayed");
		softAssertion.assertTrue(customerPageObject.isTableHeaderCreatedAtDisplayed(),"CreatedAt header not displayed");
		softAssertion.assertTrue(customerPageObject.istableHeaderActionDisplayed(),"Action header not displayed");
		softAssertion.assertAll();
	}

	@Test(enabled=true, priority=1)
	public void validationOfCustomerPageMainFields() 
	{
		softAssertion.assertTrue(customerPageObject.isShowNumberOfEntriesFieldDisplayed());
		softAssertion.assertTrue(customerPageObject.isAddCustomerButtonEnabled());
		softAssertion.assertTrue(customerPageObject.isSearchBarEnabled());
		softAssertion.assertAll();

		
	}
	
	@Test(enabled=true,priority=2)
	public void validationOfValidCustomerSearch() throws Exception
	{
		String ValidName="Jasmin";
		customerPageObject.searchCustomer(ValidName);
		String searchData=customerPageObject.searchTableCustomerName.getText();
		Assert.assertEquals(searchData, ValidName,"**both elements are not same***");
	}
	
	@Test(enabled=true,priority=3)
	public void validateNullValueSearch() throws Exception
	{
		String invalidName="gjhjsh";
		customerPageObject.searchCustomer(invalidName);
		String searchData=customerPageObject.searchTableCustomerName.getText();
		Assert.assertEquals(searchData, "No matching records found","No such user found in table");
	}
	
	@Test(enabled=true, priority=4)
	public void validationOfAddCustomersFields()
	{
		softAssertion.assertTrue(customerPageObject.isAddCustomerButtonEnabled(), "ADD CUSTOMER button is disabled");
		customerPageObject.clickOnAddCustomerButton();
		softAssertion.assertTrue(customerPageObject.isCustomerNameFieldEnabled(),"Customer name input field is disabled");
		softAssertion.assertTrue(customerPageObject.isCustomerPhoneFieldEnabled(), "Customer phone input field is disabled");
		softAssertion.assertTrue(customerPageObject.isCustomerEmailFieldEnabled(), "Customer email input field is disabled");
		softAssertion.assertTrue(customerPageObject.isCustomerDiscountFieldEnabled(), "Customer discount input field is disabled");
		softAssertion.assertTrue(customerPageObject.isCustomerSubmitButtonEnabled(), "Submit button is disabled");
		softAssertion.assertTrue(customerPageObject.isCloseButtonEnabled(), "Close button is disabled");
		softAssertion.assertAll();
		customerPageObject.clickOnCloseButton();

	}
	
	@Test(dataProvider="CustomerData", enabled=true, priority=5)
	public void validationOfAddNewCustomer(String CustName,String phone,String mail, String discount) throws Exception
	{
		customerPageObject.clickOnAddCustomerButton();
		customerPageObject.typeCustomerName(CustName);
		customerPageObject.typeCustomerPhone(phone);
		customerPageObject.typeCustomerEmail(mail);
		customerPageObject.typeCustomerDiscount(discount);
		customerPageObject.clickonSubmitButton();
		customerPageObject.searchCustomer(CustName);
		String searchData=customerPageObject.searchTableCustomerName.getText();
		Assert.assertEquals(searchData, CustName,"New customer addition failed");
		
	}
	
	@DataProvider (name="CustomerData")
	public Object[][] dataProviderMethod()
	{
		Object[][] data=new Object[1][4];
		data[0][0]="Chinnu";
		data[0][1]="9786735773";
		data[0][2]="chinnu@gmail.com";
		data[0][3]="10";
		return data;
		
	}
	
	@Test(enabled=true, priority=6)
	public void validationOfDeleteCustomer() throws Exception
	{
		customerPageObject.searchCustomer("Chinnu");
		customerPageObject.clickDeleteButton();
		customerPageObject.searchCustomer("Chinnu");
		String searchData=customerPageObject.searchTableCustomerName.getText();
		Assert.assertEquals(searchData, "No matching records found","Deletion unsuccessfull");	
	}
	
	@Test(enabled=true,priority=7)
	public void validationOfCustomerEditPageFields()
	{
		softAssertion.assertTrue(customerPageObject.isEditButtonEnabled(), "Edit button is disabled");
		customerPageObject.clickEditButton();;
		softAssertion.assertTrue(customerPageObject.isCustomerNameFieldEnabled(),"Customer name input field is disabled");
		softAssertion.assertTrue(customerPageObject.isCustomerPhoneFieldEnabled(), "Customer phone input field is disabled");
		softAssertion.assertTrue(customerPageObject.isCustomerEmailFieldEnabled(), "Customer email input field is disabled");
		softAssertion.assertTrue(customerPageObject.isCustomerDiscountFieldEnabled(), "Customer discount input field is disabled");
		softAssertion.assertTrue(customerPageObject.isCustomerSubmitButtonEnabled(), "Submit button is disabled");
		softAssertion.assertTrue(customerPageObject.isBackButtonEnabled(),"Back button is disabled");
		softAssertion.assertAll();
		customerPageObject.clickBackButton();
	}
	
	@Test (dataProvider="CustomerEditData", priority=8, enabled=true)
	public void validationOfCustomerEditDetails(String CustName,String phone,String mail, String discount) throws Exception
	{	
		customerPageObject.clickEditButton();;
	customerPageObject.typeCustomerName(CustName);
	customerPageObject.typeCustomerPhone(phone);
	customerPageObject.typeCustomerEmail(mail);
	customerPageObject.typeCustomerDiscount(discount);
	customerPageObject.clickonSubmitButton();
	customerPageObject.searchCustomer(CustName);
	String searchData=customerPageObject.searchTableCustomerName.getText();
	Assert.assertEquals(searchData, CustName,"New customer addition failed");
	}
	
	@DataProvider (name="CustomerEditData")
	public Object[][] dataProviderEditMethod()
	{
		Object[][] data=new Object[1][4];
		data[0][0]="Anna";
		data[0][1]="7863987458";
		data[0][2]="hanna@gmail.com";
		data[0][3]="10";
		return data;
		
	}
}
