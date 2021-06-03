package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class UpdateMobileOrder extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Service Category - Update Existing Mobile Order";
		testDescription = "Need to update an existing order of Apple iPhone6s in Service Now Application";
		nodes = "Service Category - Order";
		dataSheetName = "TC_UpdateMobileOrder";
		category = "Regression";
		authors = "Durga";
	}

//REQ0010319, REQ0010320
	@Test(dataProvider = "fetchData")
	public void updateExistingMobileOrder(String userName, String password, String filterNav, String existingOrderVal,
			String orderShortDesc) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorServiceCategory(filterNav).clickOnRequestOption()
				.assignExistingOrderValue(existingOrderVal).clickOnFirstResultingReqNum().getReqNum()
				.assignOrderReqApproval().assignOrderReqState().assignOrderShortDesc(orderShortDesc)
				.clickOnUpdateButton().personalizedListSettingsFilter().getResultantOrderShortDesc()
				.verifyUpdatedOrderStatus(orderShortDesc);
	}

}
