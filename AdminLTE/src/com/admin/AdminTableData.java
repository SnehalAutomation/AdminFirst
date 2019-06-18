package com.admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AdminTableData {
	WebDriver driver= new FirefoxDriver();
	@BeforeSuite
	public void browser_setUp() {
		System.out.println("=====Open Browser=====");
		
		driver.get("file:///E:/Offline%20Website/index.html");
		
	}
	@Test(priority=1)
	public void valid_username_password() {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kiran@gmail.com");
	

	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
	

	driver.findElement(
	By.xpath("//button[contains(text(),'Sign In')]")).click();
	System.out.println("Online");
	System.out.println("..................................");
	}
	
	@Test(priority=2)
	public void Click_On_Users() {
		driver.findElement(By.xpath(" //a[@href='users.html']")).click();
		
	}
	@Test(priority= 3)
	public void get_TableData() {
		WebElement table= driver.findElement(By.xpath("//table[@class='table table-hover']"));
		
		List<WebElement> tr=table.findElements(By.tagName("tr"));
		System.out.println("Number of rows : " +tr.size());
		
		for(WebElement row : tr) {
			List<WebElement> td=table.findElements(By.tagName("td"));
			System.out.println("Number of rows : " +td.size());
			for(WebElement col : td) {
				System.out.println(col.getText());
				
			}
			System.out.println("****************");
			
		}
	}
	@Test(priority=4)
	public void log_out() {
		driver.findElement(By.xpath(" //a[@href='logout.html']")).click();
	}
	
	
}
