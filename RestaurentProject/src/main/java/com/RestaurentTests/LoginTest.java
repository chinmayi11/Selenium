package com.RestaurentTests;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ActionHelper.UtilityActionHelper;
import com.RestaurentPages.LoginPage;

public class LoginTest extends BaseTest{
	
	LoginPage loginPageObject;
	public LoginTest()
	{
		super();
	}
	
	@Parameters("browserType")
	@BeforeTest
	public void setup(String browserType) {
		driver = launchBrowser(browserType);
		loginPageObject = new LoginPage(driver);

	}
/*	@Parameters("browserType")
	@BeforeGroups
	public void setupGroup(String browserType) {
		driver = launchBrowser(browserType);
		lp = new LoginPage(driver);

	}*/
	@Test(groups={"sanity"})
	public void validLogin() throws IOException
	{
		loginPageObject=new LoginPage(driver);
		loginPageObject.getUsernameAndPassword();
		Assert.assertTrue(loginPageObject.isUsernameFieldDisplayed());
		loginPageObject.typeUsername();
		Assert.assertTrue(loginPageObject.isPasswordFieldDisplayed());
		loginPageObject.typePassword();
		Assert.assertTrue(loginPageObject.isLoginButtonDisplayed());
		
		loginPageObject.clickLoginButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
@AfterMethod
	public void quitBrowser()
	{
		driver.quit();
	
}
}