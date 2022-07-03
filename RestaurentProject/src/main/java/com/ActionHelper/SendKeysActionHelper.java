package com.ActionHelper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendKeysActionHelper {

	public void sendkeys(WebDriver driver,WebElement element, String inputData)
	{
		try
		{
		 element.sendKeys(inputData);
		}
		catch(Exception e)
		{
			System.out.println("****************************************");
			System.out.println("Exception occured "+e.getMessage());
		}
	}
	public void clearAndsendkeys(WebDriver driver , WebElement element, String InputValue)
	{
		try {
			element.clear();
		element.sendKeys(InputValue);
		}
		catch (Exception e) {
			
			System.out.println("Exception occured " +e);
		}
	}
	
	public void sendKeysJsById(WebDriver driver, String elementId, String text) throws Exception {
		try
		{ 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('"+elementId+"').value='"+text+"';");
		}
		catch(Exception e) 
		{
			System.out.println("Exception occured "+e.getMessage());
			
		}
	}

}
