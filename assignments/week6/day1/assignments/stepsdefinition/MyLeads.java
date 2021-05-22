package week6.day1.assignments.stepsdefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MyLeads extends BaseSetup {

	@And("Click Create Lead Menu")
	public void clickCreateLeadMenu() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@And("Click Find Leads Menu")
	public void clickFindLeadMenu() {
		driver.findElement(By.linkText("Find Leads")).click();

	}

	@When("Click on Merge Leads")
	public void clickMergeLeadsMenu() {
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
	}
}