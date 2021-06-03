package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class LocationsServicePage extends TestNgHooks {

	public LocationsServicePage expandOptionAmericas() {
		click(locateElement("xpath", "//img[@src='images/gwt/treenode_expand_plus.gifx']"));
		return this;
	}

	public LocationsServicePage expandOptionNorthAmerica() {
		click(locateElement("xpath",
				"//div[@id='treenode_0']/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/img[1]"));
		return this;
	}

	public RequestNewRecordPage clickOnRhodeIsland() throws InterruptedException {
		click(locateElement("link", "Rhode Island"));
		switchToWindow(0);
		switchToFrame(0);
		return new RequestNewRecordPage();
	}

}
