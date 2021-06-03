package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class IncUserServiceNow extends TestNgHooks {

	public IncNewRecordPage assignUserValue() throws InterruptedException {

		// Thread.sleep(100);
		// switchToWindow(1);
		// String subWindowTitle = getDriver().getTitle();
		// System.out.println("Sub-window title: " + subWindowTitle);
		click(locateElement("xpath", "(//label[text()='Search'])[2]/following::input"));
		TypeAndEnter(locateElement("xpath", "(//label[text()='Search'])[2]/following::input"), "System");
		click(locateElement("link", "System Administrator"));
		switchToWindow(0);
		switchToFrame(0);

		return new IncNewRecordPage();
	}
}
