package com.GuruBankingRealProject.Testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.GuruBankingRealProject.pageObjects.AddCustomerPage;
import com.GuruBankingRealProject.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
      @Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setusername(username);		
		logger.info("Entered username");
		lp.setpassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		Thread.sleep(5000);
		AddCustomerPage acp=new AddCustomerPage(driver);
		acp.clickAddCustomer();
		logger.info("adding customer details------");
		acp.custName("aparna");
		acp.custgender("male");
		
		acp.custdob("10","11","1985");
		
		acp.custaddress("pulivendula");
		acp.custcity("kadapa");
		acp.custstate("andhrapradesh");
		acp.custpinno("516390");
		acp.custtelephoneno("8689584265");
		String email=randomestring()+"@gmail.com";
		acp.custemailid(email);
		acp.custpassword("appu");
		acp.custsubmit();
		Thread.sleep(4000);
		
		logger.info("Customer details entered and validating");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("TestCase passed...");

		}
		else
		{
			Assert.assertTrue(false);
			captureScreenshot(driver,"AddnewCustomer");
			logger.info("TestCase failed....");

		}
	}

	
}
