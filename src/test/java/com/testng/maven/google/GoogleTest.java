package com.testng.maven.google;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.google.baseTest.BaseTestClass;

public class GoogleTest extends BaseTestClass {
	
	
//	GoogleHomePage gHomePage = new GoogleHomePage(driver);

	@Test
	public void ExecuteGoogleSearch() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("Search for any text");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}
}
