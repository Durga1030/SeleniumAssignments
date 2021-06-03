package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class DeleteIncident extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Delete Existing Incident";
		testDescription = "Delete an existing incident from Service Now application";
		nodes = "Incident";
		dataSheetName = "TC_DeleteIncident";
		category = "Regression";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData", enabled = false)
	public void deleteIncident(String userName, String password, String filterNav, String existingIncNum,
			String expectedDeletedResult) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorIncident(filterNav).clickOpenOption().assignExistingIncidentNum(existingIncNum)
				.clickOnResultingIncNum().clickOnDeleteButton().verifyDeletedIncidentStatus(expectedDeletedResult);
	}

}
