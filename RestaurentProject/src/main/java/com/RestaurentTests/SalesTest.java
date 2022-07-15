package com.RestaurentTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.RestaurentPages.CustomerPage;
import com.RestaurentPages.HomePage;
import com.RestaurentPages.LoginPage;
import com.RestaurentPages.SalesPage;

public class SalesTest extends BaseTest{
	
	public SalesTest()
	{
		super();
	}
	
	WebDriver driver;
	LoginPage loginPageObject;
	SalesPage salePageObject;
	HomePage homePageObject;
	SoftAssert softAssertion;



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
		homePageObject.selectSales();
		salePageObject=new SalesPage(driver);
		softAssertion = new SoftAssert();
		
	}

	@Test(enabled=false, priority=0)
	public void ValidateSalesPageFields() throws Exception
	{
		softAssertion.assertTrue(salePageObject.isSalesHeaderDisplayed(),"Sales header not displayed");
		softAssertion.assertTrue(salePageObject.isSearchLabelDisplayed(),"Search tab not present");
		softAssertion.assertTrue(salePageObject.istableHeaderNumberDisplayed(),"Name header not displayed");
		softAssertion.assertTrue(salePageObject.istableHeaderActionDisplayed(),"Action header not displayed");
		softAssertion.assertTrue(salePageObject.istableHeaderCreatedByDisplayed(),"Created By header not displayed");
		softAssertion.assertTrue(salePageObject.istableHeaderCustomerDisplayed(),"Customer header not displayed");
		softAssertion.assertTrue(salePageObject.istableHeaderDiscountDisplayed(),"Discount header not displayed");
		softAssertion.assertTrue(salePageObject.istableHeaderStatusDisplayed(),"Status header not displayed");
		softAssertion.assertTrue(salePageObject.istableHeaderTaxDisplayed(),"Tax header not displayed");
		softAssertion.assertTrue(salePageObject.istableHeaderTotalDisplayed(),"Total header not displayed");
		softAssertion.assertTrue(salePageObject.istableHeaderTotalItemsDisplayed(),"Total Items header not displayed");
		softAssertion.assertTrue(salePageObject.isSaleActionButtonEnabled());
		softAssertion.assertAll();
	}

	@Test(enabled=false, priority=1)
	public void validateActionOptions() throws Exception
	{
		salePageObject.clickActionButton();
		softAssertion.assertTrue(salePageObject.isEditOptionEnabled(),"Edit option is disabled");
		softAssertion.assertTrue(salePageObject.isPaymentOptionEnabled(),"Payment option is disabled");
		softAssertion.assertTrue(salePageObject.isInvoiceOptionEnabled(),"Invoice option is disbaled");
		softAssertion.assertTrue(salePageObject.isReceiptOptionEnabled(),"Receipt option is disabled");
		softAssertion.assertAll();
	}
	
	@Test(enabled=true, priority=3)
	public void validationOfEditPageFields() throws Exception
	{
		salePageObject.clickActionButton();
		salePageObject.clickSalesEdit();
		softAssertion.assertTrue(salePageObject.isChangeClientDropDownEnabled(),"Change client option disabled");
		softAssertion.assertTrue(salePageObject.isChangeStatusDropDownEnabled(),"Status dropdown is disabled");
		softAssertion.assertTrue(salePageObject.isEditSubmitButtonEnabled(),"Submit button disabled");
		softAssertion.assertTrue(salePageObject.isEditCloseButtonEnabled(), "Close button is disabled");
		salePageObject.clickEditCloseButton();
	}
	
	@Test (enabled=true,  priority=4)
	public void validationOfEditCustomerNameAndStatus() throws Exception
	{
		//String ValidName="John Doe";
		salePageObject.clickActionButton();
		salePageObject.clickSalesEdit();
		salePageObject.selectClient("John Doe");
		salePageObject.selectStatus("Partially paid");
		salePageObject.clickSaleEditSubmitButton();
		salePageObject.searchCustomer("John Doe");
		String searchData=salePageObject.searchTableCustomerName.getText();
		Assert.assertEquals(searchData, "John Doe","**edit failed");
	}
	
	@Test (enabled=false,  priority=2)
	public void validationOfInvoicePopUp()
	{
		salePageObject.clickActionButton();
		salePageObject.clickInvoice();
		softAssertion.assertTrue(salePageObject.isCloseButtonEnabled(), "Close Button not displayed");
		softAssertion.assertTrue(salePageObject.isPDFButtonEnabled(), "PDF button not displayed");
		softAssertion.assertAll();
		salePageObject.clickCloseButton();
	}
	
	@Test(enabled=false)
	public void ValidationOfPaymentPopUp()
	{
		salePageObject.clickActionButton();
		salePageObject.clickPayment();
		softAssertion.assertTrue(salePageObject.isClosePaymentButtonEnabled(), "Close Button not displayed");
		softAssertion.assertAll();
		salePageObject.clickPaymentCloseButton();
		
		
		
	}
}
