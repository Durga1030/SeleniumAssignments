package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class AssignIncident extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Assign Value to an Existing Incident Information";
		testDescription = "Assign group to an existing incident information on Service Now application";
		nodes = "Incident";
		dataSheetName = "TC_AssignIncident";
		category = "Regression";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void assignIncident(String userName, String password, String filterNav, String existingIncNum,
			String assignGrpVal, String assignedToVal) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorIncident(filterNav).clickOpenOption().assignExistingIncidentNum(existingIncNum)
				.clickOnResultingIncNum().assignStateValue().assignShortDesc().clickOnAssignGrpLookup()
				.enterAssignGroupValue(assignGrpVal).clickOnIncidentSoftware().clickOnAssignedToLookup()
				.assignAssignedToITILUser(assignedToVal).clickOnIncidentITILUserLink().clickOnUpdateButton()
				.getResultantIncAssignedTo().verifyAssessIncident(existingIncNum);

	}

}

/*
 * public void assessChangeRequest(String userName, String password, String
 * filterNav, String existingCRNum, String shortDescCRVal, String assignedToVal)
 * throws InterruptedException {
 * 
 * new
 * ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
 * .filterNavigatorChangeReq(filterNav).clickOpenOption().searchOptionNum()
 * .assignexistingCRValue(existingCRNum).clickOnResultantCRNum().assignShortDesc
 * (shortDescCRVal)
 * .assignStateValue().clickOnAssignGrpLookup().clickOnSoftware().
 * clickOnAssignedToLookup()
 * .assignAssignedToITILUser(assignedToVal).clickOnITILUserLink().
 * clickOnUpdateButton().getResultantCRNum()
 * .getResultantStateVal().getResultantCRAssignedTo().verifyAssessChangeReq(
 * existingCRNum); }
 */