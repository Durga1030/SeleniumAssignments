package week7.day2.assignments.pages;

import org.openqa.selenium.By;

import week7.day2.assignments.hooks.TestNgHooks;

public class MobileReqServicePage extends TestNgHooks {

	public String verifyDeleteOrderStatus;
	public String resultDescription;

	public MobileReqServicePage searchOptionNum() {
		selectDropDownUsingIndex(
				locateElement("xpath", "//span[@class='input-group-addon input-group-select']//select[1]"), 1);
		return this;
	}

	public MobileReqServicePage assignSearchValue() throws InterruptedException {
		TypeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"),
				MobileRequestDataServiceNow.screquestnumber);
		// MobileOrderStatusPage.resultantOrderRequestNumber);
		return this;
	}

	public MobileReqServicePage assignExistingOrderValue(String existingOrderVal) throws InterruptedException {
		TypeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"), existingOrderVal);
		// MobileOrderStatusPage.resultantOrderRequestNumber);
		return this;
	}

	public MobileReqServicePage personalizedListSettingsFilter() throws InterruptedException {

		// Settings button - personalize list
		getDriver().findElement(By.xpath("//i[@data-list_id='sc_request']")).click();
		// click(locateElement("xpath", "//i[@data-list_id='std_change_proposal']"));
		Thread.sleep(1000);
//		click(locateElement("xpath", "//option[text()='Assigned to']"));
		/*
		 * click(locateElement("xpath", "//option[text()='Short description']"));
		 * click(locateElement("xpath", "//div[@id='addRemoveButtons']//a[1]"));
		 * click(locateElement("css", "button#ok_button"));
		 */

		getDriver().findElement(By.xpath("//option[text()='Short description']")).click();
		getDriver().findElement(By.xpath("//div[@id='addRemoveButtons']//a[1]")).click();
		getDriver().findElement(By.cssSelector("button#ok_button")).click();

		return this;
	}

	public MobileReqServicePage verifyDeletedOrderStatus() {
		verifyDeleteOrderStatus = "No records to display";
		verifyExactText(locateElement("xpath", "//td[text()='No records to display']"), verifyDeleteOrderStatus);
		return this;
	}

	public MobileReqServicePage verifyCancelledOrderStatus() {
		verifyDeleteOrderStatus = "No records to display";
		verifyExactText(locateElement("xpath", "//td[text()='No records to display']"), verifyDeleteOrderStatus);
		return this;
	}

	public MobileRequestDataServiceNow clickOnFirstResultingReqNum() {
		click(locateElement("xpath", "//a[@class='linked formlink']"));
		return new MobileRequestDataServiceNow();
	}

	public MobileReqServicePage getResultantOrderShortDesc() {
		resultDescription = getElementText(locateElement("css", "table#sc_request_table>tbody>tr>td:nth-of-type(8)"));
		System.out.println("Resultant Description: " + resultDescription);
		// String weekDesc =
		// driver.findElement(By.cssSelector("table#sc_request_table>tbody>tr>td:nth-of-type(8)")).getText();
		return this;
	}

	public MobileReqServicePage verifyUpdatedOrderStatus(String orderShortDesc) {
		verifyExactText(locateElement("css", "table#sc_request_table>tbody>tr>td:nth-of-type(8)"), orderShortDesc);
		return this;
	}

}
