package com.atipune.testng.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGpr0512 {
	WebDriver driver;

	
  @Test
  public void openBrowser() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\HAMJE SANGAMESH\\Desktop\\Software Testing\\Automation files\\Driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("http://practice.automationtesting.in/");
		driver.manage().window().maximize();
		} 
  @Test
  public void varifyHomePage() {
	  String expectedHomePage="Automation Practice Site";
	  String actualHomePage=driver.getTitle();
	  Assert.assertEquals(actualHomePage, expectedHomePage);
	
	  
  }
  @Test
  public void varifyNewArrivalsDisplayed() {
	  boolean actualNewArrivalsDisplayed=driver.findElement(By.xpath("//*[text()='new arrivals']")).isDisplayed();
	  Assert.assertTrue(actualNewArrivalsDisplayed);
	  
  }
  @Test
  public void varifyFirstBookTitle() {
	  String expectedFirstBookTitle="Selenium Ruby";
	  String actualFirstBookTitle=driver.findElement(By.xpath("//*[@class='module-text text-22-sub_row_1-0-2-0-0 ' or text()='Selenium Ruby']")).getText();
			  
	  Assert.assertEquals(actualFirstBookTitle, expectedFirstBookTitle);
  
  
 
  }
  @Test
  public void varifySecondBookTitle() {
	  String expectedSecondBookTitle="Thinking in HTML";
	  String actualSecondBookTitle=driver.findElement(By.xpath("//*[@class='module-text text-22-sub_row_1-0-2-0-0 ' or text()='Thinking in HTML']")).getText();
			  
	  Assert.assertEquals(actualSecondBookTitle, expectedSecondBookTitle);
  
  
 
  }
  @Test
  public void varifyThirdBookTitle() {
	  String expectedThirdBookTitle="Mastering JavaScript";
	  String actualThirdBookTitle=driver.findElement(By.xpath("//*[@text='Mastering JavaScript']")).getText();
			  
	  Assert.assertEquals(actualThirdBookTitle, expectedThirdBookTitle);
  
  
 
  }
}

 
 

