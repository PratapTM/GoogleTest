package maven.google.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.baseTest.BaseTestClass;

public class GoogleHomePage extends BaseTestClass {

	WebDriver driver;

	public GoogleHomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	WebElement search_intput;

	public void searchGoogle(String textToSearch) {
		search_intput.sendKeys(textToSearch);
	}

}
