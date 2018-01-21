package com.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;

public class TestBase 
{

	public static WebDriver  driver;
	public static Properties prop;
	
	public TestBase()
	{
		try {
			
			prop= new Properties();
			
			FileInputStream inputStream = new FileInputStream( "C:\\Users\\AbhiAtithi\\eclipse-workspace\\SeleniumTest\\src\\main\\java\\com\\qa\\config\\config.properties" );
			
			prop.load( inputStream );
		
		} 
		catch ( FileNotFoundException e ) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void initialize (  ) 
	{
		
		String browsername = prop.getProperty ("browser").toString();
		
	   	
		if (browsername.equals("chrome"))
		{
			System.setProperty( "webdriver.chrome.driver" , prop.getProperty( "chromeDriver" ) );
			driver = new ChromeDriver();
			 
		}
		else if (browsername.equals( "firefox"))
		{
			System.setProperty( "webdriver.gecko.driver" , prop.getProperty( "chromeDriver" ) );
			driver = new FirefoxDriver();
			 
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT , TimeUnit.SECONDS );
		driver.manage().timeouts().implicitlyWait( TestUtil.IMPLICIT_WAIT , TimeUnit.SECONDS );
		
		driver.get(prop.getProperty( "baseUrl" ));
		
		
		
		
		
	}



}
