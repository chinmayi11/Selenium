package com.ActionHelper;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class UtilityActionHelper {
	Actions act;
	public void  mouseDragDropUsingXYLocation(WebDriver driver , WebElement source ,int a , int b  )
	{
		try {
			act.moveToElement(source).clickAndHold().moveByOffset( a, b).build().perform();
		}
		catch (Exception e) {

			System.out.println("Exceptiom occured" +e);
			// TODO: handle exception
		}
	}
	public void  mouseDragDrop(WebDriver driver, WebElement source, WebElement target)
	{
		try {
			act.moveToElement(source).clickAndHold().moveToElement(target).build().perform();
		}
		catch (Exception e) {

			System.out.println("Exceptiom occured" +e);
			// TODO: handle exception
		}
	}
	/**
	 * method to return table row count
	 */
	public int getTableRowCount(List <WebElement> element) throws Exception {
		try {
			return element.size();
		}catch(Exception e) {
			throw new Exception("getTableRowCount (UtilityActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to return table column count
	 */
	public int getTableColumnCount(WebDriver driver, List <WebElement> element) throws Exception {
		try {
			return element.size();
		}catch(Exception e) {
			throw new Exception("getTableColumnCount (UtilityActionHelper) : "+e.getMessage());
		}
	}
	
	/**
	 * method to select drop down by visible text
	 * @throws Exception 
	 */
	public void selectDropDownByVisibleText(WebElement element, String visibleText) throws Exception {
		try {
			Select dropDown = new Select(element);
			dropDown.selectByVisibleText(visibleText);
		}catch(Exception e) {
			throw new Exception("selectDropDownByVisibleText (UtilityActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to select drop down by index
	 * @throws Exception 
	 */
	public void selectDropDownByIndex(WebElement element, int index) throws Exception {
		try{
			Select dropDown = new Select(element);
			dropDown.selectByIndex(index);
		}catch (Exception e) {
			throw new Exception("selectDropDownByIndex (UtilityActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to select drop down by value
	 * @throws Exception 
	 */
	public void selectDropDownByValue(WebElement element, String value) throws Exception {
		try{
			Select dropDown = new Select(element);
			dropDown.selectByValue(value);
		}catch (Exception e) {
			throw new Exception("selectDropDownByValue (UtilityActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to take screenshot
	 * @throws Exception 
	 */
	public void capturePageScreenshot(WebDriver driver) throws Exception {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("PageScreenshot.png"));
		}catch (Exception e) {
			throw new Exception("capturePageScreenshot (UtilityActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to drag and drop
	 * @throws Exception 
	 */
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) throws Exception {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();
		}catch (Exception e) {
			throw new Exception("dragAndDrop (UtilityActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * method to drag to X and Y points
	 * @throws Exception 
	 */
	public void dragToXandY(WebDriver driver,WebElement source, int x, int y) throws Exception {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(source).clickAndHold().moveByOffset(x, y).release().build().perform();
		}catch (Exception e) {
			throw new Exception("dragToXandY (UtilityActionHelper) : "+e.getMessage());
		}
	}
	
	public String getColumnContent(WebDriver driver, String element)
	{
		return driver.findElement(By.xpath(element)).getText();
	}


}
