package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class CancelMobileOrder extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Service Category - Cancel ExistingOrder";
		testDescription = "Need to cancel an existing order of Apple iPhone6s in Service Now Application";
		nodes = "Service Category - Cancel Order";
		dataSheetName = "TC_CancelMobileOrder";
		category = "Regression";
		authors = "Durga";
	}

	// REQ0010328

	@Test(dataProvider = "fetchData")
	public void cancelExistingMobileOrder(String userName, String password, String filterNav)
			throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorServiceCategory(filterNav).clickOnMobilesOption().clickAppleiPhone6s()
				.enterMobileColor().enterMobileStorage().enterMonthlyAllowances().clickOnOrderNowButton()
				.getOrderReqNum().clickOrderReqNum().getReqNum().assignOrderReqApprovalRejected()
				.assignOrderReqStateCancelled().clickOnCancelReqButton().clickOnBackToCatalog().clickOnRequestOption()
				.searchOptionNum().assignSearchValue().verifyCancelledOrderStatus();

	}

}
