package com.RestaurentTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DataHandlers.ExcelUtility;
import com.RestaurentPages.HomePage;
import com.RestaurentPages.LoginPage;

public class HomeTest extends BaseTest{
	
	HomePage hp;
	WebDriver driver;
	LoginPage lp;
	ExcelUtility ex;
	public HomeTest()
	{
		super();
	}
	
	@Test(priority =1, enabled=false)
	public void validateUserDetails() 
	{
		try {
		Assert.assertTrue(hp.isadminNameDisplayed());
		Assert.assertTrue(hp.isadminPhotoDisplayed());
		System.out.println("Userdetails are displayed on homepage");
		
	}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
		
		@Test(priority=2, enabled=false)
		public void validateMainNavigationLinks()
		{
			try
			{
				Assert.assertTrue(hp.isPosDisplayed());
				Assert.assertTrue(hp.isProductDisplayed());
				Assert.assertTrue(hp.isStoreDisplayed());
				Assert.assertTrue(hp.isSaleDisplayed());
				Assert.assertTrue(hp.isPeopleDisplayed());
				Assert.assertTrue(hp.isExpenseDisplayed());
				Assert.assertTrue(hp.isSettingsDisplayed());
				Assert.assertTrue(hp.isReportsDisplayed());
				System.out.println("Main navigation links are displayed on homepage");
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
	@Test(priority=1,enabled=true)
	public void peopleSubWaiters() {
		hp = new HomePage(driver);
		hp.selectWaiters();
	}
	@Test(priority=3,enabled=false)
	public void peopleCustomers() {
		hp = new HomePage(driver);
		hp.selectCustomers();
	}
	@Test(priority=3,enabled=false)
	public void peopleSuppliers() {
		hp = new HomePage(driver);
		hp.selectSuppliers();
	}
	
	@Parameters("browserType")
	@BeforeMethod
	public void setup(String browserType) throws IOException {
		driver = launchBrowser(browserType);
		
		lp=new LoginPage(driver);
		lp.login();
		hp = new HomePage(driver);
		
		

	}
	
	@Test()
	public void validateExcel() throws IOException {
		ex=new ExcelUtility();
		ex.setExcelFileSheet("Waiter");
		String name=ex.getCellData(1, 0);
		System.out.println("*****data from excel = "+name);
		
	}

	

}
