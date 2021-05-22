package week6.day1.assignments.stepsdefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;

public class DuplicateLeadCucumber extends BaseSetup {

	String firstName;

	@And("Capture First resulting Lead Name")
	public void getFirstName() {

		firstName = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])/a"))
				.getText();
		System.out.println("First Resulting lead: " + firstName);
	}

	@And("Click Duplicate Lead Button")
	public void clickDuplicateLead() {
		driver.findElement(By.xpath("(//a[text()='Duplicate Lead'])")).click();
	}

	@And("Verify the title as Duplicate Lead")
	public void verifyTitle() {
		String getTitle = driver.findElement(By.xpath("(//div[@id='sectionHeaderTitle_leads'])")).getText();
		if (getTitle.equalsIgnoreCase("Duplicate Lead")) {
			System.out.println("Title verification success");
		} else {
			System.out.println("Incorrect Title. Have a check on it");
		}

	}

	@And("Click on CreateLead Button")
	public void clickCreateLeads() {
		driver.findElement(By.className("smallSubmit")).click();
	}

	@And("Verify the Duplicated LeadName is as same as Captured LeadName")

	public void verifyDupesCreation() {
		String duplicatedFname = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		// System.out.println(duplicatedFname);

		if (firstName.equalsIgnoreCase(duplicatedFname)) {
			System.out.println("Duplicated lead name: " + firstName + "is same as captured name: " + duplicatedFname
					+ " test case passed >> Closing window");
			driver.quit();
		} else {
			System.err.println("Name not matched !! Have a check on it");
		}

	}

}
