package com.atipune.testng.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FcebookCreatepage {
	WebDriver driver;
	
   @Test
 public void openFBrowser() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\HAMJE SANGAMESH\\Desktop\\Software Testing\\Automation files\\Driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@class='_6ltg']/a")).click();
		Thread.sleep(3000);
		driver.switchTo().activeElement().click();
		
		driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("sangamesh");
		driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("hhaf");
		driver.findElement(By.xpath("//*[@name='reg_email__']")).sendKeys("9573451128");
		driver.findElement(By.xpath("//*[@name='reg_passwd__']")).sendKeys("Asdfgh@123");
		driver.findElement(By.xpath("//*[@name='birthday_day']")).sendKeys("7");
		driver.findElement(By.xpath("//*[@name='birthday_month']")).sendKeys("3");
		driver.findElement(By.xpath("//*[@name='birthday_year']")).sendKeys("1996");
		driver.findElement(By.xpath("//*[@class='_58mt'and text()='Male']")).click();
		driver.findElement(By.xpath("//*[@name='websubmit'and @type='submit']")).click();
		
		System.out.println("Created account succesfully");
		
		
}
}
