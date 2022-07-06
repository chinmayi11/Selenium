package com.RestaurentPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionHelper.ValidationActionHelpers;

public class CustomerPage {
	public CustomerPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	WebDriver driver;
	ValidationActionHelpers validate;
	
	@FindBy (xpath="//table[@id='Table']//th[contains(.,'Customer Name')]")
	WebElement tableHeaderCustomerName;
	@FindBy (xpath="//table[@id='Table']//th[contains(.,'Phone')]")
	WebElement tableHeaderPhone;
	@FindBy (xpath="//table[@id='Table']//th[contains(.,'Email')]")
	WebElement tableHeaderEmail;
	@FindBy (xpath="//table[@id='Table']//th[contains(.,'Discount')]")
	WebElement tableHeaderDiscount;
	@FindBy (xpath="//table[@id='Table']//th[contains(.,'Ceated At')]")
	WebElement tableHeaderCreatedAt;
	@FindBy (xpath="//table[@id='Table']//th[contains(.,'Action')]")
	WebElement tableHeaderAction;
	@FindBy (xpath="//button[contains(.,'Add Customer')]")
	WebElement addCustomersButton;
	@FindBy (xpath="//input[@type='search']")
	WebElement searchBar;
	@FindBy (xpath="//label[contains(.,'Show ')]")
	WebElement showLabel;
	
	public Boolean isTableHeaderCustomerNameDisplayed() throws Exception
	{
		validate = new ValidationActionHelpers();
		return validate.isElementVisible(driver, tableHeaderCustomerName);
	}
	public Boolean isTableHeaderPhoneDisplayed() throws Exception
	{
		return validate.isElementVisible(driver, tableHeaderPhone);
	}
	public Boolean isTableHeaderEmailDisplayed() throws Exception
	{
		return validate.isElementVisible(driver, tableHeaderEmail);
	}
	public Boolean isTableHeaderDiscountDisplayed() throws Exception
	{
		return validate.isElementVisible(driver, tableHeaderDiscount);
	}
	public Boolean isTableHeaderCreatedAtDisplayed() throws Exception
	{
		return validate.isElementVisible(driver, tableHeaderCreatedAt);
	}
	public Boolean istableHeaderActionDisplayed() throws Exception
	{
		return validate.isElementVisible(driver, tableHeaderAction);
	}
	
	

}
