package com.qa.Testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.Utilities.Utilities;

public class Testbase {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	
	public Testbase()
	{
		try
		{
			
			prop=new Properties();
			FileInputStream file=new FileInputStream("C:\\Users\\Jayamala\\eclipse-workspace\\Webapplication_Test\\src\\main\\java\\com\\qa\\Configuration\\Configuration");
		prop.load(file);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		
		{
			e.printStackTrace();
		}
	}
	
	public void initialization()
	{
		logger=Logger.getLogger("AmazonWebApplicationlogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		String browsername=prop.getProperty("browser");
		if(browsername.equals("FF"))
		{
        System.setProperty("Webdriver.gecko.driver", "C:/geckodriver.exe");
        driver=new FirefoxDriver();
		}
		else if(browsername.equals("chrome"))
		{
			System.setProperty("WebDriver.chrome.driver", "C:/chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utilities.IMPLICIT_WAIT__TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public void failed(String methodname)
	{
	      File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      
	    try {
	     
	    /*	FileUtils.copyFile(srcFile,new File("C:\\Users\\Jayamala\\eclipse-workspace\\Testonlineshopping\\Screenshots\\"+methodname+".jpg"));*/
	    	FileUtils.copyFile(srcFile,new File("C:\\Users\\Jayamala\\eclipse-workspace\\Webapplication_Test\\Screenshots\\"+methodname+".jpg"));
	    }catch(IOException e)
	    {
	    	e.printStackTrace();
	    }
	}
}
