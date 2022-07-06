package com.ActionHelper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class clickActionHelper {
	
	public void click(WebDriver driver, WebElement element)
	{
		try
		{
			element.click();
		}
		catch(Exception e)
		{
			System.out.println("******************************");
			System.out.println("failed to click "+e.getMessage());
		}
	}
	public void clickUsingJS(WebDriver driver, WebElement element)
	{
		try
		{
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",element);
			System.out.println("******************************");
			System.out.println("Successfully clicked on "+element.getText());
		}
		catch(Exception e)
		{
			System.out.println("******************************");
			System.out.println("failed to clicked on "+element.getText());

			
		}
	}
	public void doubleClick(WebDriver driver, WebElement element)
	{
		try
		{
			Actions act=new Actions(driver);
			act.doubleClick(element).build().perform();
			System.out.println("******************************");
			System.out.println("Successfully double clicked on "+element.getText());
		}
		catch(Exception e)
		{
			System.out.println("******************************");
			System.out.println("failed to double click on "+element.getText());
		}
	}
	
	public void rightClick(WebDriver driver, WebElement element)
	{
		try
		{
			Actions act=new Actions(driver);
			act.contextClick(element).build().perform();
			System.out.println("******************************");
			System.out.println("Successfully right clicked on "+element.getText());
		}
		catch(Exception e)
		{
			System.out.println("******************************");
			System.out.println("failed to right click on "+element.getText());
		}
	}
	
	public void dragAndDrop(WebDriver driver, WebElement elementSource,WebElement elementDestination)
	{
		try
		{
			Actions act=new Actions(driver);
			act.dragAndDrop(elementSource, elementDestination).build().perform();
			System.out.println("******************************");
			System.out.println("Successfully dragged and droped "+elementSource.getText());
		}
		catch(Exception e)
		{
			System.out.println("******************************");
			System.out.println("failed to drag and drop "+elementSource.getText());
		}
	}
	public void mouseClick(WebDriver driver , WebElement dragableButton)
	{
		Actions act = new Actions(driver);
		try {
			act.moveToElement(dragableButton).click().build().perform();
			System.out.println("******************************");
			System.out.println("successfully clicked on "+dragableButton.getText());
		}
		catch (Exception e) {
			System.out.println("******************************");
			System.out.println("failed to clicked on "+dragableButton.getText());

		}
	}
	
	public void clickOnXandY(WebDriver driver, int xOffset, int yOffset) 
	{
		try {
			Actions act = new Actions(driver);
			act.moveByOffset(xOffset, yOffset).click().build().perform();
		}catch (Exception e) {
			System.out.println("******************************");
			System.out.println("failed to clicked ");

		}
	}


}
