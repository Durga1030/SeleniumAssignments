package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class CancelExistingWorkRequest extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Cancel Existing Work Request";
		testDescription = "Cancel Existing Work Request in Service Now application";
		nodes = "Request Management";
		dataSheetName = "TC_CancelWorkRequest";
		category = "Sanity";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void newWorkRequest(String userName, String password, String filterNav, String expectedCancelledResult)
			throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorExistingWork(filterNav).clickOnTaskNewButton().clickOnTypeRequest().getRequestNum()
				.clickOnLocationLookup().expandOptionAmericas().expandOptionNorthAmerica().clickOnRhodeIsland()
				.setApprovalValue().setRequestStateValue().clickOnSubmitButton().searchOptionNum().assignNewWorkValue()
				.clickFirstResultantWorkNumber().clickOnCancelReqButton().searchOptionNum().assignNewWorkValue()
				.verifyCancelleddWRStatus(expectedCancelledResult);
	}

}
