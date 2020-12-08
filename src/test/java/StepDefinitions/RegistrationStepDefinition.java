package StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Framework.SeleniumKeywords;
import PageObjects.RegistrationPageDWS;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class RegistrationStepDefinition {
	WebDriver driver;
	RegistrationPageDWS register;
	

	@Given("^User is on Demo webshop registration page$")
	public void user_is_on_Demo_webshop_registration_page() throws Throwable {
		driver=SeleniumKeywords.launchbrowser();
	    driver.get("http://demowebshop.tricentis.com/");
	    register = new RegistrationPageDWS(driver);
	    register.registerlink.click()
;	}

	@When("^user enters Gender,valid First name,Valid Last name,valid password and matching confirmPassword$")
	public void user_enters_Gender_valid_First_name_Valid_Last_name_valid_password_and_matching_confirmPassword() throws Throwable {
	    register.setFemale(); Thread.sleep(1000);
	    register.setFirstName("Bhavani"); Thread.sleep(1000);
	    register.setLastName("Devulapalli"); Thread.sleep(1000);
	    register.setEmail("devulapallibhavani161509@gmail.com");Thread.sleep(1000);
	    register.setPassword("Bhavani");Thread.sleep(1000);
	    register.setConfirmPassword("Bhavani");Thread.sleep(1000);
	   
	}

	@Then("^Message displayed Registration Successful$")
	public void message_displayed_Registration_Successful() throws Throwable {
		register.submit();
		Thread.sleep(1000);
		driver.close();
	}

	@Given("^User is on Demo webshop Registration page$")
	public void user_is_on_Demo_webshop_Registration_page() throws Throwable {
		driver=SeleniumKeywords.launchbrowser();
		 driver.get("http://demowebshop.tricentis.com/");
		 register = new RegistrationPageDWS(driver);
		    register.registerlink.click();
	    
	}

	@When("^user leaves first Name blank$")
	public void user_leaves_first_Name_blank() throws Throwable {
		register.setFemale(); Thread.sleep(1000);
	   register.setLastName("Devulapalli"); Thread.sleep(1000);
	    register.setEmail("devulapallibhavani1615@gmail.com");Thread.sleep(1000);
	   register.setPassword("Bhavani");Thread.sleep(1000);
	    register.setConfirmPassword("Bhavani");Thread.sleep(1000);
	    
	    
	}
  
	@When("^clicks the button$")
	public void clicks_the_button() throws Throwable {
		register.submit();
	}

	@Then("^display alert msg$")
	public void display_alert_msg() throws Throwable {
		List<String> msgs=register.textRegistration();
		Thread.sleep(1000);
		msgs.contains("First name is required.");
	    driver.close();
	}

	@When("^user leaves last Name blank$")
	public void user_leaves_last_Name_blank() throws Throwable {
		 register.setFemale(); Thread.sleep(1000);
		 register.setFirstName("Bhavani"); Thread.sleep(1000);
		    //register.setLastName(" "); Thread.sleep(1000);
		    register.setEmail("devulapallibhavani1615@gmail.com");Thread.sleep(1000);
		    register.setPassword("Bhavani");Thread.sleep(1000);
		    register.setConfirmPassword("Bhavani");Thread.sleep(1000);
		    
	}
	@Then("^display alert last name msg$")
	public void display_alert_last_name_msg() throws Throwable {
		List<String> msgs=register.textRegistration();
		Thread.sleep(1000);
		msgs.contains("Last name is required.");
	    driver.close();
	}
	
	

	@When("^user enters invalid email id$")
	public void user_enters_invalid_email_id() throws Throwable {
		 register.setFemale(); Thread.sleep(1000);
		 register.setFirstName("Bhavani"); Thread.sleep(1000);
		    register.setLastName("Devulapalli"); Thread.sleep(1000);
		    register.setEmail("devulapallibhavani1615gmail.com");Thread.sleep(1000);
		    register.setPassword("Bhavani");Thread.sleep(1000);
		    register.setConfirmPassword("Bhavani");Thread.sleep(1000);
		   
		   
	}

	@Then("^display alert invalid email format msg$")
	public void display_alert_invalid_email_format_msg() throws Throwable {
		String msg=register.emailFormat();
		Thread.sleep(1000);
		Assert.assertEquals(msg, "Wrong email");
	    driver.close();
	} 
	
	@When("^user leaves Email id blank$")
	public void user_leaves_Email_id_blank() throws Throwable {
		 register.setFemale(); Thread.sleep(1000);
		    register.setFirstName("Bhavani"); Thread.sleep(1000);
		    register.setLastName("Devulapalli"); Thread.sleep(1000);
		    //register.setEmail(" ");Thread.sleep(1000);
		    register.setPassword("Bhavani");Thread.sleep(1000);
		    register.setConfirmPassword("Bhavani");Thread.sleep(1000);
		 
	}
	
	@Then("^display alert email msg$")
	public void display_alert_email_msg() throws Throwable {
		List<String> msgs=register.textRegistration();
		Thread.sleep(1000);
		msgs.contains("Email is required.");
	    driver.close();
	} 

	@When("^user leaves confirm password blank$")
	public void user_leaves_confirm_password_blank() throws Throwable {
		 register.setFemale(); Thread.sleep(1000);
		    register.setFirstName("Bhavani"); Thread.sleep(1000);
		    register.setLastName("Devulapalli"); Thread.sleep(1000);
		    register.setEmail("devulapallibhavani1615@gmail.com");Thread.sleep(1000);
		   // register.setPassword(" ");Thread.sleep(1000);
		    register.setConfirmPassword("Bhavani");Thread.sleep(1000);
		    
	}
	@Then("^display alert password msg$")
	public void display_password_msg() throws Throwable {
		List<String> msgs=register.textRegistration();
		Thread.sleep(1000);
		msgs.contains("Email is required.");
	    driver.close();
	} 


}
