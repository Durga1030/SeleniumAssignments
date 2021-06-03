package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class ServiceNowGrpHierarchy extends TestNgHooks {

	public ServiceNowGrpHierarchy enterAssignGroupValue(String assignGrpVal) throws InterruptedException {
		System.out.println(assignGrpVal);
		TypeAndEnter(locateElement("xpath", "(//label[text()='Search'])[2]/following::input"), assignGrpVal);
		return this;
	}

	public PropExistingRecordPage clickOnCMLink() throws InterruptedException {
		clickWithNoSnap(locateElement("link", "Change Management"));
		switchToWindow(0);
		switchToFrame(0);
		return new PropExistingRecordPage();
	}

	public ChangeReqDataServices clickOnSoftware() {
		click(locateElement("xpath",
				"//div[@id='treenode_0']/div[1]/div[1]/div[29]/table[1]/tbody[1]/tr[1]/td[1]/img[1]"));
		click(locateElement("css",
				"div#treenode_0>div>div>div:nth-of-type(29)>div>div:nth-of-type(5)>table>tbody>tr>td:nth-of-type(3)>a"));
		switchToWindow(0);
		switchToFrame(0);
		return new ChangeReqDataServices();
	}

	public IncDataServices clickOnIncidentSoftware() {
		click(locateElement("link", "Software"));
		switchToWindow(0);
		switchToFrame(0);
		return new IncDataServices();
	}

	public ServiceNowGrpHierarchy assignAssignedToITILUser(String assignedToVal) throws InterruptedException {
		TypeAndEnter(locateElement("xpath", "(//label[text()='Search'])[2]/following::input"), assignedToVal);
		Thread.sleep(1000);
		return this;
	}

	public ChangeReqDataServices clickOnITILUserLink() {
		click(locateElement("link", "ITIL User"));
		switchToWindow(0);
		switchToFrame(0);
		return new ChangeReqDataServices();
	}

	public IncDataServices clickOnIncidentITILUserLink() {
		click(locateElement("link", "ITIL User"));
		switchToWindow(0);
		switchToFrame(0);
		return new IncDataServices();
	}

}
