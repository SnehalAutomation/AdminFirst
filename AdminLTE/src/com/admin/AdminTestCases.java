package com.admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AdminTestCases {
	WebDriver driver= new FirefoxDriver();
	@BeforeSuite
	public void browser_setUp() {
		System.out.println("=====Open Browser=====");
		
		driver.get("file:///E:/Offline%20Website/index.html");
		
	}
	@Test(priority =1)
	public void verify_URL() {
		// Actual url
		String my_url= driver.getCurrentUrl();
		System.out.println("Page URL is :-" +my_url);
		
		// Expected url
		
		String Expected_URL= "file:///E:/Offline%20Website/index.html";
		Assert.assertEquals(my_url, Expected_URL);
		
		System.out.println("Test case 1 with Thread ID :" +Thread.currentThread().getId());
	}
	@Test(priority= 2)
	public void verify_TitleApplication() {
		// actual title
		String Actual_title= driver.getTitle();
		System.out.println("Page  Title is :-"+Actual_title);
		// Expected Title is
		String Expected_title ="AdminLTE 2 | Log in";
		Assert.assertEquals(Actual_title, Expected_title);
		
		System.out.println("Test case 2 with Thread ID :" +Thread.currentThread().getId());
	}
	
	@Test(priority= 4)

	// start login session
	public void login_session() {
		driver.findElement(By.xpath("//p[contains(text(),'Sign in to start your session')]"));
		System.out.println("Sign in to start your session");
		System.out.println("=====================");
	}
	
	@Test(priority=5)
	public void Check_PlaceHolder_Username() {
		String str= driver.findElement(By.xpath("//input[@id='email']")).getAttribute("placeholder");
	
		String expected= "Email";
		Assert.assertEquals(str, expected);
		System.out.println("placeholder email_varified");
		System.out.println("***************");
		
	}@Test(priority=6)
	public void Check_Placeholder_Password() {
		String pass= driver.findElement(By.xpath("//input[@id='password']")).getAttribute("placeholder");
	String expected="Password";
	Assert.assertEquals(pass, expected);
	System.out.println("placeholder password_varified");
	System.out.println("*******************");
	}
	@Test(priority=7)
	public void Check_Button_color() {
		WebElement signIn= driver.findElement(By.xpath(" //button[contains(text(),'Sign In')]"));
	System.out.println("Before mouse hover button color is : " +signIn.getCssValue("background-color"));
	Actions act= new Actions(driver);
	act.moveToElement(signIn).build().perform();
	System.out.println("After mouse hover button color is : "+signIn.getCssValue("color") );
	System.out.println("***************************");
	
	
	
	}
	@Test(priority=8)
	public void check_Links() {
		
		List<WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		System.out.println("----------------------");
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getText());
			
		}
		
	}
	@Test(priority=9)
	public void Blank_UserName_Password() {
		
		WebElement uname_act = driver.findElement(By.xpath("//input[@id='email']"));
		uname_act.sendKeys("");
		String uname_exp="abcccc";
		Assert.assertNotEquals(uname_act, uname_exp);
		
		
		WebElement pass_act= driver.findElement(By.xpath("//input[@id='password']"));
		pass_act.sendKeys("");
		String pass_exp="abccc";
		
		driver.findElement(By.xpath(" //button[contains(text(),'Sign In')] ")).click();
		Assert.assertNotEquals(pass_act, pass_exp);
		
		
		String Uname= driver.findElement(By.xpath(".//*[@id='email_error']")).getText();
		System.out.println(Uname);
		
		String Pwd=driver.findElement(By.xpath(".//*[@id='password_error']")).getText();
		System.out.println(Pwd);
		System.out.println("===============");
	}
	
	
	@Test(priority=10)
	public void valid_username_password() {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kiran@gmail.com");
	

	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
	

	driver.findElement(
	By.xpath("//button[contains(text(),'Sign In')]")).click();
	System.out.println("Online");
	System.out.println("..................................");
	}
		
	
	
	
}






















