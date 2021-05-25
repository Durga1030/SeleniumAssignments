package week6.day2.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import week6.day2.assignments.hooks.TestNgHooks;

public class PropNewRecordPage extends TestNgHooks {

	public static String proposalNumber;

	public PropNewRecordPage verifySuccessMessage() {
		driver.switchTo().frame(0);
		String recordSelfServiceView = driver.findElement(By.xpath("//div[@class='container-fluid']")).getText();
		System.out.println(recordSelfServiceView);
		if (recordSelfServiceView.contains("Proposal")) {
			System.out.println("Login Success");
		}
		return this;

	}

	public PropNewRecordPage getProposalNumber() {
		proposalNumber = driver.findElement(By.id("std_change_proposal.number")).getAttribute("value");
		System.out.println("Number: " + proposalNumber);
		System.out.println(" ");
		return this;
	}

	public PropNewRecordPage assignTemplateDesc(String tempDescVal) {
		driver.findElement(By.id("std_change_proposal.short_description")).sendKeys(tempDescVal);
		return this;

	}

	public PropNewRecordPage clickChangeReqValuesTab() {
		driver.findElement(By.xpath("//span[text()='Change Request values']")).click();
		return this;

	}

	public PropNewRecordPage assignShortDesc(String shortDescVal) {
		WebElement shortDesc = driver.findElement(By.xpath("//td[@data-value='Short description']//input[1]"));
		shortDesc.click();
		shortDesc.clear();
		shortDesc.sendKeys(shortDescVal);
		return this;

	}

	public ProposalSelfService clickOnSubmitButton() throws InterruptedException {
		driver.findElement(By.cssSelector("button#sysverb_insert_bottom")).click();
		Thread.sleep(1000);
		return new ProposalSelfService();
	}

}
