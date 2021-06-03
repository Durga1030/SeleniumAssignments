package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class AssessChangeRequest extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Assess Change Request";
		testDescription = "Update State Value of Change Request on Service Now application";
		nodes = "Change Request";
		dataSheetName = "TC_AssessChangeRequest";
		category = "Regression";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void assessChangeRequest(String userName, String password, String filterNav, String existingCRNum,
			String shortDescCRVal, String assignedToVal) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorChangeReq(filterNav).clickOpenOption().searchOptionNum()
				.assignexistingCRValue(existingCRNum).clickOnResultantCRNum().assignShortDesc(shortDescCRVal)
				.assignStateValue().clickOnAssignGrpLookup().clickOnSoftware().clickOnAssignedToLookup()
				.assignAssignedToITILUser(assignedToVal).clickOnITILUserLink().clickOnUpdateButton().getResultantCRNum()
				.getResultantStateVal().getResultantCRAssignedTo().verifyAssessChangeReq(existingCRNum);
	}

}
