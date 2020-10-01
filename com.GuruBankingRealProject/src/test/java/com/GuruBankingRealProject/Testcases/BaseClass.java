package com.GuruBankingRealProject.Testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.GuruBankingRealProject.Utilities.ReadConfig;


public class BaseClass {
     
    ReadConfig rc=new ReadConfig();
	public String url=rc.getUrl();
	 public String username=rc.getusername();
	 public String password=rc.getpassword();
	 
	 public static WebDriver driver;
	 
	 public static Logger logger;
	 @Parameters("browser")
	 @BeforeClass
	 
	 public void setup(String br)
	 {
		 ChromeOptions c=new ChromeOptions();
		 c.setAcceptInsecureCerts(true);
		 logger=Logger.getLogger("ebanking");
		 PropertyConfigurator.configure("Log4j.properties");
		 if(br.equalsIgnoreCase("chrome"))
		 {
		   System.setProperty("webdriver.chrome.driver",rc.getchromepath());
		   driver=new ChromeDriver(c);
		   
		 }
		 else if(br.equalsIgnoreCase("firefox"))
		 {
		   System.setProperty("webdriver.gecko.driver",rc.getfirefoxpath());
		   driver=new FirefoxDriver();
		   
		 }
		 driver.get(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		
	 }
	 
	/* @AfterClass
	 public void tearDown()
	 {
		 driver.quit();
	 }*/
	 public void captureScreenshot(WebDriver driver,String tname) throws IOException
	 {
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File src=ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(src, target);
			System.out.println("Screenshot taken");
	 }
	 protected String randomestring() {
		   String emailstring=RandomStringUtils.randomAlphabetic(8);
			return emailstring;
		}
	 private  static String randomeNum() {
		   String emailstring1=RandomStringUtils.randomAlphanumeric(5);
			return emailstring1;
		}
}
