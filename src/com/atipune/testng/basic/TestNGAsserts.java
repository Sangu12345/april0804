package com.atipune.testng.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAsserts {
	WebDriver driver;
  @BeforeTest
  public void OpenBrowser() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\HAMJE SANGAMESH\\Desktop\\Software Testing\\Automation files\\Driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("http://practice.automationtesting.in/");
		driver.manage().window().maximize();
		}
  @Test
   public void verifyHomepageTitle() {
	  String expectedTitle="Automation Practice Site ";
	  String actualTitle=driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
	  
 }
  /*@Test
  public void newArrivals() {

boolean actualTitle=driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-1-1-0']")).isDisplayed();
	 Assert.assertTrue(actualTitle);
	  
  }
 
   @Test
  public void verifyFirstBookTitle() {
	  String expectedTitleBook="Selenium Ruby";
	  String actualTitleBook=driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-0-0']")).getText();
	  Assert.assertEquals(actualTitleBook, expectedTitleBook);
			  }
   @Test
   public void verifyFirstBookTitle1() {
 	  String expectedTitleBook1="Thinking in HTML";
 	  String actualTitleBook1=driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-1-0\"]")).getText();
 	  Assert.assertEquals(actualTitleBook1, expectedTitleBook1);
   }
   @Test
   public void verifyFirstBookTitle2() {
 	  String expectedTitleBook2="Mastering JavaScript";
 	  String actualTitleBook2=driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-1-0\"]")).getText();
 	  Assert.assertEquals(actualTitleBook2, expectedTitleBook2);
   }
 	
   @AfterMethod
   public void closebrowser() {
	   driver.quit();*/
   }
	  
  
//}
