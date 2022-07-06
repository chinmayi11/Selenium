package com.RestaurentTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ActionHelper.WebActionHelper;
import com.Constants.AutomationConstants;

public class BaseTest {
	
	public static WebDriver driver;
	
	public WebDriver launchChromeBrowser()
	{
		try {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinm\\OneDrive\\Desktop\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebActionHelper wb=new WebActionHelper();
		wb.launchUrl(driver,"chrome");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return driver;
		
	}
	
	public WebDriver launchFirefoxBrowser()
	{
		try {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinm\\OneDrive\\Desktop\\driver\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		WebActionHelper wb=new WebActionHelper();
		wb.launchUrl(driver,"chrome");
		if(driver==null)
		{
			System.out.println("***************launch browser");
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return driver;
		
	}
	
	
	public WebDriver launchBrowser(String browserName)
	{
		switch(browserName)
		{
		case "chrome" :
			launchChromeBrowser();
			break;
		case "firefox":
			launchFirefoxBrowser();
			break;

		default:
			System.out.println(AutomationConstants.CHECKBROWSER_MESSAGE);
			break;
		}
		return driver;
			
	}
	
	

}
