package week7.day2.assignments.pages;

import org.openqa.selenium.By;

import week7.day2.assignments.hooks.TestNgHooks;

public class IncNewRecordPage extends TestNgHooks {

	public static String incidentNumber;
	public static String resultantErrorMsg;

	public IncNewRecordPage verifySuccessMessage() {
		/*
		 * driver.switchTo().frame(0); String recordSelfServiceView =
		 * driver.findElement(By.xpath("//div[@class='container-fluid']")).getText();
		 * System.out.println(recordSelfServiceView); if
		 * (recordSelfServiceView.contains("Incident")) {
		 * System.out.println("Login Success"); }
		 */
		return this;

	}

	public IncNewRecordPage getIncNumber() {
		incidentNumber = getTypedText(locateElement("name", "incident.number"));
		System.out.println(getTypedText(locateElement("name", "incident.number")));
		return this;
	}

	public IncUserServiceNow clickCallerInfoLookup() throws InterruptedException {

		// Lookup using List

		getDriver().findElement(By.xpath("//button[@id='lookup.incident.caller_id']//span[1]")).click();
		switchToWindow(1);

		return new IncUserServiceNow();
	}

	public IncNewRecordPage assignShortDesc(String data) {

		clearAndType(locateElement("xpath", "(//input[@class='form-control'])[2]"), data);
		return this;
	}

	public IncidentSelfService clickOnSubmitButton() {
		click(locateElement("xpath", "(//button[text()='Submit'])[2]"));
		return new IncidentSelfService();
	}

	public IncNewRecordPage clickSubmitToVerifyError() {
		// click(locateElement("xpath", "(//button[text()='Submit'])[2]"));
		click(locateElement("sysverb_insert"));
		return this;
	}

	public IncNewRecordPage getIncErrorMessage() {
		resultantErrorMsg = getElementText(locateElement("class", "outputmsg_text"));
		System.out.println("Error while creating an incident: " + resultantErrorMsg);
		return this;
	}

	public IncNewRecordPage verifyIncCreationErrorMsg() {
		verifyExactText(locateElement("class", "outputmsg_text"), resultantErrorMsg);
		return this;
	}
}
