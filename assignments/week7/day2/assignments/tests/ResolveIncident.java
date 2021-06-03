package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class ResolveIncident extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Resolve Incident Information";
		testDescription = "Update an existing incident state information as Resolved on Service Now application";
		nodes = "Incident";
		dataSheetName = "TC_ResolveIncident";
		category = "Regression";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void resolveIncident(String userName, String password, String filterNav, String existingIncNum,
			String expectedStateVal, String notesValue) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorIncident(filterNav).clickOpenOption().assignExistingIncidentNum(existingIncNum)
				.clickOnResultingIncNum().assignStateValueResolve().assignResolutionInformation(notesValue)
				.clickOnResolveButton().getResultantState()
				.verifyResolvedIncidentStatus(existingIncNum, expectedStateVal);

	}
}