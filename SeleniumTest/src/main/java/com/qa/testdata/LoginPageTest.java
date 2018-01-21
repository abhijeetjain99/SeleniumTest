package com.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	 //public LoginPageTest () {
	//	super();
	//}
	
	@BeforeMethod
	public void setUp()
	{ 
		initialize();
		loginPage= new LoginPage();

	}

	@Test(priority=0)
	public void loginPageTitleTest()
	{
		String title= loginPage.validateTitle();

		Assert.assertEquals( title ,"#1 Free CRM for Any Business: Online Customer Relationship Software" );


	}

	@Test(priority=1)
	public void CRMLogoTest()
	{
		boolean logo = loginPage.validateCRMImage();

		Assert.assertTrue( logo );
	}
	@Test(priority=2)
	public void loginTest()
	{
		homePage =	loginPage.login( prop.getProperty( "userName" ) , prop.getProperty( "password" ) );
		
	
	}	


	@AfterMethod
	public void teardown()
	{
		driver.quit();

	}


}
