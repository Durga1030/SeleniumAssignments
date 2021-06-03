package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class TaskSelfService extends TestNgHooks {

	public static String resultState;
	public static String resultNumber;
	public static String resultantCQNum;
	static String resultantShortDesc;
	public static String resultantCQText;
	public static String resultantCanceledWorkRequest;
	public static String resultantDelCQStatus;
	public static String resultantCQConfigItem;
	public static String resultantWorkNumber;
	public static String resultantWorkLocation;

	public TypesOfTaskPage clickOnTaskNewButton() {
		click(locateElement("id", "sysverb_new"));
		return new TypesOfTaskPage();
	}

	public TaskSelfService searchOptionNum() {
		selectDropDownUsingIndex(
				locateElement("xpath", "//span[@class='input-group-addon input-group-select']//select[1]"), 1);
		return this;
	}

	public TaskSelfService assignCQValue() throws InterruptedException {
		TypeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"), ChatQueueNewEntryPage.cQEntryNum);
		return this;
	}

	public TaskSelfService assignDeletedCQValue() throws InterruptedException {
		TypeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"), ChatQueueEntry.cQEntryNum);
		return this;
	}

	public TaskSelfService assignNewWorkValue() throws InterruptedException {
		TypeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"), RequestNewRecordPage.reqNum);
		return this;
	}

	public ChatQueueEntry clickFirstResultantCQNum() {
		click(locateElement("xpath", "//a[@class='linked formlink']"));
		return new ChatQueueEntry();
	}

	public RequestPage clickFirstResultantWorkNumber() {
		click(locateElement("xpath", "//a[@class='linked formlink']"));
		return new RequestPage();
	}

	public TaskSelfService getResultantLocationValue() {
		resultantWorkLocation = getElementText(locateElement("css", "table#task_table>tbody>tr>td:nth-of-type(11)"));
		System.out.println("Location: " + resultantWorkLocation);
		return this;
	}

	public TaskSelfService getResultantNumberValue() {
		resultantWorkNumber = getElementText(locateElement("css", "table#task_table>tbody>tr>td:nth-of-type(3)"));
		// driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(3)")).getText();
		return this;
	}

	public TaskSelfService verifyWorkCreationStatus() {
		resultNumber = getElementText(locateElement("css", "table#task_table>tbody>tr>td:nth-of-type(3)"));
		System.out.println("Resultant Work Number: " + resultNumber + " matches with " + RequestNewRecordPage.reqNum);
		verifyExactText(locateElement("css", "table#task_table>tbody>tr>td:nth-of-type(3)"),
				RequestNewRecordPage.reqNum);

		return this;
	}

	public TaskSelfService verifyUpdatedWorkStatus() {
		System.out.println("Resultant Work Number: " + resultNumber + " matches with " + RequestNewRecordPage.reqNum);
		verifyExactText(locateElement("css", "table#task_table>tbody>tr>td:nth-of-type(3)"),
				RequestNewRecordPage.reqNum);
		verifyExactText(locateElement("css", "table#task_table>tbody>tr>td:nth-of-type(11)"), "Rhode Island");
		return this;
	}

	public TaskSelfService verifyWorkDeletionStatus(String reqNum) {
		return this;
	}

	public TaskSelfService getCQnumValue() throws InterruptedException {
		TypeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"), ChatQueueNewEntryPage.cQEntryNum);
		return this;
	}

	public TaskSelfService enterExistingCQNum(String extCQNum) throws InterruptedException {
		TypeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"), extCQNum);
		return this;
	}

	public TaskSelfService getResultantShortDesc() {
		resultantShortDesc = getElementText(locateElement("css", "table#task_table>tbody>tr>td:nth-of-type(7)"));
		System.out.println(resultantShortDesc + " needs to verify.");
		return this;
	}

	public TaskSelfService getResultantCQNum() {
		resultantCQNum = getElementText(locateElement("xpath", "//a[@class='linked formlink']"));
		return this;
	}

	public TaskSelfService verifyCreatedChatQ() {
		verifyExactText(locateElement("xpath", "//a[@class='linked formlink']"), ChatQueueNewEntryPage.cQEntryNum);
		return this;
	}

	public TaskSelfService verifyCQEntryUpdate() {
		verifyPartialText(locateElement("css", "table#task_table>tbody>tr>td:nth-of-type(7)"), resultantShortDesc);
		return this;
	}

	public TaskSelfService getResultantText() {
		resultantCanceledWorkRequest = getElementText(locateElement("xpath", "//td[text()='No records to display']"));
		System.out.println("Status After deleting: " + resultantCanceledWorkRequest);

		return this;
	}

	public TaskSelfService getResultantDelStatus() {
		resultantDelCQStatus = getElementText(locateElement("xpath", "//td[text()='No records to display']"));
		System.out.println("Status After deleting the Request: " + resultantDelCQStatus);
		return this;
	}

	public TaskSelfService getResultantConfigureItem() {
		resultantCQConfigItem = getElementText(locateElement("css", "table#task_table>tbody>tr>td:nth-of-type(9)"));
		return this;
	}

	public TaskSelfService verifyDeletedCQStatus(String expectedDeletedResult) {
		System.out.println(resultantDelCQStatus + " matches with the expected result: " + expectedDeletedResult);
		verifyExactText(locateElement("xpath", "//td[text()='No records to display']"), expectedDeletedResult);
		return this;
	}

	public TaskSelfService verifyCancelleddWRStatus(String expectedCancelledResult) {
		System.out.println(
				resultantCanceledWorkRequest + " matches with the expected result: " + expectedCancelledResult);
		verifyExactText(locateElement("xpath", "//td[text()='No records to display']"), expectedCancelledResult);
		return this;
	}

	public TaskSelfService verifyDeletedWorkStatus(String expectedDeletedResult) {
		System.out
				.println(resultantCanceledWorkRequest + " matches with the expected result: " + expectedDeletedResult);
		verifyExactText(locateElement("xpath", "//td[text()='No records to display']"), expectedDeletedResult);
		return this;
	}

	public TaskSelfService verifyConfiguredCQEntry(String inputConfigureItem) {
		verifyExactText(locateElement("css", "table#task_table>tbody>tr>td:nth-of-type(9)"), inputConfigureItem);
		return this;
	}

}
