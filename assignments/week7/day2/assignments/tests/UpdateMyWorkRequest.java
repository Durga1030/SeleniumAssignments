package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class UpdateMyWorkRequest extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Update Work";
		testDescription = "Update Work Request in Service Now application";
		nodes = "Request Management";
		dataSheetName = "TC_NewWorkRequest";
		category = "Regression";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void updateWorkRequest(String userName, String password, String filterNav) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorExistingWork(filterNav).clickOnTaskNewButton().clickOnTypeRequest().getRequestNum()
				.clickOnLocationLookup().expandOptionAmericas().expandOptionNorthAmerica().clickOnRhodeIsland()
				.setApprovalValue().setRequestStateValue().clickOnDueDateLookup().clickOnDate().clickOnSubmitButton()
				.searchOptionNum().assignNewWorkValue().getResultantNumberValue().getResultantLocationValue()
				.verifyWorkCreationStatus();
	}

}
