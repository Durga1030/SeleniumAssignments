package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class CreateIncident extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Create New Incident";
		testDescription = "Create new incident on Service Now application";
		nodes = "Incident";
		dataSheetName = "TC_CreateIncident";
		category = "Sanity";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void createIncidentTest(String userName, String password, String filterNav, String shortDesc)
			throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorIncident(filterNav).clickNewButton().getIncNumber().clickCallerInfoLookup()
				.assignUserValue().assignShortDesc(shortDesc).clickOnSubmitButton().searchOptionNum()
				.assignIncidentNum().verifyCreatedIncident();

		// INC0011875
	}

}
