package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class CreateNewWorkRequest extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Create New Work";
		testDescription = "Create new Work Request in Service Now application";
		nodes = "Request Management";
		dataSheetName = "TC_NewWorkRequest";
		category = "Sanity";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void newWorkRequest(String userName, String password, String filterNav) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorExistingWork(filterNav).clickOnTaskNewButton().clickOnTypeRequest().getRequestNum()
				.clickOnLocationLookup().expandOptionAmericas().expandOptionNorthAmerica().clickOnRhodeIsland()
				.setApprovalValue().setRequestStateValue().clickOnSubmitButton().searchOptionNum().assignNewWorkValue()
				.verifyWorkCreationStatus();
	}

}
