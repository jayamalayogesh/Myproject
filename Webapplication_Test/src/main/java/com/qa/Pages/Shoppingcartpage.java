package com.qa.Pages;

import com.qa.PageOR.ShoppingcartOR;
import com.qa.Testbase.Testbase;

public class Shoppingcartpage extends Testbase{

	
	public Shoppingcartpage()
	{
		super();
	}
	
	public Shoppingcartpage navigatetocartpage()
	{
		driver.findElement(ShoppingcartOR.cartlink).click();
		return new Shoppingcartpage();
	}
	
	public String cartpagetitle()
	{
	return driver.getTitle();
	}
	
	public String pageheader()
	{
		return driver.findElement(ShoppingcartOR.pagetitle).getText();
	}
	
	public boolean checkproocedbtn()
	{
		return driver.findElement(ShoppingcartOR.proceedbtn).isDisplayed();
	}
}
