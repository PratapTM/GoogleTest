package com.google.baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {
	
	public static WebDriver driver;
//	public LandingPage landingPage;

	public WebDriver initilaztionDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Global.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		return driver;		

	}
	
	@BeforeMethod(alwaysRun=true)
	public void lunchApp() throws IOException {
		driver=initilaztionDriver();
	}
	
	@BeforeMethod(alwaysRun=true)
	public WebDriver getDriver() throws IOException {
		return driver;
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApp() {
		driver.quit();
	}

}
