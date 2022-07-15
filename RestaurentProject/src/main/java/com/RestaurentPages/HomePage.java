package com.RestaurentPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionHelper.ValidationActionHelpers;
import com.ActionHelper.clickActionHelper;

public class HomePage {
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	WebDriver driver;
	ValidationActionHelpers validation;
	clickActionHelper clicker;
	
	@FindBy (xpath="//span[contains(.,'admin Doe') ]")
	WebElement adminName;
	@FindBy (xpath="//img[@class='img-circle topbar-userpic hidden-xs']")
	WebElement adminPhoto;
	@FindBy (xpath="//a[@title='Logout']")
	WebElement logout;
	@FindBy (xpath="//span[contains(.,'POS')]")
	WebElement pos;
	@FindBy (xpath="//a[@href='https://qalegend.com/restaurant/products']")
	WebElement product;
	@FindBy (xpath="//a[@href='https://qalegend.com/restaurant/stores']")
	WebElement store;
	@FindBy (xpath="//span[contains(.,'People')]")
	WebElement people;
	@FindBy (xpath="//span[contains(.,'Sales')]")
	WebElement sales;
	@FindBy (xpath="//a[@href='https://qalegend.com/restaurant/expences']")
	WebElement expenses;
	@FindBy (xpath="//span[contains(.,'Setting')]")
	WebElement settings;
	@FindBy (xpath="//span[contains(.,'Reports')]")
	WebElement reports;
	@FindBy (xpath="//span[contains(.,'Waiters')]")
	WebElement waiters;
	@FindBy (xpath="//span[contains(.,'Customers')]")
	WebElement customers;
	@FindBy (xpath="//span[contains(.,'Suppliers')]")
	WebElement suppliers;
	@FindBy (xpath="//span[contains(.,'Customers')]")
	 WebElement navigateToCustomerPage;
	@FindBy (xpath="//h1[contains(.,' Choose a store')]")
	WebElement chooseStoreHeader;
	@FindBy (xpath="//ul[@id='storeline']//div[@class='info']//span[text()='Le_CAFE'][1]")
	WebElement storeTitle;
	
	
	public void clickPeople()
	{
		clicker=new clickActionHelper();
		clicker.click(driver, people);
	}
	
	public void selectWaiters()
	{
		people.click();
		waiters.click();
		
	}
	public void selectCustomers()
	{
		people.click();
		customers.click();
	}
	
	public void selectSuppliers()
	{
		people.click();
		suppliers.click();
	}
	
	public void selectSales()
	{
		sales.click();
	}
	
	public Boolean  isWaitersDisplayed() throws Exception
	{
		validation =new ValidationActionHelpers();
		return validation.isElementVisible(driver, waiters);
	}
	public Boolean  isCustomersDisplayed() throws Exception
	{
		validation =new ValidationActionHelpers();
		return validation.isElementVisible(driver, customers);
	}
	public Boolean  isSuppliersDisplayed() throws Exception
	{
		validation =new ValidationActionHelpers();
		return validation.isElementVisible(driver, suppliers);
	}
	
	public Boolean isadminNameDisplayed() throws Exception
	{
		validation =new ValidationActionHelpers();
		return validation.isElementVisible(driver, adminName); 
	}
	public Boolean isadminPhotoDisplayed() throws Exception
	{
		validation =new ValidationActionHelpers();
		return validation.isElementVisible(driver, adminPhoto);
	} 
	public Boolean isPosDisplayed() throws Exception
	{
		validation =new ValidationActionHelpers();
		return validation.isElementVisible(driver, pos);
	} 
	public Boolean isProductDisplayed() throws Exception
	{
		validation =new ValidationActionHelpers();
		return validation.isElementVisible(driver, product);
	}
	public Boolean isStoreDisplayed() throws Exception
	{
		validation =new ValidationActionHelpers();
		return validation.isElementVisible(driver, store);
	} 
	public Boolean isPeopleDisplayed() throws Exception
	{
		validation =new ValidationActionHelpers();
		return validation.isElementVisible(driver, people);
	} 
	public Boolean isSaleDisplayed() throws Exception
	{
		validation =new ValidationActionHelpers();
		return validation.isElementVisible(driver, sales);
	} 
	public Boolean isExpenseDisplayed() throws Exception
	{
		validation =new ValidationActionHelpers();
		return validation.isElementVisible(driver, expenses);
	} 
	public Boolean isSettingsDisplayed() throws Exception
	{
		validation =new ValidationActionHelpers();
		return validation.isElementVisible(driver, settings);
	} 
	public Boolean isReportsDisplayed() throws Exception
	{
		validation =new ValidationActionHelpers();
		return validation.isElementVisible(driver, reports);
	} 
	public Boolean isChooseStoreHeaderDisplayed() throws Exception
	{
		validation =new ValidationActionHelpers();
		return validation.isElementVisible(driver, chooseStoreHeader);
	}
	public Boolean isStoreTitleDisplayed() throws Exception
	{
		validation =new ValidationActionHelpers();
		return validation.isElementVisible(driver, storeTitle);
	}
	
	public WaiterPage waiterLogin()
	{
		selectWaiters();
		return new WaiterPage(driver);
	}
	public SalesPage salesLogin()
	{
		selectSales();
		return new SalesPage(driver);
	}
	public CustomerPage selectCustomerPage()
    {
    	navigateToCustomerPage.click();
    	return new CustomerPage(driver);
    }


	
}
