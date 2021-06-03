package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class RequestPage extends TestNgHooks {

	public RequestPage clickOnDeleteButton() {
		click(locateElement("sysverb_delete"));
		return this;
	}

	public TaskSelfService clickOnDelOkButn() throws InterruptedException {
		click(locateElement("ok_button"));
		Thread.sleep(1000);
		return new TaskSelfService();
	}

	public TaskSelfService clickOnCancelReqButton() {
		click(locateElement("xpath", "(//button[text()='Cancel Request'])[2]"));
		return new TaskSelfService();
	}

}
