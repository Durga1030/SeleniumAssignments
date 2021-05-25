package week6.day2.assignments.stepsdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;

public class UpdateProposalCucumber extends BaseSetup {

	@And("Click On My Proposals Option")
	public void clickOnMyProposals() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='My Proposals']")).click();
		Thread.sleep(1000);
	}

	@And("Search Existing Proposal using Proposal Number as (.*)$")
	public void searchExistingProposal(String proposalNum) {
		WebElement searchNumOpton = driver
				.findElement(By.cssSelector("span#std_change_proposal_hide_search>div>div>span>span>select"));
		new Select(searchNumOpton).selectByIndex(1);

		WebElement eleNumber = driver.findElement(By.cssSelector("span#std_change_proposal_hide_search>div>div>input"));
		eleNumber.click();
		eleNumber.sendKeys(proposalNum, Keys.ENTER);
	}

	@And("Click on Resultant ProposalNum Hyperlink")
	public void clickOnResultantProposal() {
		driver.findElement(By.cssSelector("table#std_change_proposal_table>tbody>tr>td:nth-of-type(3)>a")).click();
	}

	@And("Update the Proposal State value as Closed using index")
	public void selectProposalState() {
		Select proposalState = new Select(driver.findElement(By.id("std_change_proposal.state")));
		proposalState.selectByIndex(2);
		System.out.println("Updated proposal state value as Closed");
		System.out.println(" ");
	}

	/*
	 * <This option is missing> -- subwindow doesnt' have any values now but it has
	 * before. So commented these steps for now >
	 * 
	 * 
	 * And Click the AssignedTo Lookup And Navigate to SubWindow1 And Click on
	 * Change Manager Link And Switch to ParentWindow And Switch to ParentFrame
	 * 
	 */

	/*
	 * @And("Click the AssignedTo Lookup") public void clickAssignedToLookup() {
	 * driver.findElement(By.xpath(
	 * "//button[@id='lookup.std_change_proposal.assigned_to']//span[1]")).click();
	 * // Lookup-using }
	 * 
	 * @And("Click on Change Manager Link") public void clickOnChangeManager()
	 * throws InterruptedException {
	 * driver.findElement(By.linkText("Change Manager")).click();
	 * Thread.sleep(1000); }
	 */

	@And("Click the Category Value Lookup")
	public void clickOnCategoryLookup() {
		driver.findElement(By.id("lookup.std_change_proposal.category")).click(); // Lookup-using
	}

	@And("Click on the Template Management Link")
	public void clickOnTemplateManagement() {
		driver.findElement(By.linkText("Template Management")).click();
	}

// Mandatory fields needs to get update - "Change Request values" have not been
	// provided: Assignment group, Justification, Risk and impact analysis

	@And("Click on Change Request Values Tab")
	public void clickOnCRValuesTab() {
		driver.findElement(By.xpath("//span[text()='Change Request values']")).click();
	}

	@And("Click on Assignment Group Lookup")
	public void clickOnAssignGroupLookup() {
		driver.findElement(By.xpath("//td[@data-value='Assignment group']//button[1]")).click();
	}

	@And("Enter Assign group as {string}")
	public void enterAssignGroupValue(String assignGrpVal) {
		WebElement assignGroup = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		assignGroup.sendKeys(assignGrpVal, Keys.ENTER);
	}

	@And("Click on Change Management Link")
	public void clickOnCMLink() throws InterruptedException {
		driver.findElement(By.linkText("Change Management")).click();
		Thread.sleep(1000);
	}

	@And("Enter Justification field value as {string}")
	public void enterJustifiction(String justificationVal) {
		WebElement justification = driver.findElement(By.xpath("//td[@data-value='Justification']//textarea[1]"));
		justification.click();
		justification.clear();
		justification.sendKeys(justificationVal);
	}

	@And("Enter Risk Impact field value as {string}")
	public void enterRiskImpact(String rickImpactVal) {
		WebElement riskImpact = driver
				.findElement(By.xpath("//td[@data-value='Risk and impact analysis']//textarea[1]"));
		riskImpact.click();
		riskImpact.clear();
		riskImpact.sendKeys(rickImpactVal);
	}

	@And("Click on Update Button for updated proposal")
	public void clickOnUpdateBtn() throws InterruptedException {
		driver.findElement(By.cssSelector("button#sysverb_update_bottom")).click();
		Thread.sleep(1000);
	}

	@And("Verify the updated Information of proposal (.*)$")
	public void verifyUpdatedProposalStatus(String proposalNum) throws InterruptedException {

		/*
		 * Settings button - personalize list
		 * 
		 * driver.findElement(By.xpath("//i[@data-list_id='std_change_proposal']")).
		 * click(); Thread.sleep(1000); // Personalize list columns
		 * driver.findElement(By.xpath("//option[text()='Assigned to']")).click();
		 * driver.findElement(By.xpath("//div[@id='addRemoveButtons']//a[1]")).click();
		 * driver.findElement(By.xpath("//option[text()='Category']")).click();
		 * driver.findElement(By.xpath("//div[@id='addRemoveButtons']//a[1]")).click();
		 * driver.findElement(By.cssSelector("button#ok_button")).click();
		 */

		String verifychangeNo = driver
				.findElement(By.cssSelector("table#std_change_proposal_table>tbody>tr>td:nth-of-type(3)")).getText();

		// String verifyAssignedT0 = driver.findElement(By.linkText("Change
		// Manager")).getText();
		// driver.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(10)")).getText();

		String verifyStateValue = driver
				.findElement(By.cssSelector("table#std_change_proposal_table>tbody>tr>td:nth-of-type(6)")).getText();

		/*
		 * if ((verifychangeNo.equalsIgnoreCase(proposalNum)) &&
		 * (verifyAssignedT0.equalsIgnoreCase("Change Manager")) &&
		 * verifyStateValue.equalsIgnoreCase("In Progress")) {
		 * System.out.println("Change Reuest: " + verifychangeNo + " ; " +
		 * " Assigned To: " + verifyAssignedT0 + " ; " + "State: " + verifyStateValue);
		 */

		if ((verifychangeNo.equalsIgnoreCase(proposalNum)) && verifyStateValue.equalsIgnoreCase("Closed")) {
			System.out.println("Change Reuest: " + verifychangeNo + " ; " + "State: " + verifyStateValue);
			System.out.println(" ");
			System.out.println("Update Proposal Request >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Error!! " + "Update Proposal Request >> TestCase failed");
		}

	}
}