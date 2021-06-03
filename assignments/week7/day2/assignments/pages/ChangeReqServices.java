package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class ChangeReqServices extends TestNgHooks {

	public static String resultantCRNum;
	public static String resultantCRState;
	public static String resultantAssignedTo;
	public static String resultantPlannedStartDate;
	public static String resultantPlannedEndDate;
	public static String filterToDelete;
	public static String resultantDeleteCR;

	public ChangeReqServices searchOptionNum() {
		selectDropDownUsingIndex(
				locateElement("xpath", "//span[@class='input-group-addon input-group-select']//select[1]"), 1);
		return this;
	}

	public ChangeReqServices searchOptionState() {
		selectDropDownUsingIndex(
				locateElement("xpath", "//span[@class='input-group-addon input-group-select']//select[1]"), 4);
		return this;
	}

	public ChangeReqServices assignStateValue(String searchStateVal) throws InterruptedException {
		TypeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"), searchStateVal);
		return this;
	}

	public ChangeReqServices assignExistingCRNumDel(String existingCRNum) {
		// driver.findElement(By.xpath("//input[@id='change_request_table_header_search_control']")).sendKeys("values
		// to send");
		clearAndType(locateElement("xpath", "//input[@id='change_request_table_header_search_control']"),
				existingCRNum);
		return this;
	}

	public ChangeReqServices getFilterOptionsToDelete() {
//String allStateNewNumber = driver.findElement(By.id("change_request_breadcrumb")).getText();

		filterToDelete = getElementText(locateElement("change_request_breadcrumb"));

		System.out.println(filterToDelete);
		return this;
	}

	public ChangeReqServices assignNewCRValue() throws InterruptedException {
		TypeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"), ChangeNewRecordPage.newCRNum);
		return this;
	}

	public ChangeReqServices assignexistingCRValue(String existingCRNum) throws InterruptedException {
		TypeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"), existingCRNum);
		return this;
	}

	public ChangeReqServices getResultantCRNum() {
		resultantCRNum = getElementText(locateElement("css", "table#change_request_table>tbody>tr>td:nth-of-type(3)"));
		return this;
	}

	public ChangeReqServices getResultantStateVal() {
		resultantCRState = getElementText(
				locateElement("css", "table#change_request_table>tbody>tr>td:nth-of-type(6)"));
		return this;
	}

	public ChangeReqServices getResultantCRStartDate() {
		resultantPlannedStartDate = getElementText(
				locateElement("css", "table#change_request_table>tbody>tr>td:nth-of-type(7)"));
		return this;
	}

	public ChangeReqServices getResultantCREndDate() {
		resultantPlannedEndDate = getElementText(
				locateElement("css", "table#change_request_table>tbody>tr>td:nth-of-type(8)"));
		return this;
	}

	public ChangeReqServices getResultantCRAssignedTo() {
		resultantAssignedTo = getElementText(
				locateElement("css", "table#change_request_table>tbody>tr>td:nth-of-type(10)"));
		return this;
	}

	public ChangeReqDataServices clickOnResultantCRNum() {
		click(locateElement("xpath", "//a[@class='linked formlink']"));
		return new ChangeReqDataServices();
	}

	public ChangeReqServices verifyCreatedChangeReq() {
		verifyExactText(locateElement("css", "table#change_request_table>tbody>tr>td:nth-of-type(3"),
				ChangeNewRecordPage.newCRNum);
		return this;
	}

	public ChangeReqServices verifyAssessChangeReq(String existingCRNum) {
		System.out.println("Num: " + existingCRNum + "AssignedTo: " + resultantAssignedTo);
		verifyExactText(locateElement("css", "table#change_request_table>tbody>tr>td:nth-of-type(3)"), existingCRNum);
		verifyExactText(locateElement("css", "table#change_request_table>tbody>tr>td:nth-of-type(6)"), "Assess");
		verifyExactText(locateElement("css", "table#change_request_table>tbody>tr>td:nth-of-type(10)"),
				resultantAssignedTo);

		return this;
	}

	public ChangeReqServices verifyUpdateScheduleChangeReq(String existingCRNum) {
		System.out.println("Num: " + existingCRNum + "Start Date: " + resultantPlannedStartDate + "End date: "
				+ resultantPlannedEndDate);
		verifyExactText(locateElement("css", "table#change_request_table>tbody>tr>td:nth-of-type(3)"), existingCRNum);
		verifyExactText(locateElement("css", "table#change_request_table>tbody>tr>td:nth-of-type(7)"),
				ChangeReqDataServices.startDateCR);
		verifyExactText(locateElement("css", "table#change_request_table>tbody>tr>td:nth-of-type(8)"),
				ChangeReqDataServices.endDateCR);

		return this;
	}

	public ChangeReqServices getResultantDelStatus() {
		resultantDeleteCR = getElementText(locateElement("xpath", "//td[text()='No records to display']"));
		System.out.println("Status After deleting the Request: " + resultantDeleteCR);
		return this;
	}

	public ChangeReqServices verifyDeletedCRStatus(String expectedDeletedResult) {
		System.out.println(resultantDeleteCR + " matches with the expected result: " + expectedDeletedResult);
		verifyExactText(locateElement("xpath", "//td[text()='No records to display']"), expectedDeletedResult);
		return this;
	}
}
