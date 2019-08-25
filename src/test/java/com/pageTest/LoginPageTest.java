package com.pageTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginPageTest  extends BaseClass{

	LoginPage login;
	HomePage home;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void init()
	{
		initilization();
		login=new LoginPage();
	}
	
	@Test(priority=1)
	public void validationTitle()
	{
		String title=login.validatePageTitle();
		Assert.assertEquals(title, "Kite - Zerodha's fast and elegant flagship trading platform");
		System.out.println(title);
		
	}
	
	@Test(priority=2)
	public void loginTest() throws IOException, InterruptedException
	{
	home=	login.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("pin"));
	System.out.println("Login Done");
	Thread.sleep(5000);
	}	
	
	
	
	
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
