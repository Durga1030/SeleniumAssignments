package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class DeleteWorkRequest extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Delete Existing Work Request";
		testDescription = "Delete Existing Work Request in Service Now application";
		nodes = "Request Management";
		dataSheetName = "TC_DeleteWorkRequest";
		category = "Sanity";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void deleteWorkRequest(String userName, String password, String filterNav, String expectedDeletedResult)
			throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorExistingWork(filterNav).clickOnTaskNewButton().clickOnTypeRequest().getRequestNum()
				.clickOnLocationLookup().expandOptionAmericas().expandOptionNorthAmerica().clickOnRhodeIsland()
				.setApprovalValue().setRequestStateValue().clickOnSubmitButton().searchOptionNum().assignNewWorkValue()
				.clickFirstResultantWorkNumber().clickOnDeleteButton().clickOnDelOkButn().searchOptionNum()
				.assignNewWorkValue().getResultantText().verifyDeletedWorkStatus(expectedDeletedResult);
	}

}
