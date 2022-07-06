package com.RestaurentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionHelper.UtilityActionHelper;
import com.ActionHelper.ValidationActionHelpers;
import com.ActionHelper.clickActionHelper;

public class SalesPage {
	WebDriver driver;
	public SalesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	ValidationActionHelpers validation;
	clickActionHelper clicker;
	UtilityActionHelper util;
	
	@FindBy (xpath="//h3[contains(.,'Sales')]")
	WebElement salesHeader;
	@FindBy (xpath="//label[contains(.,'Search')]")
	WebElement searchLabel;
	@FindBy (xpath="//table[@id='table']//tr//th[1]")
	WebElement tableHeaderNumber;
	@FindBy (xpath="//table[@id='table']//tr//th[2]")
	WebElement tableHeaderCustomer;
	@FindBy (xpath="//table[@id='table']//tr//th[3]")
	WebElement tableHeaderTax;
	@FindBy (xpath="//table[@id='table']//tr//th[4]")
	WebElement tableHeaderDiscount;
	@FindBy (xpath="//table[@id='table']//tr//th[5]")
	WebElement tableHeaderTotal;
	@FindBy (xpath="//table[@id='table']//tr//th[6]")
	WebElement tableHeaderCreatedBy;
	@FindBy (xpath="//table[@id='table']//tr//th[7]")
	WebElement tableHeaderTotalItems;
	@FindBy (xpath="//table[@id='table']//tr//th[8]")
	WebElement tableHeaderStatus;
	@FindBy (xpath="//table[@id='table']//tr//th[9]")
	WebElement tableHeaderAction;
	
	@FindBy (xpath="//a[contains(.,'Action')]")
			WebElement saleActionButton;
	
	@FindBy (xpath="//a[contains(.,'Edit')]")
	WebElement saleEdit;
	@FindBy (xpath="//a[contains(.,' Payements')]")
	WebElement payment;
	@FindBy (xpath="//a[contains(.,' invoice')]")
	WebElement invoice;
	@FindBy (xpath="//a[contains(.,' Receipt')]")
	WebElement receipt;
	@FindBy (xpath="//button[contains(.,'Submit') and @class='btn btn-add hiddenpr']")
	WebElement SaleEditSubmitButton;
	
	@FindBy (id="customerSelect")
			WebElement changeClientDropdown;
	@FindBy (id="changeStatus")
			WebElement changeStatusDropdown;
	
	
	//Method to click on Action
	
	public void clickActionButton()
	{
		clicker=new clickActionHelper();
		clicker.click(driver, saleActionButton);
		
	}
	public void clickSalesEdit()
	{
		clicker.click(driver, saleEdit);
	}

	public void selectClient(String clientName) throws Exception
	{
		util=new UtilityActionHelper();
		util.selectDropDownByVisibleText(changeClientDropdown, clientName);
	}
	public void selectStatus(String paymentStatus) throws Exception
	{
		util.selectDropDownByVisibleText(changeStatusDropdown, paymentStatus);
	}
	public void clickSaleEditSubmitButton()
	{
		clicker.click(driver, SaleEditSubmitButton);
	}
	//methods to check validation of elements//
	
	public Boolean isChangeClientDropDownEnabled() throws Exception
	{
		return validation.isElementEnabled(driver, changeClientDropdown);
	}
	public Boolean isChangeStatusDropDownEnabled() throws Exception
	{
		return validation.isElementEnabled(driver, changeStatusDropdown);
	}
	public Boolean isEditSubmitButtonEnabled() throws Exception
	{
		return validation.isElementEnabled(driver, SaleEditSubmitButton);
	}
	public Boolean isSalesHeaderDisplayed() throws Exception
	{
		validation=new ValidationActionHelpers();
		return validation.isElementVisible(driver, salesHeader);
	}
	public Boolean isSearchLabelDisplayed() throws Exception
	{
		return validation.isElementVisible(driver, searchLabel);
	}
	public Boolean istableHeaderNumberDisplayed() throws Exception
	{
		return validation.isElementVisible(driver, tableHeaderNumber);
	}
	public Boolean istableHeaderCustomerDisplayed() throws Exception
	{
		return validation.isElementVisible(driver, tableHeaderCustomer);
	}
	public Boolean istableHeaderTaxDisplayed() throws Exception
	{
		return validation.isElementVisible(driver, tableHeaderTax);
	}
	public Boolean istableHeaderDiscountDisplayed() throws Exception
	{
		return validation.isElementVisible(driver, tableHeaderDiscount);
	}
	public Boolean istableHeaderTotalDisplayed() throws Exception
	{
		return validation.isElementVisible(driver, tableHeaderTotal);
	}
	public Boolean istableHeaderCreatedByDisplayed() throws Exception
	{
		return validation.isElementVisible(driver, tableHeaderCreatedBy);
	}
	public Boolean istableHeaderTotalItemsDisplayed() throws Exception
	{
		return validation.isElementVisible(driver, tableHeaderTotalItems);
	}
	public Boolean istableHeaderStatusDisplayed() throws Exception
	{
		return validation.isElementVisible(driver, tableHeaderStatus);
	}
	public Boolean istableHeaderActionDisplayed() throws Exception
	{
		return validation.isElementVisible(driver, tableHeaderAction);
	}
	
	public Boolean isSaleActionButtonEnabled() throws Exception
	{
		return validation.isElementEnabled(driver, saleActionButton);
	}
	public Boolean isEditOptionEnabled() throws Exception
	{
		return validation.isElementEnabled(driver, saleEdit);
	}
	
	public Boolean isInvoiceOptionEnabled() throws Exception
	{
		return validation.isElementEnabled(driver, invoice);
	}
	public Boolean isPaymentOptionEnabled() throws Exception
	{
		return validation.isElementEnabled(driver, payment);
	}
	
	public Boolean isReceiptOptionEnabled() throws Exception
	{
		return validation.isElementEnabled(driver, receipt);
	}
	
	
	
	

}
