package com.qa.PageOR;

import org.openqa.selenium.By;

public class LoginpageOR {

	
	public static By loginpagelogo=By.className("a-link-nav-icon");
	
	public static By logintitle=By.xpath("//h1[contains(text(),'Login')]");
	public static By emailfield=By.id("ap_email");
	public static By continuebtn=By.id("continue");
	public static By password=By.id("ap_password");
	public static By loginbtn=By.id("signInSubmit");
}
