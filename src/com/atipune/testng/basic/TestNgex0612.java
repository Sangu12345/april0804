package com.atipune.testng.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgex0612 {
	WebDriver driver;
  @Test
  public void openBrowser() {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\HAMJE SANGAMESH\\Desktop\\Software Testing\\Automation files\\Driver\\chromedriver.exe");
			 driver=new ChromeDriver();
			driver.get("http://practice.automationtesting.in/");
			driver.manage().window().maximize();
			} 

  @Test(priority=1)
  public void verifyUserName() {
	  driver.findElement(By.xpath("//*[@id='menu-item-50']/a")).click();
	  driver.findElement(By.xpath("//*[@id='username' and @name='username']")).sendKeys("ancd@gmail.com");
	  driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Empl@1129@");
	  driver.findElement(By.xpath("//*[@name='login' and @type='submit']")).click();
	  String expectedUserName="Hello ancd (not ancd? Sign out)";
	  String actualUserName=driver.findElement(By.xpath("woocommerce-MyAccount-content")).getText();
	  Assert.assertEquals(actualUserName, expectedUserName);
	  }
  @Test(priority=2)
  public void VerifyIncorrectData()
   {
	  driver.findElement(By.xpath("//*[@id='username' and @name='username']")).sendKeys("ancd@gmail.com");
	  driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Empl@1129@");
	  driver.findElement(By.xpath("//*[@name='login' and @type='submit']")).click();
	  String expectedIncorrectData="ERROR: The password you entered for the username ancd@gmail.com is incorrect";
	  String actualIncorrectData=driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li")).getText();
	  Assert.assertEquals(actualIncorrectData, expectedIncorrectData);
	  
	  
  }
 
  
  }

