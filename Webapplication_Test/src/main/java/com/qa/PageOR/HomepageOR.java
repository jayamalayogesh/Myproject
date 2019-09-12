package com.qa.PageOR;

import org.openqa.selenium.By;

public class HomepageOR {

	public static By logo=By.xpath("//div[@id='nav-logo']");
	public static By myaccountlink=By.xpath("//span[contains(text(),'Hello, Sign in')]");
	public static By searchbox=By.xpath("//input[@id='twotabsearchtextbox']");
	public static By loggedinusername=By.xpath("//span[starts-with(text(),'Hello, ')]");
}
