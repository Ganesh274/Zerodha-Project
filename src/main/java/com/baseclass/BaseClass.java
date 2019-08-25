package com.baseclass;

import java.awt.Window;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.util.UtilClass;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	
	
	public BaseClass()
	{
		prop=new Properties();
		
		try {
			FileInputStream ip=new FileInputStream("D:\\New Testing\\Zerodha\\src\\main\\java\\com\\cinfigue\\configue.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initilization()
	{
		String name=prop.getProperty("browser");
		
		if(name.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Automation\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(name.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UtilClass.PAGE_LOAD, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilClass.IMLICIT_TIME, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
}






