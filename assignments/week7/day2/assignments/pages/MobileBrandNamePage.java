package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class MobileBrandNamePage extends TestNgHooks {

	public MobileBrandNamePage enterMonthlyAllowances() {

		selectDropDownUsingIndex(locateElement("xpath", "//div[contains(@class,'col-xs-6 ')]//select"), 2);

		return this;
	}

	public MobileBrandNamePage enterMobileColor() {

		selectDropDownUsingIndex(locateElement("xpath", "(//div[contains(@class,'col-xs-6 ')]//select)[2]"), 3);

		return this;
	}

	public MobileBrandNamePage enterMobileStorage() {
		selectDropDownUsingIndex(locateElement("xpath", "(//div[contains(@class,'col-xs-6 ')]//select)[3]"), 2);

		return this;
	}

	public MobileOrderStatusPage clickOnOrderNowButton() {

		click(locateElement("id", "oi_order_now_button"));

		return new MobileOrderStatusPage();
	}

}
