package week7.day2.assignments.pages;

import org.openqa.selenium.By;

import week7.day2.assignments.hooks.TestNgHooks;

public class RequestNewRecordPage extends TestNgHooks {

	public static String reqNum;

	public LocationsServicePage clickOnLocationLookup() {
		// Location lookup using list
		getDriver().findElement(By.id("lookup.sc_request.location")).click();
		switchToWindow(1);
		return new LocationsServicePage();
	}

	public RequestNewRecordPage setApprovalValue() {
		// Set approval cval as Requested.
		selectDropDownUsingIndex(locateElement("sc_request.approval"), 1);
		return this;
	}

	public RequestNewRecordPage setRequestStateValue() {
		selectDropDownUsingIndex(locateElement("sc_request.request_state"), 1);
		return this;
	}

	public RequestNewRecordPage clickOnDueDateLookup() {
		click(locateElement("xpath", "(//button[@id='sc_request.due_date.ui_policy_sensitive']//span)[3]"));
		return this;
	}

	public RequestNewRecordPage clickOnDate() {
		click(locateElement("css",
				"h1#GwtDateTimePicker_header_contents>div>table>tbody>tr>td>table>tbody>tr:nth-of-type(5)>td:nth-of-type(5)>a"));
		click(locateElement("GwtDateTimePicker_ok"));
		return this;
	}

	public RequestNewRecordPage getRequestNum() {
		reqNum = getTypedText(locateElement("sc_request.number"));
		System.out.println(reqNum);
		return this;

	}

	public TaskSelfService clickOnSubmitButton() {
		click(locateElement("css", "button#sysverb_insert_bottom"));
		return new TaskSelfService();
	}

}
