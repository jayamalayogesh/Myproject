package com.qa.Pages;

import com.qa.PageOR.HomepageOR;
import com.qa.PageOR.ShoppingcartOR;
import com.qa.Testbase.Testbase;

public class Homepage extends Testbase {

	
	public Homepage()
	{
		super();
	}
	
	public String pagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean logodisplay()
	{
		return driver.findElement(HomepageOR.logo).isDisplayed();
	}
	
	public boolean searchboxdisplay()
	{
		return driver.findElement(HomepageOR.searchbox).isDisplayed();
	}
	
	public String checkguestuser()
	{
		return driver.findElement(HomepageOR.myaccountlink).getText();
	}
	
	public Loginpage navigatetomyaccount()
	{
		driver.findElement(HomepageOR.myaccountlink).click();
		return new Loginpage();
	}
	
	public Shoppingcartpage navigatetocartpage()
	{
		driver.findElement(ShoppingcartOR.cartlink).click();
		return new Shoppingcartpage();
	}
}
