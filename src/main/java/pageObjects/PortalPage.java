package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalPage {
	
	public WebDriver driver;

	private By searchbox = By.name("query");
	
	public PortalPage(WebDriver driver) {

		this.driver = driver;
	}
	
	public WebElement getSearchBox()

	{

		return driver.findElement(searchbox);
	}

}
