package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div/div/h1/span")
	WebElement userlabel;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[2]/div[1]/a[1]/span")
	WebElement dashboardlink;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[2]/div[1]/a[4]/span")
	WebElement positionlink;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[2]/div[1]/a[5]/span")
	WebElement fundslink;
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public String homePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyUserLabel()
	{
	return	userlabel.isDisplayed();
	}

	public dashboardlink clickdashboardLink()
	{
		dashboardlink.click();
		return new dashboardlink();
	}
	
	public FundLink clickFundsLink()
	{
		fundslink.click();
		return new FundLink();
		
	}
	
	}

