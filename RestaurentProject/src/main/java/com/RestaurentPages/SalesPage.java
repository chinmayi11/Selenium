package com.RestaurentPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SalesPage {
	public SalesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	WebDriver driver;
	

}
