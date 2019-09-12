package com.qa.Pages;

import com.qa.PageOR.AccountpageOR;
import com.qa.PageOR.LoginpageOR;
import com.qa.Testbase.Testbase;

public class Accountpage extends Testbase {

	public Accountpage()
	{
		super();
	}
	
	public String Accountpagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean accountlogodisplay()
	{
		return driver.findElement(LoginpageOR.loginpagelogo).isDisplayed();
		
	}
	
	public String Accountpageheadertext()
	{
		return driver.findElement(AccountpageOR.createaccounttext).getText();
	}
	
	public void createaccount(String name, String phone,String email,String password)
	{
		driver.findElement(AccountpageOR.yourname).sendKeys(name);
		driver.findElement(AccountpageOR.phone).sendKeys(phone);
		driver.findElement(AccountpageOR.email).sendKeys(email);
		driver.findElement(AccountpageOR.password).sendKeys(password);
		
	}
}
