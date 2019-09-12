package com.qa.interviewtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class readandwriteexcel {
@Test(priority=1)
	public void initials()
	{
		
	
	System.setProperty("WebDriver.chrome.driver", "C:/chromedriver.exe");
	 WebDriver driver=new ChromeDriver();
	driver.get("http://www.myntra.com");
	}


}
