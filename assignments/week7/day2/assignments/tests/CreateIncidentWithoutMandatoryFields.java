package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class CreateIncidentWithoutMandatoryFields extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Create Incident without Mandatory Fields";
		testDescription = "Create an incident wothout filling Mandatory field values in Service Now application";
		nodes = "Incident";
		dataSheetName = "TC_CreateIncidentWithMissingFields";
		category = "Regression";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void createIncidentWithMissingFields(String userName, String password, String filterNav)
			throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorIncident(filterNav).clickNewButton().getIncNumber().clickSubmitToVerifyError()
				.getIncErrorMessage().verifyIncCreationErrorMsg();

	}

}
