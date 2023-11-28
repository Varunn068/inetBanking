package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

import jdk.internal.org.jline.utils.Log;

public class Login_Test extends BaseClass  {

	@Test
	public void loginTest()
	{  
	
	
	   
	    
	    LoginPage lp = new LoginPage(driver);
	    lp.setUserName(username);
	    lp.setPassword(password);
	    lp.clickSubmit();
	    
	    if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}
	
}
