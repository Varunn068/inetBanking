package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

import ExtentReports.Multiplelogin;

public class TC_loginDDT_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
	
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickSubmit();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
		}
		else
		{
			Assert.assertTrue(true);
			Thread.sleep(1000);
			lp.clicklogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		
	}
	
	public boolean  isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	@DataProvider(name="LoginData")
	 String [][] getData() throws IOException
	{
		
		String path="C:\\Users\\LENOVO\\Desktop\\inta\\inetBankingv1\\src\\test\\java\\com\\inetBanking\\testData\\LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path,"Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++) 
		{
			
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i, j);
			
			}
		}
		return logindata;
	} 
}
