package week6.day1.assignments.stepsdefinition;

import io.cucumber.java.en.Then;

public class ViewLeads extends BaseSetup {

	@Then("Verify the lead is created")
	public void verifyTitle() {
		if (driver.getTitle().contains("View Lead")) {
			System.out.println("Success");
		}
	}

}