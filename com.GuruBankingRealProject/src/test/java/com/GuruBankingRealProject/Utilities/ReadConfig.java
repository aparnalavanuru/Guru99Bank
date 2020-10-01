package com.GuruBankingRealProject.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
   Properties pro;
   public ReadConfig()
   {
	   File src=new File("C:\\Users\\Amar\\eclipse-workspace\\com.GuruBankingRealProject\\Configuration\\config.properties");
	   try {
		   FileInputStream fis=new FileInputStream(src);
		   pro=new Properties();
		   pro.load(fis);
		   
	   }
	   catch(Exception e)
	   {
		   System.out.print(e.getMessage());
	   }
   }
   public String getUrl()
   {
	 String urlpath=pro.getProperty("url");
	 return urlpath;
	   
   }
   public String getusername()
   {
	 String uname=pro.getProperty("username");
	 return uname;
	   
   }
   public String getpassword()
   {
	 String password=pro.getProperty("password");
	 return password; 
   }
   public String getchromepath()
   {
	 String chropath=pro.getProperty("chrome");
	 return chropath;
	   
   }
   public String getfirefoxpath()
   {
	 String firefoxpath=pro.getProperty("firefox");
	 return firefoxpath;
	   
   }
}
