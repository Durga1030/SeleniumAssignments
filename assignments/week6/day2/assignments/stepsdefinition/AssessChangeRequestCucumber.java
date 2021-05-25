package week6.day2.assignments.stepsdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;

public class AssessChangeRequestCucumber extends BaseSetup {

	@And("Search Exiting Change using Change Number as (.*)$")
	public void searchExistingChange(String chNum) {
		Select searchNumberOption = new Select(
				driver.findElement(By.cssSelector("span#change_request_hide_search>div>div>span>span>select")));
		searchNumberOption.selectByIndex(1);

		WebElement searchCHG = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		searchCHG.click();
		searchCHG.sendKeys(chNum);
		searchCHG.sendKeys(Keys.ENTER);

	}

	@And("Click on Resultant Number Hyperlink")
	public void clickOnResultantNum() {
		String changeNum = driver.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(3)"))
				.getText();
		driver.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(3)>a")).click();
		System.out.println("Resultant Num: " + changeNum);
	}

	@And("Update the State value as Assess using index")
	public void assignstateValue() {
		Select changeRequestState = new Select(driver.findElement(By.id("change_request.state")));
		changeRequestState.selectByIndex(1);
		System.out.println("Updated Change Request state value");
		System.out.println(" ");
	}

	@And("Click the Assignment Group Lookup")
	public void clickAssignGroupLookup() {
		driver.findElement(By.id("lookup.change_request.assignment_group")).click(); // Lookup using List
	}

// And Navigate to SubWindow1

	@And("Click on Software dropdown option")
	public void selectSoftware() {
		driver.findElement(
				By.xpath("//div[@id='treenode_0']/div[1]/div[1]/div[29]/table[1]/tbody[1]/tr[1]/td[1]/img[1]")).click(); // click
		// on
		// Softwaredropdown
	}

	@And("Click the value of Assignment Group")
	public void clickAssignmentGroupVal() {
		WebElement assignGroup = driver.findElement(By.cssSelector(
				"div#treenode_0>div>div>div:nth-of-type(29)>div>div:nth-of-type(5)>table>tbody>tr>td:nth-of-type(3)>a"));
		assignGroup.click();
	}

	// And Switch to ParentWindow
//And Switch to ParentFrame

	@And("Click the Assigned To Lookup")
	public void clickAssignedToLookup() {
		driver.findElement(By.xpath("//button[@id='lookup.change_request.assigned_to']//span[1]")).click(); // Lookup
																											// using
	}

	// And Navigate to SubWindow1

	@And("Enter AssignedTo value as {string}")
	public void getAssignedTo(String assignedToVal) {

		WebElement assignmentTo = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		assignmentTo.sendKeys(assignedToVal, Keys.ENTER);
	}

	@And("Click on the ITILUser Link")
	public void clickITILUser() throws InterruptedException {
		driver.findElement(By.linkText("ITIL User")).click();

		Thread.sleep(1000);
	}

	// And Switch to ParentWindow
	// And Switch to ParentFrame
	@And("Click on Update Button")
	public void clickOnUpdateBtn() {

		driver.findElement(By.cssSelector("button#sysverb_update_bottom")).click();
	}

	@And("Verify the updated Information for updated change request (.*)$")

	public void verifyUpdatedInfo(String chNum) {

		String verifychangeNo = driver
				.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(3)")).getText();

		String verifyAssignedT0 = driver
				.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(10)")).getText();

		String verifyStateValue = driver
				.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(6)")).getText();

		if ((verifychangeNo.equalsIgnoreCase(chNum)) && (verifyAssignedT0.equalsIgnoreCase("ITIL User"))
				&& verifyStateValue.equalsIgnoreCase("Assess")) {
			System.out.println("Change Reuest: " + verifychangeNo + " ; " + " Assigned To: " + verifyAssignedT0 + " ; "
					+ "State: " + verifyStateValue);
			System.out.println(" ");
			System.out.println("Assess Change Request >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Error!! " + "Assess Change Request >> TestCase failed");
		}
	}
}
