package com.qa.Testpages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Utilities.Xls_Reader;

public class Pagefactrory {

	
	static WebDriver driver;
	
	 
	 
	 @FindBy(how = How.XPATH, using ="html/body/div[1]/div[2]/div/div/div/div/div[1]/h1/a/i")
	 
	 static WebElement logo;
	 
	 @FindBy(name="firstname")
	 static WebElement firstname;
	 
	 @FindBy(name="lastname")
	 static WebElement lst;
	 
	 @FindBy(name="reg_email__")
	 static WebElement Email;
	 
	 @FindBy(name="reg_passwd__")
	static  WebElement pass;
	 
	 @FindBy(name="websubmit")
	 static WebElement submit;
	 
	 @FindBy(how=How.XPATH, using=".//*[@id='u_0_r']")
	 static WebElement lastname;
	 
	 @FindBy(how=How.XPATH, using=".//*[@id='u_0_u']")
	 static WebElement mobnum;
	 
	 @FindBy(how=How.XPATH, using=".//*[@id='u_0_11']")
	 static WebElement password;
	 
	 @FindBy(how=How.XPATH, using=".//*[@id='day']")
	 static WebElement date;
	 
	 @FindBy(how=How.XPATH, using=".//*[@id='month']")
	 static WebElement month;
	 
	 @FindBy(how=How.XPATH, using=".//*[@id='year']")
	 static WebElement year;
	 
	 @FindBy(how=How.XPATH, using=".//*[@id='u_0_19']")
	 static WebElement signup;
	 
	 @FindBy(how=How.XPATH, using=".//*[@id='u_0_15']/span[1]")
	 static WebElement femelechk;
	 
	 
	 @BeforeClass
	 public void launchbrowser()
	 {
		 
		 System.setProperty("WebDriver.chrome.driver", "C:/chromedriver.exe");
			driver=new ChromeDriver();
		 
		 /*System.setProperty("Webdriver.gecko.driver", "C:/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(new FirefoxProfile());
			options.addPreference("dom.webnotifications.enabled", false);

			WebDriver driver = new FirefoxDriver();*/
	    	        driver.get("http://www.facebook.com");
	        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	        
	 
	       PageFactory.initElements(driver, Pagefactrory.class);
	 }
	 
	 @Test(priority=1)
	 public void testpagetitle() throws InterruptedException
	 {
		 Thread.sleep(5000);
		 
		 String title=driver.getTitle();
		 
		 //assert.assertEquals(title, "Facebook – log in or sign up");
		 
		Assert.assertEquals(title,"Facebook – log in or sign up");
		 
	 }
	 @Test(priority=2)
	 public void logotest() throws InterruptedException
	 {
		 Thread.sleep(5000);
		 boolean status=logo.isDisplayed();
		 
		 Assert.assertTrue(status);
	 }
	/* @Test(priority=3)
	 public void createaccount() throws InterruptedException
	 {
		 
		 Xls_Reader reader=new Xls_Reader("C:\\Users\\Jayamala\\eclipse-workspace\\Webapplication_Test\\src\\main\\java\\com\\qa\\Testdata\\testdatanew.xlsx");
		//String facebook;
		// reader.addColumn("facebook", "status");
		
for(int i=2;i<=reader.getRowCount("facebook");i++)
{
		 		String firstname1=reader.getCellData("facebook", "firstname", i);
		 		 String lastname=reader.getCellData("facebook", "lastname",i);
		 		 String email=reader.getCellData("facebook", "email", i);
		 		 String password=reader.getCellData("facebook", "password", i);
		 		 
		 Thread.sleep(5000);
		 
		 firstname.sendKeys(firstname1);

	lst.sendKeys(lastname);

	Email.sendKeys(email);
	pass.sendKeys(password);
}
								 
		driver.findElement(By.xpath(".//*[@id='u_0_p']")).sendKeys("jayamala");
		 Thread.sleep(2000);
		 lst.sendKeys("jayaqwer");
		 Thread.sleep(2000);
		 Email.sendKeys("2662727272");
		 Thread.sleep(2000);
		 pass.sendKeys("password");
		 
		 Select dateday=new Select(date);
		 dateday.deselectByVisibleText("18");
		 
		 Select datemonth=new Select(month);
		 dateday.deselectByVisibleText("Jun");
		 
		 Select dateyear=new Select(year);
		 dateday.deselectByVisibleText("1994");
		 
		 femelechk.click();
	 }
	 */
	/* @Test(priority=4)
	 public void tooltip() throws InterruptedException
	 {
		 
		 String expmsg="You can change who sees your gender on your profile later. Select Custom to choose another gender, or if you'd rather not say.";
		 
		 driver.findElement(By.id("gender-help")).click();
		 Thread.sleep(3000);
		 
		 Actions builder=new Actions(driver);
		 WebElement tooptip=driver.findElement(By.xpath(".//*[@id='globalContainer']/div[3]/div/div/div/div[1]"));
		 
		 Thread.sleep(4000);
		 builder.moveToElement(tooptip).perform();
		 
		 String tooltip_msg=tooptip.getText();
		 
		// Print the tooltip message just for our refrences
		 System.out.println("Tooltip/ Help message is :"+tooltip_msg);
		 Assert.assertEquals(tooltip_msg, expmsg);
	 }*/
	 
	 
	/* @Test(priority=5)
	 public void scrollview() throws InterruptedException
	 {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement Element = driver.findElement(By.linkText("Help"));
		 js.executeScript("arguments[0].scrollIntoView();", Element);
		 Element.click();
		 Thread.sleep(5000);
		 
	 }*/
	 @Test(priority=3)
	 public void errormsg()
	 {
		 
		 Actions builder=new Actions(driver);
		 submit.click();
		 String act_fname="What's your name?";
		WebElement fname=driver.findElement(By.xpath("//div[@class='_5633 _5634 _53ij']"));
		builder.moveToElement(fname).perform();
		
		String fnamemsg=fname.getText();
		
		System.out.println("Error msg is:"+fnamemsg);
		Assert.assertEquals(fnamemsg, act_fname);
		
	 }
	 @AfterClass
	 public void closebrowser()
	 {
		 driver.close();
	 }	
}
