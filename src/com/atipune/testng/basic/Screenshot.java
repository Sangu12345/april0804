package com.atipune.testng.basic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class Screenshot zxtends ExtendReportsEx() {
  
  public Screenshot() {
 super();
  }
  public static String getScreenshot(WebDriver driver,String name) throws IOException {
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File source=ts.getScreenshotAs(OutputType.FILE);
	  String destination=System.getProperty("user.dir")+"/screenshots/"+name+System.currentTimeMillis()+".png";
	  File finaldestination =new File(destination);
	  FileUtils.copyFile(source, finaldestination);
	  return destination;
  }
  

