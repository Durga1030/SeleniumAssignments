package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class DeleteMobileOrder extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Service Category - Delete ExistingOrder";
		testDescription = "Need to delete an existing order of Apple iPhone6s in Service Now Application";
		nodes = "Service Category - Delete Order";
		dataSheetName = "TC_DeleteMobileOrder";
		category = "Regression";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void deleteExistingMobileOrder(String userName, String password, String filterNav)
			throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorServiceCategory(filterNav).clickOnMobilesOption().clickAppleiPhone6s()
				.enterMobileColor().enterMobileStorage().enterMonthlyAllowances().clickOnOrderNowButton()
				.getOrderReqNum().clickOrderReqNum().getReqNum().clickOnDeleteButton().clickOnBackToCatalog()
				.clickOnRequestOption().searchOptionNum().assignSearchValue().verifyDeletedOrderStatus();

	}

}
