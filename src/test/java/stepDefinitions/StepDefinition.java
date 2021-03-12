package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class StepDefinition extends Base{
	
	
	LoginPage login;
	
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
	
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		driver.get(arg1);
	}

	@Given("^Click on Login link in home page to land on Secure sign in page$")
	public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage lp =new LandingPage(driver);
		System.out.println("Pop Size is "+lp.getPopUpSize());
		if(lp.getPopUpSize()>0)
		{
			lp.getPopUp().click();
		}
		login= lp.getLogin();
	
	}
	
	
	  @When("^User enters (.+) and (.+) and log in$")
	    public void user_enters_and_and_log_in(String username, String password) throws Throwable {


		  login.getEmail().sendKeys(username); 
		  login.getPassword().sendKeys(password);
		  login.submit().click();
	  
	  }



	@Then("^verify that the user is successfully loged in$")
	public void verify_that_the_user_is_successfully_loged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

	
	}



}
