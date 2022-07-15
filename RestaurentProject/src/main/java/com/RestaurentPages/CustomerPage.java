package com.RestaurentPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionHelper.SendKeysActionHelper;
import com.ActionHelper.ValidationActionHelpers;
import com.ActionHelper.clickActionHelper;

public class CustomerPage {
	public CustomerPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	WebDriver driver;
	ValidationActionHelpers validate;
	SendKeysActionHelper send;
	clickActionHelper clicker;

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
	@FindBy (xpath="//input[@name='name']")
	WebElement inputCustomerNameField;
	@FindBy (xpath="//input[@name='phone']")
	WebElement inputCustomerPhoneField;
	@FindBy (xpath="//input[@name='email']")
	WebElement inputCustomerEmailField;
	@FindBy (xpath="//input[@name='discount']")
	WebElement inputCustomerDiscountField;
	@FindBy (xpath="//button[contains(.,'Submit')]")
	WebElement submitButton;
	@FindBy (xpath="//button[contains(.,'Close')]")
	WebElement closeButton;
	@FindBy (xpath="//a[@class=\"btn btn-default\"][1]")
	WebElement deleteButton;
	@FindBy (xpath="//a[contains(.,'Yes, delete it!')]")
	WebElement deleteConfirmation;
	@FindBy (xpath="//a[@class='btn btn-default']//i[@class='fa fa-pencil'][1]")
	WebElement editButton;
	@FindBy (xpath="//a[contains(.,'Back')]")
	WebElement backButton;
	
	public @FindBy (xpath="//table[@id='Table']//tbody//tr//td[1]")
	WebElement searchTableCustomerName;
	
	
	
	public void searchCustomer(String name) throws Exception
	{
		
		send=new SendKeysActionHelper();
		send.clearAndsendkeys(driver, searchBar, name);
		
	}
	public void clickEditButton()
	{
		clicker=new clickActionHelper();
		clicker.click(driver, editButton);
	}
	public void clickBackButton()
	{
		clicker.click(driver, backButton);
	}
	
	public void clickDeleteButton()
	{
		deleteButton.click();
		deleteConfirmation.click();
	}
	
	public void typeCustomerName(String customerName)
	{
		
		inputCustomerNameField.clear();
		inputCustomerNameField.sendKeys(customerName);
	}
	public void typeCustomerPhone(String customerPhone)
	{
		
		inputCustomerPhoneField.clear();
		inputCustomerPhoneField.sendKeys(customerPhone);
	}
	public void typeCustomerEmail(String CustomerEmail)
	{
		
		inputCustomerEmailField.clear();
		inputCustomerEmailField.sendKeys(CustomerEmail);
	}
	public void typeCustomerDiscount(String customerDiscount)
	{
		
		inputCustomerDiscountField.clear();
		inputCustomerDiscountField.sendKeys(customerDiscount);
	}
	public void clickOnAddCustomerButton()
	{
		addCustomersButton.click();
	}
	public void clickonSubmitButton()
	{
		submitButton.click();
	}
	public void clickOnCloseButton()
	{
		closeButton.click();
	}
	
	/**Methods for validation**/
	
	public Boolean isSearchBarEnabled() 
	{
		return searchBar.isEnabled();
	}
	
	public Boolean isShowNumberOfEntriesFieldDisplayed() 
	{
		return showLabel.isDisplayed();
		
	}
	
	public Boolean isAddCustomerButtonEnabled() 
	{
		return addCustomersButton.isEnabled();
	}
	public Boolean isTableHeaderCustomerNameDisplayed() 
	{
		return tableHeaderCustomerName.isDisplayed();
	}
	public Boolean isTableHeaderPhoneDisplayed() 
	{
		return tableHeaderPhone.isDisplayed();
	}
	public Boolean isTableHeaderEmailDisplayed() 
	{
		return tableHeaderEmail.isDisplayed();
	}
	public Boolean isTableHeaderDiscountDisplayed()
	{
		return tableHeaderDiscount.isDisplayed();
	}
	public Boolean isTableHeaderCreatedAtDisplayed() 
	{
		return tableHeaderCreatedAt.isDisplayed();
	}
	public Boolean istableHeaderActionDisplayed() 
	{
		return tableHeaderAction.isDisplayed();
	}
	public Boolean isCustomerNameFieldEnabled()
	{
		return inputCustomerNameField.isEnabled();
	}
	public Boolean isCustomerPhoneFieldEnabled()
	{
		return inputCustomerPhoneField.isEnabled();
	}
	public Boolean isCustomerEmailFieldEnabled()
	{
		return inputCustomerEmailField.isEnabled();
	}
	public Boolean isCustomerDiscountFieldEnabled()
	{
		return inputCustomerDiscountField.isEnabled();
	}
	public Boolean isCustomerSubmitButtonEnabled()
	{
		return submitButton.isEnabled();
	}
	public Boolean isCloseButtonEnabled()
	{
		return closeButton.isEnabled();
	}
	public Boolean isEditButtonEnabled()
	{
		return editButton.isEnabled();
	}
	public Boolean isBackButtonEnabled()
	{
		return backButton.isEnabled();
	}

}
