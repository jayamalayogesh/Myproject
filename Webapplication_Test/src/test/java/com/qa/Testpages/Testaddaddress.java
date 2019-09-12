package com.qa.Testpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.PageOR.HomepageOR;
import com.qa.Pages.Homepage;
import com.qa.Pages.Loginpage;
import com.qa.Testbase.Testbase;
import com.qa.Utilities.CustomListner;
@Listeners(CustomListner.class)
public class Testaddaddress extends Testbase {
	/************Object Repository************/
	/*@FindBy(xpath="//span[contains(text(),'Hello, Sign in')]") 
	WebElement Accountlink;*/
	
static By Accountlink=By.xpath("//span[contains(text(),'Hello, Sign in')]");
static By Yourorder=By.id("nav-link-accountList");
static By Aftersignin=By.id("nav-link-accountList");
//static By addaddre11ss=By.xpath("//div[@Class='a-box-inner'][4]");
		
static By addaddress=By.xpath(".//*[@id='a-page']/div[2]/div/div[3]/div[1]/a/div/div");



static By addaddresstab=By.xpath("(//div[@class='a-box-inner'])[4]");

		
//static By addaddre12ss=By.xpath("//span[contains(@text,'Edit addresses for orders and gifts')]");
static By addaddress1=By.xpath(".//*[@id='ya-myab-address-add-link']/div");
	
	/*@FindBy(id="nav-link-accountList")
	WebElement Yourorder;*/
	
/*	@FindBy(id="nav-link-accountList")
	WebElement Aftersignin;*/
	
	@FindBy(className="nav-action-inner")
	WebElement signin;
	
	
	@FindBy(className="nav-a nav-a-2 nav-active")
	WebElement shopbycatagorylink;
	
	@FindBy(linkText="Men's Fashion")
	WebElement Menslink;
	
	@FindBy(xpath="//h2[contains(@text,'Your Addresses')]")
	WebElement Youraddress;
	
	@FindBy(className="a-box-inner a-padding-extra-large")
	WebElement addaddresssymbol;
	
/**********************End***************/
	public Testaddaddress()
	{
		super();
		//PageFactory.initElements(driver,this);
		
	}
	Homepage hp;
	Loginpage Lp;
	
@BeforeClass
public void Launchbrowser()
{
	
	PageFactory.initElements(driver, Testaddaddress.class);
		hp=new Homepage();
		Lp=new Loginpage();
		
		initialization();
}


@Test(priority=1)
public void clickonsignlink() throws InterruptedException
{
	driver.findElement(Accountlink).click();
	hp=Lp.login();
	//driver.findElement(HomepageOR.myaccountlink).click();
	

	
}

@Test(priority=2)
public void navigatetoyouraccount() throws InterruptedException
{
	Actions ac=new Actions(driver);
	ac.moveToElement(driver.findElement(Aftersignin));
	
	Thread.sleep(5000);
	driver.findElement(Yourorder).click();
	//driver.findElement(By.linkText("Your Account")).click();
	Thread.sleep(5000);
}

@Test(priority=3)
public void clickonaddaddress() throws InterruptedException
{
	
	Thread.sleep(10000);
	driver.findElement(addaddresstab).click();
	Thread.sleep(10000);
	driver.findElement(addaddress1).click();
	String pagetitle=driver.getTitle();
	Assert.assertEquals(pagetitle,"Your Addresses");

}
@AfterClass
public void closebrowser()
{
	driver.quit();
}
}
