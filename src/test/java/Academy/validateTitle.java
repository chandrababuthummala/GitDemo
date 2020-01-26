package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	LandingPage lp;


	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}

	@Test
	public void titleValidation() throws IOException {
		lp = new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		//log.info("Successfully validated title message");
	}

	@Test
	public void headerValidation() throws IOException {
		lp = new LandingPage(driver);
		Assert.assertEquals(lp.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		//log.info("Successfully validated header");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}

}
