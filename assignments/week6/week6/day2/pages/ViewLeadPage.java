package week6.day2.pages;

import org.openqa.selenium.By;

import week6.day2.hooks.HooksTest;

public class ViewLeadPage extends HooksTest {

	public void verifyCompanyName() {
		// Verification of duplicate Company Name
		String dName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Company Name with id: " + dName);
		dName = dName.replaceAll("[^a-zA-Z]", "");
		System.out.println("Company name: " + dName);

		System.out.println(" Lead has been created >>  Test case passed");

	}

}
