package com.RestaurentTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

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
	
	public WebDriver launchEdgeBrowser()
	{
		try {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\chinm\\OneDrive\\Desktop\\driver\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		WebActionHelper wb=new WebActionHelper();
		wb.launchUrl(driver,"edge");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		case "edge": 
			launchEdgeBrowser();
			break;

		default:
			System.out.println(AutomationConstants.CHECKBROWSER_MESSAGE);
			break;
		}
		return driver;
			
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	

}
