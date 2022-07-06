package com.RestaurentTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.RestaurentPages.HomePage;
import com.RestaurentPages.LoginPage;
import com.RestaurentPages.SalesPage;

public class SalesTest extends BaseTest{
	
	public SalesTest()
	{
		super();
	}
	
	WebDriver driver;
	LoginPage lp;
	SalesPage sp;
	HomePage hp;


	
	@Parameters("browserType")
	@BeforeMethod
	public void setup(String browserType) throws IOException {
		driver = launchBrowser(browserType);
		if(driver==null)
		{
			System.out.println("before sale");
		}
		else
		lp=new LoginPage(driver);
		lp.login();
		hp=new HomePage(driver);
		hp.selectSales();
		sp=new SalesPage(driver);
		
		
		
	}
	public void ValidateSalesPageFields() throws Exception
	{
		Assert.assertTrue(sp.isSalesHeaderDisplayed(),"Sales header not displayed");
		Assert.assertTrue(sp.isSearchLabelDisplayed(),"Search tab not present");
		Assert.assertTrue(sp.istableHeaderNumberDisplayed(),"Name header not displayed");
		Assert.assertTrue(sp.istableHeaderActionDisplayed(),"Action header not displayed");
		Assert.assertTrue(sp.istableHeaderCreatedByDisplayed(),"Created By header not displayed");
		Assert.assertTrue(sp.istableHeaderCustomerDisplayed(),"Customer header not displayed");
		Assert.assertTrue(sp.istableHeaderDiscountDisplayed(),"Discount header not displayed");
		Assert.assertTrue(sp.istableHeaderStatusDisplayed(),"Status header not displayed");
		Assert.assertTrue(sp.istableHeaderTaxDisplayed(),"Tax header not displayed");
		Assert.assertTrue(sp.istableHeaderTotalDisplayed(),"Total header not displayed");
		Assert.assertTrue(sp.istableHeaderTotalItemsDisplayed(),"Total Items header not displayed");
		Assert.assertTrue(sp.isSaleActionButtonEnabled());
	}

	@Test
	public void validateActionOptions() throws Exception
	{
		sp.clickActionButton();
		Assert.assertTrue(sp.isEditOptionEnabled(),"Edit option is disabled");
		Assert.assertTrue(sp.isPaymentOptionEnabled(),"Payment option is disabled");
		Assert.assertTrue(sp.isInvoiceOptionEnabled(),"Invoice option is disbaled");
		Assert.assertTrue(sp.isReceiptOptionEnabled(),"Receipt option is disabled");
	}
	
	@Test
	public void validateSaleEditOption() throws Exception
	{
		sp.clickSalesEdit();
		Assert.assertTrue(sp.isChangeClientDropDownEnabled(),"Change client option disabled");
		sp.selectClient("Jasmin");
		Assert.assertTrue(sp.isChangeStatusDropDownEnabled(),"Status dropdown is disabled");
		sp.selectStatus("Partially paid");
		Assert.assertTrue(sp.isEditSubmitButtonEnabled(),"Submit button disabled");
		sp.clickSaleEditSubmitButton();
	}

}
