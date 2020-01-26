package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public static Logger log= LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		
		
	}

	@Test(dataProvider = "getData")

	public void basePageNavigation(String Username, String Password) throws IOException

	{
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();

		LoginPage lg = new LoginPage(driver);
		lg.getEmail().sendKeys(Username);
		lg.getPassword().sendKeys(Password);
		//System.out.println(text);
		lg.getLogin().click();

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "restricted@qa.com";
		data[0][1] = "1234";
		//data[0][2] = "Restricted User";

		data[1][0] = "nonrestricted@qa.com";
		data[1][1] = "1234";
		//data[1][2] = "NonRestricted User";

		return data;

	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
	}

}
