package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class base {

	//public WebDriver driver; will run all scenarios parallely
	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException

	{

		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
      String browserName = prop.getProperty("browser");
//maven test -Dbrowser=chrome
     	//String browserName=System.getProperty("browser");
		if (browserName.contains("chrome")) {
// execute in chromeheadless driver

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox"))

		{
			// execute in firefox driver
		}

		else if (browserName.contentEquals("ie")) {
			// execute in ie browser

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void getScreenshot(String result) throws IOException {
		File Src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileHandler.copy(Src, new File("C://Test" + result + "screenshot.png"));

	}

}
