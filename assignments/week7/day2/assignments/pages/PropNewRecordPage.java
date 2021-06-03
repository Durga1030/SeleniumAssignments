package week7.day2.assignments.pages;

import org.openqa.selenium.By;

import week7.day2.assignments.hooks.TestNgHooks;

public class PropNewRecordPage extends TestNgHooks {

	public static String proposalNumber;

	public PropNewRecordPage verifySuccessMessage() {
		switchToFrame(0);
		String recordSelfServiceView = getDriver().findElement(By.xpath("//div[@class='container-fluid']")).getText();
		System.out.println(recordSelfServiceView);
		if (recordSelfServiceView.contains("Proposal")) {
			System.out.println("Login Success");
		}
		return this;

	}

	public PropNewRecordPage getProposalNumber() {
		proposalNumber = getTypedText(locateElement("id", "std_change_proposal.number"));
		System.out.println("Proposal Num: " + proposalNumber);
		return this;
	}

	public PropNewRecordPage assignTemplateDesc(String tempDescVal) {
		clearAndType(locateElement("id", "std_change_proposal.short_description"), tempDescVal);
		return this;
	}

	public PropNewRecordPage clickChangeReqValuesTab() {
		click(locateElement("xpath", "//span[text()='Change Request values']"));
		return this;
	}

	public PropNewRecordPage assignShortDesc(String shortDescVal) {
		clearAndType(locateElement("xpath", "//td[@data-value='Short description']//input[1]"), shortDescVal);
		return this;

	}

	public ProposalSelfService clickOnSubmitButton() throws InterruptedException {
		click(locateElement("id", "sysverb_insert_bottom"));
		return new ProposalSelfService();
	}

}
