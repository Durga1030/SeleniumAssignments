package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class DeleteChatQueue extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Delete Existing Chat Queue Entry";
		testDescription = "Delete an existing Chat Queue entry from Service Now application";
		nodes = "Queue entry";
		dataSheetName = "TC_DeleteChatQueue";
		category = "Regression";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void deleteChatQueueEntry(String userName, String password, String filterNav, String expectedDeletedResult)
			throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorExistingWork(filterNav).clickFirstResultantCQNum().getCQNum().clickDeleteBtn()
				.searchOptionNum().assignDeletedCQValue().getResultantDelStatus()
				.verifyDeletedCQStatus(expectedDeletedResult);

	}

}
