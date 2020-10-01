package com.GuruBankingRealProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  WebDriver driver;
  public LoginPage(WebDriver rdriver)
  {
	  driver=rdriver;
	  PageFactory.initElements(rdriver, this);
  }
  @FindBy(name="uid")
  @CacheLookup
  WebElement txtusername;
  @FindBy(name="password")
  @CacheLookup
  WebElement txtpassword; 
  @FindBy(name="btnLogin")
  @CacheLookup
  WebElement btnLogin;
  @FindBy(linkText="Log out")
  @CacheLookup
  WebElement btnLogout;
  public void setusername(String uname)
  {
	  txtusername.sendKeys(uname);
  }
  public void setpassword(String password)
  {
	  txtpassword.sendKeys(password);
  }
  public void clickSubmit()
  {
	  btnLogin.click();
  }
public void clickLogout() {
	
	btnLogout.click();
}
}
