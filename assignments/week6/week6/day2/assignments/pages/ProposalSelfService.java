package week6.day2.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import week6.day2.assignments.hooks.TestNgHooks;

public class ProposalSelfService extends TestNgHooks {

	public ProposalSelfService verifySuccessMessage() {
		driver.switchTo().frame(0);
		String selfServiceView = driver.findElement(By.cssSelector("div#list_nav_std_change_proposal>div>div>h1>a"))
				.getText();

		if (selfServiceView.contains("Proposals")) {
			System.out.println("Login Success");
		}
		return this;

	}

	public PropNewRecordPage clickNewButton() throws InterruptedException {
		driver.switchTo().frame(0);
		driver.findElement(By.id("sysverb_new")).click();
		return new PropNewRecordPage();
	}

	public ProposalSelfService clickOnOpenProposals() {
		driver.findElement(By.xpath("//div[text()='Open Proposals']")).click();
		return this;
	}

	public ProposalSelfService clickOnMyProposals() {
		driver.findElement(By.xpath("//div[text()='My Proposals']")).click();
		return this;
	}

	public ProposalSelfService verifyCreatedProposal() throws InterruptedException {

		WebElement searchFilterOption = driver
				.findElement(By.cssSelector("span#std_change_proposal_hide_search>div>div>span>span>select"));
		new Select(searchFilterOption).selectByIndex(1);

		WebElement eleNumber = driver.findElement(By.cssSelector("span#std_change_proposal_hide_search>div>div>input"));
		eleNumber.click();
		eleNumber.sendKeys(PropNewRecordPage.proposalNumber);
		eleNumber.sendKeys(Keys.ENTER);

		String resultantNumber = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		/*
		 * System.out.println("Incident Number: " + incidentNumber);
		 * System.out.println("Resultant Number: " + resultantNumber);
		 */
		if (resultantNumber.equalsIgnoreCase(PropNewRecordPage.proposalNumber)) {
			System.out.println(resultantNumber + " has been created >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Failed to create new Proposal, Error occurred");
		}
		return this;
	}
}
