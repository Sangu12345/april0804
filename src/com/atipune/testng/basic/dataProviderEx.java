package com.atipune.testng.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderEx {
	
 
  public static WebDriver driver;
  public static WebElement weUserName,weUserPass,weConfirmPass,wePreLang,weEngLang, weSecQuec,weSecQue,weSelAns,weSecnsSel,weSecAnsin;
  
  @BeforeClass
  public void openBrowser() {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\HAMJE SANGAMESH\\Desktop\\Software Testing\\Automation files\\Driver\\chromedriver.exe");
			 driver=new ChromeDriver();
			driver.get("https://www.irctc.co.in/nget/profile/user-registration");
			driver.manage().window().maximize();
			WebElement okButton=driver.findElement(By.xpath("//button[text()='OK']"));
			if(okButton.isDisplayed()) {
				okButton.click();
			}
  }
		
  @Test(dataProvider="login-data")
  public void loginform(String tcid,String tcdesc,String Uname,String pass,String conpass,String secansin) throws InterruptedException {
	 System.out.println("Test Case id:"+tcid); 
	 System.out.println("Test Case desc:"+tcdesc); 
	 weUserName=driver.findElement(By.xpath("//*[@id='userName']"));
	 
	 weUserName.clear();
	 weUserName.sendKeys(Uname);
	 weUserPass=driver.findElement(By.xpath("//*[@id=\"usrPwd\"]"));
	 weUserPass.clear();
	 weUserPass.sendKeys(pass);
	 Thread.sleep(2000);
	 weConfirmPass=driver.findElement(By.xpath("//*[@id=\"cnfUsrPwd\"]"));
	 weConfirmPass.clear();
	 weConfirmPass.sendKeys(pass);
	 Thread.sleep(2000);
	 wePreLang=driver.findElement(By.xpath("//*[@class='ng-tns-c66-7 ui-dropdown ui-widget ui-state-default ui-corner-all']"));
	 wePreLang.click();
	 weEngLang=driver.findElement(By.xpath("//*[text()='English']"));
	 weEngLang.click();
	 weSecQuec=driver.findElement(By.xpath("//*[@class='ng-tns-c66-8 ui-dropdown ui-widget ui-state-default ui-corner-all']"));
	 weSecQuec.click();
	 weSecQue=driver.findElement(By.xpath("//*[@class='ng-star-inserted' and text()='What is your pet name?']"));
	 weSecQue.click();
	 weSelAns=driver.findElement(By.xpath("//*[@class='ui-dropdown-item ui-corner-all ui-state-highlight']"));
	 weSelAns.click();
  
	 weSecAnsin=driver.findElement(By.xpath("//*[@placeholder='Security Answer' ]"));
	 weSecAnsin.clear();
	 weSecAnsin.sendKeys(secansin);
	 Thread.sleep(2000);
	 if ("TC01".equalsIgnoreCase(tcid)) {
		 String expected="User Name is required.";
		 String actual=driver.findElement(By.xpath("//*[text()='User Name is required.']")).getText();
		 Assert.assertEquals(actual, expected);
	 }
	 else if("Tc02".equalsIgnoreCase(tcid))
	 {
		 String expected="Password is invalid.Min 8 character & Max 15 character. Password must contain at least one small & one capital alphabet and numeric digit.";
		 String actual=driver.findElement(By.xpath("//*[text()='Password is invalid.Min 8 character & Max 15 character. Password must contain at least one small & one capital alphabet and numeric digit.']")).getText();
		 Assert.assertEquals(actual, expected);
	 }
	 else if("Tc03".equalsIgnoreCase(tcid)) {
		 String expected="Password and Confirm password not Matched.";
		 String actual=driver.findElement(By.xpath("//*[text()='Password and Confirm password not Matched.']")).getText();
		 Assert.assertEquals(actual, expected);
	}
	 else if("Tc04".equalsIgnoreCase(tcid)) {
		 String expected="Security Answer is Required.";
		 String actual=driver.findElement(By.xpath("//*[text()='Security Answer is Required.']")).getText();
		 Assert.assertEquals(actual, expected);
	 }
	
	
	 
  }
  @DataProvider(name="login-data")
public Object[][]loginData(){
	return new Object[][] {
		new Object[] {"TC01","USERNAME BLANK ","","Atipune@123","Atipune@123","Ati"},
		new Object[] {"TC02","USERPASS BLANK","Atipune55012","","Atipune@123","Ati",},
		new Object[] {"TC03","CONPASS BLANK","Atipune55012","Atipune@123","","Ati",},
		new Object[] {"Tc04","PET NAME BLANK","Atipune55012","Atipune@123","Atipune@123","",},
		new Object[] {"Tc05","USERNAME & PASS BLANK","Atipune55012","","","Ati",},
		new Object[] {"Tc06","allfilled","Atipune55012","Atipune@123","Atipune@123","Ati",},};
		
		
		
		
		
	}
  @AfterClass
 public void closeBrowswer() {
	 driver.quit();
 }
  }
	

  
