package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class CatalogServiceNow extends TestNgHooks {

	// Click On Mobiles

	public MobilesServiceNow clickOnMobilesOption() {
		switchToFrame(0);
		click(locateElement("xpath", "//h2[text()[normalize-space()='Mobiles']]"));

		return new MobilesServiceNow();
	}

	public MobileReqServicePage clickOnRequestOption() {
		click(locateElement("xpath", "//div[text()='Requests']"));
		switchToFrame(0);
		return new MobileReqServicePage();
	}

}
