package com.qa.Testpages;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.qa.Pages.Homepage;
import com.qa.Pages.Loginpage;
import com.qa.Testbase.Testbase;
import com.qa.Utilities.CustomListner;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
@Listeners(CustomListner.class)

public class Testhomepage extends Testbase {
	Homepage Hp;
	Loginpage Lp;
	public Testhomepage()
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
public void homepagetitleTest()
{
	//extentTest = extent.startTest("freeCrmTitleTest");
	String title=Hp.pagetitle();
	Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in123333");
}

@Test(priority=2)
public void logoTest()
{
	//extentTest = extent.startTest("freeCrmTitleTest");
	boolean logostatus=Hp.logodisplay();
	Assert.assertTrue(logostatus);
}

@Test(priority=3)
public void searchboxTest()
{
	//extentTest = extent.startTest("freeCrmTitleTest");
	boolean searchboxstatus=Hp.searchboxdisplay();
	Assert.assertTrue(searchboxstatus);
}

@Test(priority=4)
public void guestusertest()
{
	//extentTest = extent.startTest("freeCrmTitleTest");
	String guestusertest=Hp.checkguestuser();
	Assert.assertEquals(guestusertest, "Hello, Sign in");
}

@Test(priority=5)
public void navigatetomyaccountTest()
{
	//extentTest = extent.startTest("freeCrmTitleTest");
	Lp=Hp.navigatetomyaccount();
}

@AfterClass
public void closebrowser(ITestResult result) throws IOException
{
	
		driver.close();
}

}
