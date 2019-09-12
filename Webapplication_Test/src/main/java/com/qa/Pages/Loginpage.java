package com.qa.Pages;

import com.qa.PageOR.HomepageOR;
import com.qa.PageOR.LoginpageOR;
import com.qa.Testbase.Testbase;

public class Loginpage extends Testbase {

	
	public Loginpage()
	{
		super();
	}
	public String loginpagetitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean loginpagelogo()
	{
		return driver.findElement(LoginpageOR.loginpagelogo).isDisplayed();
	}
	
	public String loginlabel()
	{
		return driver.findElement(LoginpageOR.logintitle).getText();
	}
	
	public Homepage login()
	{
		driver.findElement(LoginpageOR.emailfield).sendKeys("jayamalagouda@gmail.com");
		driver.findElement(LoginpageOR.continuebtn).click();
		driver.findElement(LoginpageOR.password).sendKeys("jayamala123");
		driver.findElement(LoginpageOR.loginbtn).click();
		return new Homepage();
	}
	
	public String loggedinuser()
	{
		return driver.findElement(HomepageOR.loggedinusername).getText();
		
	}
}
