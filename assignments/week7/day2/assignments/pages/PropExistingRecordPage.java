package week7.day2.assignments.pages;

import org.openqa.selenium.By;

import week7.day2.assignments.hooks.TestNgHooks;

public class PropExistingRecordPage extends TestNgHooks {

	public PropExistingRecordPage selectProposalState() {
		selectDropDownUsingIndex(locateElement("id", "std_change_proposal.state"), 3);
		System.out.println("Updated proposal state value");
		return this;
	}

	public CategoryServiceNow clickOnCategoryLookup() {
//Lookup-using
		clickWithNoSnap(locateElement("lookup.std_change_proposal.category"));
		// getDriver().findElement(By.id("lookup.std_change_proposal.category")).click();
		switchToWindow(1);
		return new CategoryServiceNow();
	}

	public ServiceNowGrpHierarchy clickOnAssignmentGrpLookup() {
		// Lookup-using
		// click(locateElement("xpath", "//td[@data-value='Assignment
		// group']//button[1]"));
		getDriver().findElement(By.xpath("//td[@data-value='Assignment group']//button[1]")).click();
		switchToWindow(1);
		return new ServiceNowGrpHierarchy();
	}

	public PropExistingRecordPage clickOnCRValuesTab() throws InterruptedException {
		click(locateElement("xpath", "//span[text()='Change Request values']"));
		return this;
	}

	// @And("Enter Justification field value as {string}")
	public PropExistingRecordPage enterJustifiction(String justificationVal) {
		click(locateElement("xpath", "//td[@data-value='Justification']//textarea[1]"));
		clearAndType(locateElement("xpath", "//td[@data-value='Justification']//textarea[1]"), justificationVal);
		return this;
	}

	public PropExistingRecordPage enterRiskImpact(String rickImpactVal) {
		click(locateElement("xpath", "//td[@data-value='Risk and impact analysis']//textarea[1]"));
		clearAndType(locateElement("xpath", "//td[@data-value='Risk and impact analysis']//textarea[1]"),
				rickImpactVal);
		return this;
	}

	public PropExistingRecordPage enterTemplateName(String templateDesc) {
		// driver.findElement(By.id("std_change_proposal.template_name")).sendKeys("values
		// to send");
		clearAndType(locateElement("id", "std_change_proposal.template_name"), templateDesc);
		return this;
	}

	public PropExistingRecordPage enterTemplateDescription(String templateDesc) {
		click(locateElement("id", "std_change_proposal.short_description"));
		clearAndType(locateElement("id", "std_change_proposal.short_description"), templateDesc);
		return this;
	}

	public ProposalSelfService clickOnUpdateButton() throws InterruptedException {
		click(locateElement("sysverb_update"));
		Thread.sleep(500);
		return new ProposalSelfService();
	}

}
