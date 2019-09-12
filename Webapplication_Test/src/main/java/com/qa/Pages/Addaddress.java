package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Testbase.Testbase;

public class Addaddress extends Testbase {
/************Object Repository************/
	@FindBy(id="nav-link-accountList") 
	WebElement Accountlink;
	
	@FindBy(className="nav-action-inner")
	WebElement signin;
	
	
	
/**********************End***************/
	public Addaddress()
	{
		PageFactory.initElements(driver, this);
	}
	
}
