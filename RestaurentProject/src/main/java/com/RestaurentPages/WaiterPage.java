package com.RestaurentPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ActionHelper.SendKeysActionHelper;
import com.ActionHelper.UtilityActionHelper;

public class WaiterPage {

	public WaiterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	WebDriver driver;
	SendKeysActionHelper send;
	UtilityActionHelper util;
	
	@FindBy (xpath="//th[contains(.,'Waiter Name')]")
	WebElement waiterName;
	
	@FindBy (xpath="//th[contains(.,'Phone')]")
	WebElement waiterPhone;
	@FindBy (xpath="//th[contains(.,'Email')]")
	WebElement waiterEmail;
	@FindBy (xpath="//th[contains(.,'Store')]")
	WebElement waiterStore;
	@FindBy (xpath="//th[contains(.,'Ceated At')]")
	WebElement waiterCreatedAt;
	@FindBy (xpath="Action")
	WebElement waiterAction;
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
	
	
	//Method to search users
	public void searchUsers(String name)
	{
		send=new SendKeysActionHelper();
		send.clearAndsendkeys(driver, searchBar, name);
		
	}
	//Method to add waiters
	
	public void addWaiters()
	{
		addWaiterButton.click();
	}

	public void typeWaiterName(String nameOfWaiter)
	{
		//send.clearAndsendkeys(driver, inWaiterName, nameOfWaiter);
		inWaiterName.sendKeys(nameOfWaiter);
		
	}
	public void typePhone(String phn)
	{
		//send.clearAndsendkeys(driver, inWaiterPhone, phn);
		inWaiterPhone.sendKeys(phn);
	}
	public void typeEmail(String mail)
	{
		//send.clearAndsendkeys(driver, inWaiterEmail, mail);
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
	  
	/**Methods for validation of elements**/
    
	public Boolean isWaiterNameDisplayed()
	{
		return waiterName.isDisplayed();
	}
	public Boolean isWaiterPhoneDisplayed()
	{
		return waiterPhone.isDisplayed();
	}
	public Boolean isWaiterEmailDisplayed()
	{
		return waiterEmail.isDisplayed();
	}
	public Boolean isWaiterStoreDisplayed()
	{
		return waiterStore.isDisplayed();
	}
	public Boolean isWaiterCreatedAtDisplayed()
	{
		return waiterCreatedAt.isDisplayed();
	}
	public Boolean isWaiterActionDisplayed()
	{
		return waiterAction.isDisplayed();
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
	


}
