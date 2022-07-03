package com.RestaurentTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.RestaurentPages.LoginPage;

public class LoginTest extends BaseTest{
	
	LoginPage lp;
	public LoginTest()
	{
		super();
	}
	
	
	@BeforeMethod
	@Parameters("browserType")
	public void setup(String browserType) {
		driver = launchBrowser(browserType);
		lp = new LoginPage(driver);

	}
	@Test
	public void validLogin() throws IOException
	{
		lp=new LoginPage(driver);
		lp.getUsernameAndPassword();
		Assert.assertTrue(lp.isUsernameFieldDisplayed());
		lp.typeUsername();
		Assert.assertTrue(lp.isPasswordFieldDisplayed());
		lp.typePassword();
		Assert.assertTrue(lp.isLoginButtonDisplayed());
		lp.clickLoginButton();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
@AfterMethod
	public void quitBrowser()
	{
		driver.quit();
	
}
}