package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class UpdateExitingChatQueue extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Update an existing Chat Queue Entry";
		testDescription = "Update an Existing Chat Queue Entry on Service Now application";
		nodes = "Queue Entry";
		dataSheetName = "TC_UpdateChatQueue";
		category = "Regression";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void updateExistingChatQueueEntry(String userName, String password, String filterNav, String extCQNum,
			String shortDescVal, String longDescVal) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorExistingWork(filterNav).enterExistingCQNum(extCQNum).clickFirstResultantCQNum()
				.getCQNum().getShortDesc(shortDescVal).getLongDesc(longDescVal).clickOnUpdateBtn()
				.enterExistingCQNum(extCQNum).getResultantShortDesc().verifyCQEntryUpdate();

	}

}
