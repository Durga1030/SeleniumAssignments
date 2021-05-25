package week6.day2.assignments.stepsdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ProposalCreationCucumber extends BaseSetup {

	public static String proposalNumber;

	@And("Click New Option for New Proposal")
	public void clickOnNew() {
		driver.findElement(By.cssSelector("button#sysverb_new")).click();
	}

	@And("Get Proposal Number")
	public void getProposalNum() {
		proposalNumber = driver.findElement(By.id("std_change_proposal.number")).getAttribute("value");
		System.out.println("Number: " + proposalNumber);
		System.out.println(" ");
	}

	@And("Assign Template Description as {string}")
	public void assignTemplateDesc(String tempDescVal) {
		driver.findElement(By.id("std_change_proposal.short_description")).sendKeys(tempDescVal);
	}

	@And("Click on Mandatory Field Change Request Values tab")
	public void clickCRValuesTab() {
		driver.findElement(By.xpath("//span[text()='Change Request values']")).click();
	}

	@And("Assign Short Description as {string}")
	public void assignShortDesc(String shortDescVal) {
		WebElement shortDesc = driver.findElement(By.xpath("//td[@data-value='Short description']//input[1]"));
		shortDesc.click();
		shortDesc.clear();
		shortDesc.sendKeys(shortDescVal);
	}

	@And("Click Submit Button")
	public void clickOnSubmitBtn() throws InterruptedException {
		driver.findElement(By.cssSelector("button#sysverb_insert_bottom")).click();
		Thread.sleep(1000);
	}

	@And("Click on Open Proposals Option")
	public void clickOnOpenProposals() {
		driver.findElement(By.xpath("//div[text()='Open Proposals']")).click();
	}

	@Then("Verify Creation Status")

	public void verifyProposalCreationStatus() {

		WebElement searchFilterOption = driver
				.findElement(By.cssSelector("span#std_change_proposal_hide_search>div>div>span>span>select"));
		new Select(searchFilterOption).selectByIndex(1);

		WebElement eleNumber = driver.findElement(By.cssSelector("span#std_change_proposal_hide_search>div>div>input"));
		eleNumber.click();
		eleNumber.sendKeys(proposalNumber);
		eleNumber.sendKeys(Keys.ENTER);

		String resultantNumber = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		/*
		 * System.out.println("Incident Number: " + incidentNumber);
		 * System.out.println("Resultant Number: " + resultantNumber);
		 */
		if (resultantNumber.equalsIgnoreCase(proposalNumber)) {
			System.out.println(resultantNumber + " has been created >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Failed to create new Proposal, Error occurred");
		}
	}
}
