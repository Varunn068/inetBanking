package com.inetBanking.testCases;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import ExtentReports.Multiplelogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {
	
	ReadConfig readconfig= new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;

    @Parameters("browser")
	@BeforeClass
	public void setup(String br) {
	
    	if(br.equals("chrome"))
    	{
    		WebDriverManager.chromedriver().setup();
      		 driver = new ChromeDriver();
    	}
    	else if(br.equals("edge"))
    	{
    		WebDriverManager.edgedriver().setup();
    		driver= new EdgeDriver();
    	}
    	 driver.get(baseURL);
    }
	@AfterClass
	public void teardown() 
	{
		
		driver.quit();
		
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(7);
		return(generatedstring);
	}
	
	
}
