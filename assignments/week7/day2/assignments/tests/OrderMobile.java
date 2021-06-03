package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class OrderMobile extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Service Category - New Order";
		testDescription = "Need to place an order of Apple iPhone6s in Service Now Application";
		nodes = "Service Category - Order";
		dataSheetName = "TC_MobileOrder";
		category = "Sanity";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void orderMobile(String userName, String password, String filterNav) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorServiceCategory(filterNav).clickOnMobilesOption().clickAppleiPhone6s()
				.enterMobileColor().enterMobileStorage().enterMonthlyAllowances().clickOnOrderNowButton()
				.getOrderedStatusMsg().getOrderReqNum().verifyOrderStatus();
	}

}
