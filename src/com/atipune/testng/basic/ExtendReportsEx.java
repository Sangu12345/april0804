package com.atipune.testng.basic;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportsEx {
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
  @BeforeTest
  public void setUpExtentEnv() {
	  htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/extent-report.html");
	  htmlreporter.config().setDocumentTitle("Automation Report");
	  htmlreporter.config().setReportName("functional report");
	  htmlreporter.config().setTheme(Theme.DARK);
	  extent=new ExtentReports();
	  extent.attachReporter(htmlreporter);
	  extent.setSystemInfo("HOST NAME", "LOCAL HOST");
	  extent.setSystemInfo("OS", "WINDOWS 10");
	  extent.setSystemInfo("TESTER NAME", "SANGAMESH");
	  extent.setSystemInfo("Browser", "Chrome");
  }
	 
 @AfterTest
	  public void cleanup() 
 {
	extent.flush();	  
  }
 @BeforeMethod
 public void register(Method method) {
	 String testname=method.getName();
	 test=extent.createTest(testname);
	 
 }
@BeforeClass
public void openBrowser()
{
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
@AfterMethod
public void tearDown(ITestResult result) throws IOException{
	if(result.getStatus()==ITestResult.FAILURE) {
		test.log(Status.FAIL,"TEST CASE FAILED IS"+result.getName());
		test.log(Status.FAIL, "TEST CASE FAILED IS"+result.getThrowable());
		String screenshotpath=Screenshot.getScreenshot(driver, result.getName());
		test.addScreenCaptureFromPath(screenshotpath);
		}
	else if(result.getStatus()==ITestResult.SKIP)
	{
		test.log(Status.SKIP, "TEST CASE SKIPPED: "+result.getName());
		test.log(Status.SKIP, "TEST CASE FAILED:"+result.getName());
		
	}
	else if(result.getStatus()==ITestResult.SUCCESS) {
		test.log(Status.PASS, "TEST CASE PASSED:"+result.getName());
	}
	
}
@AfterSuite
public void browseTeardown() {
	driver.quit();
}
	  
}

