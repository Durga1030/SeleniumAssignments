package week7.day2.assignments.pages;

import org.openqa.selenium.By;

import week7.day2.assignments.hooks.TestNgHooks;

public class MobileRequestDataServiceNow extends TestNgHooks {

	public static String screquestnumber;

	public MobileRequestDataServiceNow getReqNum() {
		screquestnumber = getDriver().findElement(By.id("sc_request.number")).getAttribute("value");
		return this;
	}

	public MobileRequestDataServiceNow assignOrderReqApproval() {
		selectDropDownUsingIndex(locateElement("sc_request.approval"), 1);
		return this;
	}

	public MobileRequestDataServiceNow assignOrderReqState() {
		selectDropDownUsingIndex(locateElement("sc_request.request_state"), 2);
		return this;
	}

	public MobileRequestDataServiceNow assignOrderReqApprovalRejected() {
		selectDropDownUsingIndex(locateElement("sc_request.approval"), 3);
		return this;
	}

	public MobileRequestDataServiceNow assignOrderReqStateCancelled() {
		selectDropDownUsingIndex(locateElement("sc_request.request_state"), 5);
		return this;
	}

	public MobileRequestDataServiceNow assignOrderShortDesc(String orderShortDesc) {
		click(locateElement("sc_request.short_description"));
		clearAndType(locateElement("sc_request.short_description"), orderShortDesc);
		return this;
	}

	public MobileReqServicePage clickOnUpdateButton() {
		click(locateElement("css", "button#sysverb_update_bottom"));
		// switchToFrame(0);
		return new MobileReqServicePage();
	}

//driver.findElement(By.xpath("(//button[@name='not_important'])[2]")).click();

	public MobileOrderStatusPage clickOnCancelReqButton() {
		click(locateElement("xpath", "(//button[@name='not_important'])[2]"));
		// switchToFrame(0);
		return new MobileOrderStatusPage();
	}

	public MobileOrderStatusPage clickOnDeleteButton() {
		System.out.println("Request: " + screquestnumber + " needs to be deleted");
		if (screquestnumber.equalsIgnoreCase(MobileOrderStatusPage.resultantOrderRequestNumber)) {
			System.out.println(
					screquestnumber + " Request number matches " + MobileOrderStatusPage.resultantOrderRequestNumber);
			click(locateElement("id", "sysverb_delete"));
			click(locateElement("id", "ok_button"));
		} else {
			System.err.println(screquestnumber + "Request number does not match"
					+ MobileOrderStatusPage.resultantOrderRequestNumber);
		}

		return new MobileOrderStatusPage();
	}

}
