package com.ActionHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.DataHandlers.PropertyDataHandler;

public class WebActionHelper {
	public void launchUrl(WebDriver driver, String browserName) throws IOException
	{
		try
		{
			
		 PropertyDataHandler prop=new PropertyDataHandler();
		 Properties pro= prop.readPropertiesFile("config.properties");
		 String url=pro.getProperty("url");
		 driver.get(url);
		 
		
	}
		catch(Exception e)
		{
			System.out.println("Exception occured "+e.getMessage());
		}

	}
	
	/**
	 * method to get the title of current site
	 */
	
	public String getPageTitle(WebDriver driver)
	{
		String title="";
		try
		{
			title=driver.getTitle();
		}
		catch (Exception e) {
			
			System.out.println("Exceptiom occured" +e);
		
		}
		return title;
	}
	
	/**
	 * method to get the URL of current site
	 */
	
	public String getPageCurrentUrl(WebDriver driver ) {
		
		 String PageCurrentUrl ="";
		 
		try {
			PageCurrentUrl = driver.getCurrentUrl() ;
			}
		
			catch (Exception e) {
				
				System.out.println("Exceptiom occured" +e);
			
			}
		return PageCurrentUrl;
	}
	
	/**
	 * method to navigate backward
	 */
	
	public void navigateBack(WebDriver driver)
	{
		driver.navigate().back();
		System.out.println("**********Page navigated backwards successfully*******");
	}
	
	/**
	 * method to navigate forward
	 */
	
	public void navigateForward(WebDriver driver)
	{
		driver.navigate().forward();
		System.out.println("**********Page navigated forwards successfully*******");
	}
	
	/**
	 * method to refresh
	 */
	
	public void navigateRefresh(WebDriver driver ) {
		
		try {
			
			driver.navigate().refresh(); 
		}
		
			catch (Exception e) {
				
				System.out.println("Exceptiom occured" +e);
			}
	}
	
	/**
	 * method to close current page
	 */
	
	public void navigateclose(WebDriver driver)
	{
		try {
			driver.close();;
		}
		catch (Exception e) {
			
			System.out.println("Exceptiom occured" +e);
			
		}
		
	}
	
	/**
	 * method to close entire opened browser window
	 */
	
	public void navigateQuit(WebDriver driver)
	{
		try {
			driver.quit();
		}
		catch (Exception e) {
			
			System.out.println("Exceptiom occured" +e);
			
		}
		
	}
	
	/**
	 * method to get the page source of the current page
	 */
	public String getSitePageSource(WebDriver driver) {
		String pageSource = "";
		try {
			pageSource = driver.getPageSource();
		}catch(Exception e) {
			System.out.println("getSitePageSource (WebActionHelper) : "+e.getMessage());
		}
		return pageSource;
	}
	/**
	 * method to accept alert box
	 */
	public void acceptAlert(WebDriver driver) {
		try {
			Alert alertBox = driver.switchTo().alert();
			alertBox.accept();
		}catch(Exception e) {
			System.out.println("acceptAlert (WebActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to dismiss alert box
	 */
	public void dismissAlert(WebDriver driver) {
		try {
			Alert alertBox = driver.switchTo().alert();
			alertBox.dismiss();
		}catch(Exception e) {
			System.out.println("dismissAlert (WebActionHelper) : "+e.getMessage());
		}
	}
	/*
	 * method to get the content of alert box
	 */
	public String getAlertBoxContent(WebDriver driver) {
		String content = "";
		try {
			Alert alertBox = driver.switchTo().alert();
			content = alertBox.getText();
		}catch(Exception e) {
			System.out.println("getAlertBoxContent (WebActionHelper) : "+e);
		}
		return content;
	}
	/**
	 * method to switch to frame
	 * @throws Exception 
	 */
	public void switchToFrame(WebDriver driver, int index) throws Exception {
		try {
			driver.switchTo().frame(index);
		}catch(Exception e) {
			throw new Exception  ("switchToFrame(WebActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to switch to parent frame
	 * @throws Exception 
	 */
	public void switchToParentFrame(WebDriver driver) throws Exception {
		try {
			driver.switchTo().parentFrame();
		}catch(Exception e) {
			throw new Exception("switchToParentFrame(WebActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to count the total no of frames
	 * @throws Exception 
	 */
	public int totalFrameCount(WebDriver driver) throws Exception {
		try {
			List <WebElement> frames = driver.findElements(By.tagName("iframe"));
			return frames.size();
		}catch(Exception e) {
			throw new Exception("totalFrameCount(WebActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * print the total number of browser instances
	 * @throws Exception 
	 */
	public int countTotalWindows(WebDriver driver) throws Exception {
		try {
			Set <String> windows = driver.getWindowHandles();
			return windows.size();
		}catch (Exception e) {
			throw new Exception("countTotalWindows(WebActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to switch to a new browser instance and return parent browser
	 * @throws Exception 
	 */
	public String switchToNewelyOpenedWindowAndReturnParentWindow(WebDriver driver) throws Exception {
		try {
			String parentWindow = driver.getWindowHandle();
			ArrayList <String> windows = new ArrayList();
			windows.addAll(driver.getWindowHandles());
			int count = windows.size();
			String newWindow = windows.get(count-1);
			driver.switchTo().window(newWindow);
			return parentWindow;
		}catch (Exception e) {
			throw new Exception("switchToNewelyOpenedWindow(WebActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to switch to parentWindow
	 * @throws Exception 
	 */
	public void switchToParentWindow(WebDriver driver, String window) throws Exception {
		try {
			driver.switchTo().window(window);
		}catch(Exception e) {
			throw new Exception("switchToParentWindow(WebActionHelper) : "+e.getMessage());
		}
	}

}
