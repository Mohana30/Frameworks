package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	@Given("^User is on Netbanking landing page$")
	public void user_is_on_netbanking_landing_page() {
		System.out.println("Gven");
		// throw new PendingException();
	}

	@When("^User login into application with username and password$")
	public void user_login_into_application_with_username_and_password() {
		System.out.println("Gven");

	}

	@Then("^Home page is populated$")
	public void home_page_is_populated() {
		System.out.println("Gven");
		// throw new PendingException();
	}

	@And("^Cards are displayed$")
	public void cards_are_displayed() {
		System.out.println("Gven");
		// throw new PendingException();
	}

}