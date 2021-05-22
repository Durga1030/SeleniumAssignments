package week6.day1.assignments.stepsdefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;

public class MergeLeadCucumber extends BaseSetup {

	String fromId, toId;

	@And("Assign FromLead Value using Lookup")
	public void getFromLeadValue() {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click(); // Lookup
	}

	@And("Assign firstName in FindLead Popup as (.*)$")
	public void getfirstNameFromLead(String fName1) {
		driver.findElement(By.name("firstName")).sendKeys(fName1);
	}

	@And("Assign ToLead Value using Lookup")
	public void getToLeadValue() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click(); // Lookup
	}

	@And("Assign firstName in ToLead Popup as (.*)$")
	public void getfirstNameToLead(String fName2) {
		driver.findElement(By.name("firstName")).sendKeys(fName2);
	}

	@And("Click on Merge Button")
	public void clickOnMergeButon() {
		driver.findElement(By.linkText("Merge")).click();
	}

	@And("Get the IdNum of the Selected FromLead")
	public void getFromLeadId() {
		fromId = driver.findElement(By.id("ComboBox_partyIdFrom")).getAttribute("value");
		System.out.println("From Id: " + fromId);
	}

	@And("Get the IdNum of the Selected ToLead")
	public void getToLeadId() {
		toId = driver.findElement(By.id("ComboBox_partyIdTo")).getAttribute("value");
		System.out.println("To Id: " + toId);
	}

	@And("Verify the Merge Result")
	public void verifyMergeStatus() throws InterruptedException {

		// Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(fromId);

		// Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		// Verify message "No records to display" in the Lead List. This message
		// confirms the successful deletion
		boolean status = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();

		if (status) {
			System.out.println(fromId + " has been merged with " + toId + " >> test case passed");
			driver.quit();
		} else {
			System.err.println("Merge step failed");
		}

	}

}
