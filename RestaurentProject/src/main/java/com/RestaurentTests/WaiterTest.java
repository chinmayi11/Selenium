package com.RestaurentTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.RestaurentPages.HomePage;
import com.RestaurentPages.LoginPage;
import com.RestaurentPages.WaiterPage;

public class WaiterTest extends BaseTest{
	public WaiterTest() {
		super();
	}
	LoginPage lp;
	HomePage hp;
	WebDriver driver;
	WaiterPage wp;

	
	@Parameters("browserType")
	@BeforeMethod
	public void setup(String browserType) throws IOException {
		driver = launchBrowser(browserType);
		lp=new LoginPage(driver);
		lp.login();
		hp = new HomePage(driver);
		hp.selectWaiters();
		wp=new WaiterPage(driver);
	}

	@Test(enabled=false)
	public void validateWaiterTableHeaders()
	{
		try {
		Assert.assertTrue(wp.isWaiterNameDisplayed());
		Assert.assertTrue(wp.isWaiterPhoneDisplayed());
		Assert.assertTrue(wp.isWaiterEmailDisplayed());
		Assert.assertTrue(wp.isWaiterStoreDisplayed());
		Assert.assertTrue(wp.isWaiterActionDisplayed());
		Assert.assertTrue(wp.isWaiterCreatedAtDisplayed());
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	  
	@Test(enabled=true)
	public void validateValidUserSearch()
	{
		String ValidName="henry";
		wp.searchUsers(ValidName);
		String searchData=wp.searchTableUserName.getText();
		Assert.assertEquals(searchData, ValidName,"**both elements are not same***");
	}
	
	@Test(enabled=false)
	public void nullValueSearch()
	{
		String invalidName="sfsdg";
		wp.searchUsers(invalidName);
		String searchData=wp.searchTableUserName.getText();
		Assert.assertEquals(searchData, invalidName,"No such user found in table");
	}
	
	@Test(enabled=false)
	public void validationOfAddWatierFields()
	{
		try {
		Assert.assertTrue(wp.isNameInputFieldEnabled());
		Assert.assertTrue(wp.isPhoneInputFieldEnabled());
		Assert.assertTrue(wp.isEmailFieldEnabled());
		Assert.assertTrue(wp.isStoreFieldEnabled());
		Assert.assertTrue(wp.isSubmitButtonEnabled());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void addNewWaiter() throws Exception
	{
		try {
		wp.addWaiters();
		wp.typeWaiterName("manu");
		wp.typeEmail("chinmayi@gmail.com");
		wp.typePhone("985672944");
		wp.selectStoreID("Le_CAFE");
		wp.clickSubmitButton();
		wp.searchUsers("Chinmayi");
		String searchData=wp.searchTableUserName.getText();
		Assert.assertEquals(searchData, "Chinmayi","Waiter addition failed");
		
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@DataProvider (name="WaiterDataprov")
	public Object[][] getWaiterData()
	{
		Object[][] dataW=new Object[1][4];
		dataW[0][0]="Chinmayi";
		dataW[0][1]="985672944";
		dataW[0][2]="chinmayi@gmail.com";
		dataW[0][3]="Le_CAFE";
	
		return dataW;
	}
		
	
	
}
