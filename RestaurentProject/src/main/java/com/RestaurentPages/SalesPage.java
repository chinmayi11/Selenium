package com.RestaurentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ActionHelper.SendKeysActionHelper;
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
	@FindBy (xpath="//input[@type='search']")
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
	@FindBy (xpath="//div[@id='editModal']//div[@class='modal-footer']//button[@type='button' and contains(.,'Submit')]")
	WebElement SaleEditSubmitButton;
	/*@FindBy (id="//select[@id='customerSelect']")
	WebElement changeClientDropdown;
	@FindBy (id="//select[@id='changeStatus']")
	WebElement changeStatusDropdown;*/
	@FindBy (xpath="//div[@id='invoice']//div[@id='invoiceModal']//div[@class='modal-content']//div[@class='modal-header']//button[contains(.,'×')]")
	WebElement closeButton;
	@FindBy (xpath="//div[@id='invoice']//div[@id='invoiceModal']//div[@class='modal-content']//div[@class='modal-footer']//button[text()='PDF']")
	WebElement pDFButton;
	@FindBy (xpath="//div[@id='invoice']//div[@id='invoiceModal']//div[@class='modal-content']//div[@class='modal-footer']//button[text()='print']")
	WebElement printButton;
	SendKeysActionHelper send;
	public @FindBy (xpath="//table[@id='table']//tbody//tr//td[2]")
	WebElement searchTableCustomerName;
	@FindBy (xpath="//div[@id='payements']//div[@id='modal-body']//div[@id='payementsSection']//h4//b[text()='Total']")
	WebElement totalLabel;
	@FindBy (xpath="//div[@id='payements']//div[@id='modal-body']//button[contains(.,'Add Payement')]")
	WebElement addPaymentButton;
	@FindBy (xpath="//div[@id='payements']//div//button[contains(.,'Close')]")
	WebElement paymentCloseButton;
	@FindBy (css="select[id='customerSelect']")
	WebElement changeClientDropDown;
	@FindBy (css="select[id='changeStatus']")
	WebElement changeStatusDropDown;
	@FindBy (xpath="//div[@id='editModal']//div[@class='modal-footer']//button[@type='button' and contains(.,'Close')]")
	WebElement editCloseButton;
	
	//Method to click on Action
	public void searchCustomer(String name) throws Exception
	{
		
		send=new SendKeysActionHelper();
		send.clearAndsendkeys(driver, searchLabel, name);
		
	}
	
	
	public void clickActionButton()
	{
		
		saleActionButton.click();;
		
	}
	public void clickSalesEdit()
	{
		saleEdit.click();;
	}
	public void clickCloseButton()
	{
		closeButton.click();
	}
	public void clickEditCloseButton()
	{
		editCloseButton.click();
	}

	public void clickPayment()
	{
		payment.click();
	}
	public void selectClient(String clientName) throws Exception
	{
		Select dropDown = new Select(changeClientDropDown);
		dropDown.selectByVisibleText(clientName);
	}
	public void selectStatus(String paymentStatus) throws Exception
	{
		Select dropDown1 = new Select(changeStatusDropDown);
		dropDown1.selectByVisibleText(paymentStatus);
	}
	public void clickSaleEditSubmitButton()
	{
		SaleEditSubmitButton.click();
	}
	public void clickInvoice()
	{
		invoice.click();
	}
	public void clickPrintButton()
	{
		printButton.click();
	}
	public void clickPaymentCloseButton()
	{
		paymentCloseButton.click();
	}
	
	
	
	//methods to check validation of elements//
	
	public Boolean isChangeClientDropDownEnabled() throws Exception
	{
		
		return changeClientDropDown.isEnabled();
	}
	public Boolean isChangeStatusDropDownEnabled() throws Exception
	{
		return changeStatusDropDown.isEnabled();
	}
	public Boolean isEditSubmitButtonEnabled() throws Exception
	{
		return SaleEditSubmitButton.isEnabled();
	}
	public Boolean isSalesHeaderDisplayed() throws Exception
	{
		
		return salesHeader.isDisplayed();
	}
	public Boolean isSearchLabelDisplayed() throws Exception
	{
		return searchLabel.isDisplayed();
	}
	public Boolean istableHeaderNumberDisplayed() throws Exception
	{
		return tableHeaderNumber.isDisplayed();
	}
	public Boolean istableHeaderCustomerDisplayed() throws Exception
	{
		return tableHeaderCustomer.isDisplayed();
	}
	public Boolean istableHeaderTaxDisplayed() throws Exception
	{
		return tableHeaderTax.isDisplayed();
	}
	public Boolean istableHeaderDiscountDisplayed() throws Exception
	{
		return tableHeaderDiscount.isDisplayed();
	}
	public Boolean istableHeaderTotalDisplayed() throws Exception
	{
		return tableHeaderTotal.isDisplayed();
	}
	public Boolean istableHeaderCreatedByDisplayed() throws Exception
	{
		return tableHeaderCreatedBy.isDisplayed();
	}
	public Boolean istableHeaderTotalItemsDisplayed() throws Exception
	{
		return tableHeaderTotalItems.isDisplayed();
	}
	public Boolean istableHeaderStatusDisplayed() throws Exception
	{
		return tableHeaderStatus.isDisplayed();
	}
	public Boolean istableHeaderActionDisplayed() throws Exception
	{
		return tableHeaderAction.isDisplayed();
	}
	
	public Boolean isSaleActionButtonEnabled() throws Exception
	{
		return saleActionButton.isEnabled();
	}
	public Boolean isEditOptionEnabled() throws Exception
	{
		return saleEdit.isEnabled();
	}
	
	public Boolean isInvoiceOptionEnabled() throws Exception
	{
		return invoice.isEnabled();
	}
	public Boolean isPaymentOptionEnabled() throws Exception
	{
		return payment.isEnabled();
	}
	
	public Boolean isReceiptOptionEnabled() throws Exception
	{
		return receipt.isEnabled();
	}
	
	public Boolean isCloseButtonEnabled()
	{
		return closeButton.isEnabled();
	}
	
	public Boolean isPDFButtonEnabled()
	{
		return pDFButton.isEnabled();
	}
	public Boolean isPaymentButtonEnabled()
	{
		return payment.isEnabled();   
	}
	public Boolean isTotalLabelDisplayed()
	{
		return totalLabel.isDisplayed();
	}
	public Boolean isClosePaymentButtonEnabled()
	{
		return paymentCloseButton.isEnabled();
	}
	public Boolean isEditCloseButtonEnabled()
	{
		return editCloseButton.isEnabled();
	}
	
	

}
