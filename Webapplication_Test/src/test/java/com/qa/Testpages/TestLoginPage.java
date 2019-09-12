package com.qa.Testpages;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.qa.Pages.Homepage;
import com.qa.Pages.Loginpage;
import com.qa.Testbase.Testbase;

public class TestLoginPage extends Testbase {
	Homepage Hp;
	Loginpage Lp;
	
	public TestLoginPage()
	{
		super();
	}

	@BeforeClass
	public void launchbrowser()
	{
		initialization();
		Hp=new Homepage();
		Lp=new Loginpage();
		
	}
	@Test(priority=1)
	public void Testloginpage()
	{
		Hp.navigatetomyaccount();
	}
	@Test(priority=2)
	public void Testpagetitle()
	{
		String loginpagetitle=Lp.loginpagetitle();
		Assert.assertEquals(loginpagetitle, "Amazon Sign In");
	}
	
	@Test(priority=3)
	public void Testlogodisplay()
	{
		boolean logodisplayflag=Lp.loginpagelogo();
		Assert.assertTrue(logodisplayflag);
	}
	
	@Test(priority=4)
	public void Testlogin()
	{
		Hp=Lp.login();
	}
	
	@Test(priority=5)
	public void Testloggedinuser()
	{
		String loggedinuser=Lp.loggedinuser();
		System.out.println(prop.getProperty("username"));
		Assert.assertEquals(loggedinuser, "Hello, "+prop.getProperty("username"));
	}
	
	@AfterClass
	public void closebrowser()
	{
		driver.close();
	}
}
