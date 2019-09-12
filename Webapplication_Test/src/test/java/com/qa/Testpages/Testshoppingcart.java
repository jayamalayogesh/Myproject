package com.qa.Testpages;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Pages.Homepage;
import com.qa.Pages.Shoppingcartpage;
import com.qa.Testbase.Testbase;

public class Testshoppingcart extends Testbase {

	public Testshoppingcart()
	{
		super();
	}
	
	Homepage Hp;
	Shoppingcartpage Sp;
	@BeforeClass
	public void launchbrowser() throws InterruptedException
	{

		initialization();
		Thread.sleep(10000);
		Hp=new Homepage();
		Sp=new Shoppingcartpage();
	}
	@Test(priority=1)
	public void Testcartnavigation()
	
	{
		Hp.navigatetocartpage();
	}
	
	@Test(priority=2)
	public void Testcartpagetitle()
	{
	String cartpagetitle=Sp.cartpagetitle();
	Assert.assertEquals(cartpagetitle, "Amazon.in Shopping Cart");
	
	}
	
	@Test(priority=3)
	public void Testcartpageheader()
	{
		String cartheader=Sp.pageheader();
		Assert.assertEquals(cartheader, "Shopping Cart");
	}
	
	@Test(priority=4)
	public void Testcartpagecontinuebtn()
	{
		boolean proceedbtn=Sp.checkproocedbtn();
		Assert.assertTrue(proceedbtn);
	
	}
	@AfterClass
	public void closebrowser()
	{
		driver.quit();
}
}
