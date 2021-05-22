package week6.day1.assignments.stepsdefinition;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;

public class FindLeads extends BaseSetup {

	@And("Click Email Tab")
	public void clickPhoneTab() {
		driver.findElementByXPath("//span[text()='Email']").click();
	}

	@And("Type Email Id as (.*)$")
	public void typePhoneNumber(String emailId) {
		driver.findElementByName("emailAddress").sendKeys(emailId);
	}

	@And("Click Find Leads Button")
	public void clickFindLeads() throws InterruptedException {
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(1000);
	}

	@And("Click First Matching Result")
	public void clickFirstMatchingResult() throws InterruptedException {
		Thread.sleep(2000);
		WebElement firstResult = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a");
		firstResult.click();
	}

}