package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	// pagefactory or
	
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(test(),'Sign Up')]")
	WebElement signUpbtn;
	
	@FindBy(xpath="//a[contains(@class, 'navbar-brand')]/img[contains(@class, 'img-responsive')]")
	WebElement freelogo;
	
	public LoginPage (  ) {
		
		PageFactory.initElements(driver , this  );
		
	}
	
	public String validateTitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean validateCRMImage()
	{
		return freelogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd )
	{
		username.sendKeys( un );
		password.sendKeys( pwd );
		loginBtn.click();
		
		return new HomePage();
	}

}
