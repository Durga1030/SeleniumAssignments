package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class IncidentSelfService extends TestNgHooks {

	public static String resultantState;
	public static String resultantUrgency;
	public static String resultantDeletedIncStatus;
	public static String resultantAssignedTo;

	public IncidentSelfService verifySuccessMessage() {
		switchToFrame(0);
		verifyPartialText(locateElement("css", "div#list_nav_incident>div>div>h1>a"), "Incidents");
		return this;
	}

	public IncNewRecordPage clickNewButton() {
		click(locateElement("xpath", "//div[text()='Create New']"));
		switchToFrame(0);
		return new IncNewRecordPage();
	}

	public IncidentSelfService clickOpenOption() {
		click(locateElement("xpath", "//div[text()='Open']"));
		switchToFrame(0);
		return this;
	}

	public IncidentSelfService searchOptionNum() {
		selectDropDownUsingIndex(
				locateElement("xpath", "//span[@class='input-group-addon input-group-select']//select[1]"), 1);
		return this;
	}

	public IncidentSelfService assignIncidentNum() throws InterruptedException {
		click(locateElement("xpath", "//input[@placeholder='Search']"));
		TypeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"), IncNewRecordPage.incidentNumber);
		return this;
	}

	public IncidentSelfService assignExistingIncidentNum(String existingIncNum) throws InterruptedException {
		click(locateElement("xpath", "//input[@placeholder='Search']"));
		TypeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"), existingIncNum);
		return this;
	}

	public IncDataServices clickOnResultingIncNum() {
		click(locateElement("xpath", "//a[@class='linked formlink']"));
		return new IncDataServices();
	}

	public IncidentSelfService getResultantState() {
		resultantState = getElementText(locateElement("css", "table#incident_table>tbody>tr>td:nth-of-type(8)"));
		System.out.println(resultantState);
		return this;
	}

	public IncidentSelfService getResultantUrgency() {
		resultantUrgency = getElementText(locateElement("css", "table#incident_table>tbody>tr>td:nth-of-type(14)"));
		System.out.println(resultantUrgency);
		return this;
	}

	public IncidentSelfService getResultantIncAssignedTo() {
		resultantAssignedTo = getElementText(locateElement("css", "table#incident_table>tbody>tr>td:nth-of-type(11)"));
		return this;
	}

	public IncidentSelfService verifyCreatedIncident() throws InterruptedException {
		verifyExactText(locateElement("xpath", "//a[@class='linked formlink']"), IncNewRecordPage.incidentNumber);
		return this;
	}

	public IncidentSelfService verifyAssessIncident(String existingIncNum) {
		System.out.println("Num: " + existingIncNum + "AssignedTo: " + resultantAssignedTo);
		verifyExactText(locateElement("css", "table#incident_table>tbody>tr>td:nth-of-type(3)"), existingIncNum);
		verifyExactText(locateElement("css", "table#incident_table>tbody>tr>td:nth-of-type(11)"), resultantAssignedTo);

		return this;
	}

	public IncidentSelfService verifyUpdatedIncidentStatus(String existingIncNum, String expectedStateVal,
			String expectedUrgencyVal) throws InterruptedException {
		verifyExactText(locateElement("xpath", "//a[@class='linked formlink']"), existingIncNum);
		verifyExactText(locateElement("css", "table#incident_table>tbody>tr>td:nth-of-type(8)"), expectedStateVal);
		verifyExactText(locateElement("css", "table#incident_table>tbody>tr>td:nth-of-type(14)"), expectedUrgencyVal);
		return this;
	}

	public IncidentSelfService verifyResolvedIncidentStatus(String existingIncNum, String expectedStateVal)
			throws InterruptedException {
		verifyExactText(locateElement("xpath", "//a[@class='linked formlink']"), existingIncNum);
		verifyExactText(locateElement("css", "table#incident_table>tbody>tr>td:nth-of-type(8)"), expectedStateVal);
		return this;
	}

	public IncidentSelfService verifyDeletedIncidentStatus(String expectedDeletedResult) {
		verifyExactText(locateElement("xpath", "//td[text()='No records to display']"), expectedDeletedResult);
		return this;
	}
}