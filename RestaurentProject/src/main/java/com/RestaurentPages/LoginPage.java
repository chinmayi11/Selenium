package com.RestaurentPages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ActionHelper.SendKeysActionHelper;
import com.DataHandlers.PropertyDataHandler;



public class LoginPage {
	
	SendKeysActionHelper inputData;
	PropertyDataHandler propData;
	Properties pro;
	String uname;
	String pswd;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	WebDriver driver;
	@FindBy (xpath="//input[@placeholder='Username']")
	WebElement username;
	@FindBy (xpath="//input[@placeholder='Password']")
	WebElement password;
	@FindBy (xpath="//input[@name='submit']")
	WebElement loginButton;
	
	public void getUsernameAndPassword() throws IOException
	{
		propData=new 	PropertyDataHandler	();
		pro= propData.readPropertiesFile("config.properties");
		uname=pro.getProperty("username");
		pswd=pro.getProperty("password");
	}
	public void typeUsername() throws IOException
	{
		
		inputData=new SendKeysActionHelper();
		inputData.clearAndsendkeys(driver, username, uname);
	}
	public void typePassword() throws IOException
	{
		inputData=new SendKeysActionHelper();
		inputData.clearAndsendkeys(driver, password, pswd);
		
	}
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public Boolean isUsernameFieldDisplayed()
	{
		return username.isDisplayed();
	}
	public Boolean isPasswordFieldDisplayed()
	{
		return password.isDisplayed();
	}
	public Boolean isLoginButtonDisplayed()
	{
		return loginButton.isDisplayed();
	}
	
	public HomePage login() throws IOException
	{
		getUsernameAndPassword();
		typeUsername();
		typePassword();
		clickLoginButton();
		return new HomePage(driver);
	}

}
