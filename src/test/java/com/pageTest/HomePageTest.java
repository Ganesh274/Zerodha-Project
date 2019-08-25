package com.pageTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;

public class HomePageTest extends BaseClass {

	LoginPage login;
	HomePage home; 
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initilization();
	    login=new LoginPage();
	    home=login.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("pin"));
	    
	}
	
	@Test(priority=1)
	public void homePageTitleTest()
	{
		String title=home.homePageTitle();
		Assert.assertEquals(title, "Kite - Zerodha's fast and elegant flagship trading platform","Home page Title is not match");
	System.out.println(title);
	}
	
	@Test(priority=2)
	
		public void userlabelTest()
		{
		Assert.assertTrue(home.verifyUserLabel());
		}
	
	
	
	@AfterMethod
	public void destroy()
	{
		driver.quit();
	}
	
	
	
	
	
	
}
