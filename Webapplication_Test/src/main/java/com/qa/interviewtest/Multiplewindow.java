package com.qa.interviewtest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multiplewindow {

public static void main(String args[]) throws InterruptedException
{
	System.setProperty("WebDriver.chrome.driver", "C:/chromedriver.exe");
	 WebDriver driver=new ChromeDriver();
	driver.get("http://www.popuptest.com/goodpopups.html");
	 /*
		
		Thread.sleep(2000);
		 
	 Iterator<String> itr=s1.iterator();*/
	 String parentwindow=driver.getWindowHandle();
	System.out.println("patent id id:"+ parentwindow);
	driver.findElement(By.linkText("Good PopUp #3")).click();
	driver.findElement(By.linkText("Good PopUp #2")).click();
	driver.findElement(By.linkText("Good PopUp #4")).click();
	Set<String> s1=driver.getWindowHandles();
	
	int count=s1.size();
	System.out.println("size is :"+count);
	
	for(String child:s1)
	{
		if(!parentwindow.equalsIgnoreCase(child))
		{
			driver.switchTo().window(child);
			System.out.println("child id:"+ child);
			Thread.sleep(5000);
			System.out.println("title:"+driver.getTitle());
			driver.close();
		}
	}
	/*String childwindow=itr.next();
	System.out.println("child id id:"+ childwindow);
			driver.switchTo().window(childwindow);
			Thread.sleep(5000);
			//Thread.sleep(8000);
			String ch=driver.getTitle();
			System.out.println("Child window title is::"+ch);
	driver.close();
	*/
	driver.switchTo().window(parentwindow);
	Thread.sleep(2000);
	System.out.println("parent window title is::"+driver.getTitle());
	
	 
	 driver.quit();
}
}