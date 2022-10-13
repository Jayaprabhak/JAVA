package com.simplilearn.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class mAadharTest {
WebDriver driver;
	

	//Check whether different browsers and screen resolutions render it the same way 
	@Test(groups = "Chrome")
	//Chrome Browser

	public void launchChrome() {
		boolean chromeLaunched = false;
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("http://localhost:63931/");
		
			Thread.sleep(3000);
			chromeLaunched = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			chromeLaunched = false;
			e.printStackTrace();
		}
		
		if(chromeLaunched) {
			System.out.println("Chrome Launched Successfully");
		}
		else {
			System.out.println("Chrome Launched Unsuccessfully");

		}
	}
	
	
	}