package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class ChangeReqDataServices extends TestNgHooks {

	public static String startDateCR;
	public static String endDateCR;

	public ChangeReqDataServices assignShortDesc(String shortDescCRVal) {
		click(locateElement("change_request.short_description"));
		clearAndType(locateElement("change_request.short_description"), shortDescCRVal);
		return this;
	}

	// Update State as Assess
	public ChangeReqDataServices assignStateValue() {
		selectDropDownUsingIndex(locateElement("change_request.state"), 1);
		return this;
	}

	// Assign Software to the assignment group

	public ServiceNowGrpHierarchy clickOnAssignGrpLookup() {
		// // Lookup using List
		clickWithNoSnap(locateElement("lookup.change_request.assignment_group"));
		switchToWindow(1);
		return new ServiceNowGrpHierarchy();
	}

	public ServiceNowGrpHierarchy clickOnAssignedToLookup() {
		clickWithNoSnap(locateElement("xpath", "//button[@id='lookup.change_request.assigned_to']//span[1]"));
		switchToWindow(1);
		return new ServiceNowGrpHierarchy();
	}

	public ChangeReqDataServices clickOnScheduleTab() {
		click(locateElement("xpath", "//span[text()='Schedule']"));
		return this;
	}

	public ChangeReqDataServices clickStartDateCalenderIcon() {
		click(locateElement("xpath", "(//button[@id='change_request.start_date.ui_policy_sensitive']//span)[3]"));
		return this;
	}

	public ChangeReqDataServices selectStartDate() {
		click(locateElement("xpath", "(//a[@class='calOtherMonthDateAnchor'])[2]"));
		return this;
	}

	public ChangeReqDataServices clickSaveDateCR() {
		click(locateElement("GwtDateTimePicker_ok"));
		return this;
	}

	public ChangeReqDataServices getEnteredStartDateValue() {
//String changerequeststartdate =
		// driver.findElement(By.id("change_request.start_date")).getAttribute("value");
		startDateCR = getTypedText(locateElement("change_request.start_date"));
		return this;
	}

	public ChangeReqDataServices clickEndDateCalenderIcon() {
		click(locateElement("xpath", "(//button[@id='change_request.end_date.ui_policy_sensitive'])[2]"));
		return this;
	}

	public ChangeReqDataServices getEnteredEndDateValue() {
		// String changerequeststartdate =
		// driver.findElement(By.id("change_request.start_date")).getAttribute("value");
		endDateCR = getTypedText(locateElement("change_request.end_date"));
		return this;
	}

	public ChangeReqDataServices clickOnCabReqCheckBox() {
		click(locateElement("label.ni.change_request.cab_required"));
		return this;
	}

	public ChangeReqDataServices clickOnCabDateCalenderIcon() {
		click(locateElement("xpath", "//a[@data-date_time_format='yyyy-MM-dd']//span[1]"));
		return this;
	}

	public ChangeReqDataServices selectCabDate() {
		click(locateElement("css", "a#GwtDateTimePicker_day8"));
		return this;
	}

	public ChangeReqServices clickOnUpdateButton() {
		click(locateElement("css", "button#sysverb_update_bottom"));
		return new ChangeReqServices();
	}

	public ChangeReqServices clickOnDeleteButton() {
		click(locateElement("css", "button#sysverb_delete"));
		click(locateElement("ok_button"));
		return new ChangeReqServices();
	}

}
