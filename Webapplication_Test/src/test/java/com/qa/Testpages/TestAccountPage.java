package com.qa.Testpages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.qa.PageOR.AccountpageOR;
import com.qa.Pages.Accountpage;
import com.qa.Pages.Homepage;
import com.qa.Pages.Loginpage;
import com.qa.Testbase.Testbase;
import com.qa.Utilities.CustomListner;
import com.qa.Utilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(CustomListner.class)

public class TestAccountPage extends Testbase {

	Homepage Hp;
	Loginpage Lp;
	Accountpage Ap;
	public TestAccountPage()
	{
		super();
	}

	/*public ExtentReports extent;
	public ExtentTest extentTest;
	
	@BeforeTest
	public void setextent()
	{
	
	extent = new ExtentReports("C:\\Users\\Jayamala\\eclipse-workspace\\Webapplication_Test\\test-output\\Test_Extent.html", true);
	extent.addSystemInfo("Host Name", "Naveen Mac");
	extent.addSystemInfo("User Name", "Naveen Automation Labs");
	extent.addSystemInfo("Environment", "QA");
	}
	@AfterTest
	public void endreport()
	{
		extent.flush();
		extent.close();
	}*/
	@BeforeClass
	public void launchbrowser()
	{
		initialization();
		Hp=new Homepage();
		Lp=new Loginpage();
		Ap=new Accountpage();
		
	}
	
	
	/*public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination ="C:\\Users\\Jayamala\\eclipse-workspace\\Webapplication_Test\\Screenshots\\" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	*/
	@Test(priority=1)
	public void Testloginpage()
	{
		Hp.navigatetomyaccount();
		driver.findElement(AccountpageOR.createaccountbtn).click();
	}
	@Test(priority=2)
	public void accountpagetitleTest()
	{
		String accountpagetitle=Ap.Accountpagetitle();
		Assert.assertEquals(accountpagetitle,"Amazon Registrations2313313");
	}
	@Test(priority=3)
	public void Testlogodisplay()
	{
		boolean logodisplayflag1=Ap.accountlogodisplay();
		Assert.assertTrue(logodisplayflag1);
	}
	@DataProvider
	
	public Object[][] Readexcel() throws EncryptedDocumentException, IOException
	{
		Object data[][]=Utilities.getdata("account");
		return data;
		
	}
	@Test(priority=4, dataProvider="Readexcel")
	
	public void CreateaccountTest(String name,String phone,String email,String password)
	{
		Ap.createaccount(name, phone, email, password);
		
	}
	
	@AfterClass
	public void closebrowser() throws IOException
	{
		
	/*	if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = TestAccountPage.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}*/
		driver.close();
	}
	
	
}
