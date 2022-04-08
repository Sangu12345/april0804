package com.atipune.testng.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;


public class TestAssertEx2 {
	  WebDriver driver;
  @BeforeTest
  public void OpenBrowser() {
	
	 
	 
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\HAMJE SANGAMESH\\Desktop\\Software Testing\\Automation files\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://practice.automationtesting.in");
			driver.manage().window().maximize();
  }
 public void shopMenu() {
	 driver.quit();
	 
 }
}
