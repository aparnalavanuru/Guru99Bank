package com.GuruBankingRealProject.Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.GuruBankingRealProject.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		
		logger.info("url opened");
		LoginPage lp=new LoginPage(driver);
		lp.setusername(username);
		logger.info("Entered username");
		lp.setpassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		Thread.sleep(5000);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test is passed");
		}
		else
		{
			captureScreenshot(driver,"Logintest");
			Assert.assertTrue(false);
			logger.info("Test is failed");
		}
	}

}
