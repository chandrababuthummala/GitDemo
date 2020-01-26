package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalPage;
import resources.base;

public class stepDefinition extends base {

	@Given("^Initialize browser with chrome$")
	public void initialize_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
	}

	@And("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);
	}

	@When("^Click on Login link in home page to land on sign in page$")
	public void click_on_login_link_in_home_page_to_land_on_sign_in_page() throws Throwable {

		LandingPage lp = new LandingPage(driver);
		if(lp.getPopupSize()>0)
		{
			lp.getPopup().click();
		}
		lp.getLogin().click();

	}

	
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_something_and_something(String strArg1, String strArg2) throws Throwable {

		LoginPage lg = new LoginPage(driver);
		lg.getEmail().sendKeys(strArg1);
		lg.getPassword().sendKeys(strArg2);
		lg.getLogin().click();
	}

	 @When("^User enters (.+) and (.+)$")
	    public void user_enters_and(String username, String password) throws Throwable {
		 LoginPage lg = new LoginPage(driver);
			lg.getEmail().sendKeys(username);
			lg.getPassword().sendKeys(password);
			lg.getLogin().click();
	    }

	@Then("^Verify user logged in succesfully$")
	public void verify_user_logged_in_succesfully() throws Throwable {

		PortalPage p = new PortalPage(driver);

		Assert.assertTrue(p.getSearchBox().isDisplayed());
	}
	
	 @And("^Close the browser$")
	    public void close_the_browser() throws Throwable {
	        driver.close();
	        driver=null;
	    }

}
