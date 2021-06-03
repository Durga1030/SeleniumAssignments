package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class UpdateExistingIncident extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Update Existing Incident Information";
		testDescription = "Update an existing incident information on Service Now application";
		nodes = "Incident";
		dataSheetName = "TC_UpdateIncident";
		category = "Regression";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void updateExistingCallerData(String userName, String password, String filterNav, String existingIncNum,
			String expectedStateVal, String expectedUrgencyVal) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorIncident(filterNav).clickOpenOption().assignExistingIncidentNum(existingIncNum)
				.clickOnResultingIncNum().assignStateValue().assignUrgencyValue().clickOnUpdateButton()
				.getResultantState().getResultantUrgency()
				.verifyUpdatedIncidentStatus(existingIncNum, expectedStateVal, expectedUrgencyVal);
	}

}
