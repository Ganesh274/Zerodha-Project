package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class LoginPage extends BaseClass{

	// page FACTORY  And OBJECT REPOSITORY
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[1]/div/div/div/form/div[2]/input")
	WebElement username;
	
	@FindBy(xpath="//*[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[1]/div/div/div/form/div[2]/div/input")
	WebElement pin;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[1]/div/div/div/form/div[3]/button")
	WebElement contbtn;
	
	// Initializing the Page Object
	
	public LoginPage()  {
		PageFactory.initElements(driver,this);
	}
	// Actions 
	
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String un,String pass,String no) throws IOException
	{
		username.sendKeys(un);
		password.sendKeys(pass);
		loginbtn.click();
		pin.sendKeys(no);
		contbtn.click();
		return new HomePage();
	}
	
}
