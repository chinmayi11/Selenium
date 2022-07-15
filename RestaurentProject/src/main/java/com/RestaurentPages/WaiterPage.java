package com.RestaurentPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionHelper.SendKeysActionHelper;
import com.ActionHelper.UtilityActionHelper;
import com.ActionHelper.clickActionHelper;

public class WaiterPage {

	public WaiterPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	WebDriver driver;
	SendKeysActionHelper send;
	UtilityActionHelper util;
	clickActionHelper clicker;
	
	@FindBy (xpath="//th[contains(.,'Waiter Name')]")
	WebElement waiterTableName;
	
	@FindBy (xpath="//th[contains(.,'Phone')]")
	WebElement waiterTablePhone;
	@FindBy (xpath="//th[contains(.,'Email')]")
	WebElement waiterTableEmail;
	@FindBy (xpath="//th[contains(.,'Store')]")
	WebElement waiterTableStore;
	@FindBy (xpath="//th[contains(.,'Ceated At')]")
	WebElement waiterTableCreatedAt;
	@FindBy (xpath="//th[contains(.,'Action')]")
	WebElement waiterTableAction;
	@FindBy (xpath="//button[contains(.,'Add Waiter')]")
	WebElement addWaiterButton;
	@FindBy (xpath="//input[@type='search']")
	WebElement searchBar;
	@FindBy (xpath="//select[@name='Table_length']")
	WebElement showEntriesDropdown;
	public @FindBy (xpath="//table[@id='Table']/tbody//tr[1]//td[1]")
	WebElement searchTableUserName;
	@FindBy (xpath="//input[@name='name']")
	WebElement inWaiterName;
	@FindBy (xpath="//input[@name='phone']")
	WebElement inWaiterPhone;
	@FindBy (xpath="//input[@name='email']")
	WebElement inWaiterEmail;
	@FindBy (xpath="//select[@id='WaiterStore']")
	WebElement dropdownWaiterStore;
	@FindBy (xpath="//button[contains(.,'Submit')]")
	WebElement submitButton;
	@FindBy (xpath="//div[@id='Table_info']")
	WebElement show;
	@FindBy (xpath="(//i[@class='fa fa-times'])[1]")
	WebElement deleteButton;
	@FindBy (xpath="//a[contains(.,'Yes, delete it!')]")
	WebElement deleteConfirmationButton;
	@FindBy (xpath="//a[@class='btn btn-default']//i[@class='fa fa-pencil'][1]")
	WebElement editButton;
	@FindBy (xpath="//span[contains(.,'Customers')]")
	 WebElement navigateToCustomerPage;
	
	//Method to search users
	public void searchUsers(String name) throws Exception
	{
		
		send=new SendKeysActionHelper();
		send.clearAndsendkeys(driver, searchBar, name);
		
		
	}
	//Method to add waiters
	
	public void clickonAddWaiters()
	{
		//addWaiterButton.click();
		clicker = new clickActionHelper();
		clicker.click(driver, addWaiterButton);
	}

	public void typeWaiterName(String nameOfWaiter)
	{
	      inWaiterName.clear();
		inWaiterName.sendKeys(nameOfWaiter);
		
	}
	public void typePhone(String phn)
	{
		inWaiterPhone.clear();
		inWaiterPhone.sendKeys(phn);
	}
	public void typeEmail(String mail)
	{
		inWaiterEmail.clear();
	inWaiterEmail.sendKeys(mail);
		
	}
    public void selectStoreID(String storeId) throws Exception
    {
		  util=new UtilityActionHelper();
		  util.selectDropDownByVisibleText(dropdownWaiterStore, storeId);
    }
    public void clickSubmitButton()
    {
 
    	submitButton.click();
    	
    }
	  
    /** Methods for delete**/
    
    public void clickDeleteButton()
    {
    	deleteButton.click();
    	deleteConfirmationButton.click();
    	
    }
    
    /**Method for edit**/
    
    public void clickEditButton()
    {
    	editButton.click();
    }
    
   
	/**Methods for validation of elements**/
    
	public Boolean isWaiterNameDisplayed()
	{
		return waiterTableName.isDisplayed();
	}
	public Boolean isWaiterPhoneDisplayed()
	{
		return waiterTablePhone.isDisplayed();
	}
	public Boolean isWaiterEmailDisplayed()
	{
		return waiterTableEmail.isDisplayed();
	}
	public Boolean isWaiterStoreDisplayed()
	{
		return waiterTableStore.isDisplayed();
	}
	public Boolean isWaiterCreatedAtDisplayed()
	{
		return waiterTableCreatedAt.isDisplayed();
	}
	public Boolean isWaiterActionDisplayed()
	{
		return waiterTableAction.isDisplayed();
	}
	public Boolean isAddWaiterButtonDisplayed()
	{
		return addWaiterButton.isDisplayed();
	}
	public Boolean isSearchBarDisplayed()
	{
		return searchBar.isDisplayed();
	}
	public Boolean isShowEntriesDropdown()
	{
		return showEntriesDropdown.isDisplayed();
	}
	public Boolean isNameInputFieldEnabled()
	{
		return inWaiterName.isEnabled();
	}
	public Boolean isPhoneInputFieldEnabled()
	{
		return inWaiterPhone.isEnabled();
	}
	public Boolean isEmailFieldEnabled()
	{
		return inWaiterEmail.isEnabled();
	}
	public Boolean isStoreFieldEnabled()
	{
		return dropdownWaiterStore.isEnabled();
	}
	public Boolean isSubmitButtonEnabled()
	{
		return submitButton.isEnabled();
	}
	
	
	public CustomerPage selectCustomerPage()
    {
    	navigateToCustomerPage.click();
    	return new CustomerPage(driver);
    }
	


}
