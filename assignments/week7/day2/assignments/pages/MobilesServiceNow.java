package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class MobilesServiceNow extends TestNgHooks {

	// Click on Apple iPhone6s

	public MobileBrandNamePage clickAppleiPhone6s() {

		click(locateElement("xpath", "//strong[text()='Apple iPhone 6s']"));

		return new MobileBrandNamePage();
	}

}
