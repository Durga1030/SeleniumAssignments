package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class UserSelectItemPage extends TestNgHooks {

	public UserNewRecordPage selectUserTitle() throws InterruptedException {
		// click(locateElement("link", "System Administrator"));
		click(locateElement("link", "Senior Developer"));
		switchToWindow(0);
		switchToFrame(0);
		return new UserNewRecordPage();
	}

}
