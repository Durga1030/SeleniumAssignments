package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class NewChangeCreation extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Create New Change Request";
		testDescription = "Create new Change Request on Service Now application";
		nodes = "Change Request";
		dataSheetName = "TC_CreateNewCR";
		category = "Sanity";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void createNewChangeRequest(String userName, String password, String filterNav, String shortDescCRVal)
			throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorChangeReq(filterNav).clickCreateNewOption().clickOnNormalChange().getChangeReqNum()
				.assignShortDesc(shortDescCRVal).clickOnSubmitButton().clickOpenOption().searchOptionNum()
				.assignNewCRValue().getResultantCRNum().verifyCreatedChangeReq();

	}

}
