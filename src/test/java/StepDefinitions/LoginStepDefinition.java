package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Framework.SeleniumKeywords;
import PageObjects.LoginPageDWS;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginStepDefinition {
	
	WebDriver driver;
	LoginPageDWS login;
	
	@Given("^User is on Demo webshop Login page$")
	public void user_is_on_Demo_webshop_Login_page() throws Throwable {
		driver=SeleniumKeywords.launchbrowser();
		driver.get("http://demowebshop.tricentis.com/");
		login = new LoginPageDWS(driver);
		login.clickLogin();
	}

	@When("^user enters the valid email and password$")
	public void user_enters_the_valid_email_and_password() throws Throwable {
		login.setEmail("devulapallibhavani1509@gmail.com"); Thread.sleep(1000);
		login.setPassword("Bhavani"); Thread.sleep(1000);
	    
	}

	@When("^clicks the login button$")
	public void clicks_the_button() throws Throwable {
		login.submit();Thread.sleep(3000);
	    
	}

	@Then("^user is navigated to home page$")
	public void user_is_navigated_to_home_page() throws Throwable {
		driver.navigate().to("http://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.close();

	}

	@When("^user enters the valid email and invalid password$")
	public void user_enters_the_valid_email_and_invalid_password() throws Throwable {
		login.setEmail("devulapallibhavani1509@gmail.com"); Thread.sleep(1000);
		login.setPassword("bhavani"); Thread.sleep(1000);
	}

	@Then("^display alert message$")
	public void display_alert_message() throws Throwable {
		String alertMessage = login.textMessage();
		Thread.sleep(1000);
		 Assert.assertEquals("Login was unsuccessful. Please correct the errors and try again.",alertMessage);	
	    
	    driver.close();
	}

	@When("^user enters the invlid email and password$")
	public void user_enters_the_invlid_email_and_password() throws Throwable {
		login.setEmail("devulapalli@gmail.com"); Thread.sleep(1000);
		login.setPassword("bhavani"); Thread.sleep(1000);
	}

	@When("^user enters the invlid email and valid password$")
	public void user_enters_the_invlid_email_and_valid_password() throws Throwable {
		login.setEmail("devulapalli@gmail.com"); Thread.sleep(1000);
		login.setPassword("Bhavani"); Thread.sleep(1000);
	}


}
