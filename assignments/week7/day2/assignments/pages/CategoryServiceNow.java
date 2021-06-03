package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class CategoryServiceNow extends TestNgHooks {

	public PropExistingRecordPage clickOnTemplateManagement() {
		click(locateElement("link", "Template Management"));
		switchToWindow(0);
		switchToFrame(0);
		return new PropExistingRecordPage();
	}

}
