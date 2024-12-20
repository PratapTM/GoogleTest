package com.google.baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {

	public static WebDriver driver;

	public WebDriver initilaztionDriver() throws IOException {
		String driverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Global.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
//			driver.set(new ChromeDriver(options));

		} else if (browser.equalsIgnoreCase("edge")) {

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		return driver;

	}

	@BeforeSuite
	public void lunchApp() throws IOException {
		driver = initilaztionDriver();
	}

	@AfterSuite
	public void closeApp() {
		driver.quit();
	}

}
