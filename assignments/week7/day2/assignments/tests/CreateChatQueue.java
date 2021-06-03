package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class CreateChatQueue extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Create Chat Queue Entry";
		testDescription = "Create new Chat Queue Entry on Service Now application";
		nodes = "Queue Entry";
		dataSheetName = "TC_ChatQueue";
		category = "Sanity";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void createChatQueueEntry(String userName, String password, String filterNav) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorExistingWork(filterNav).clickOnTaskNewButton().clickOnTypeChatQueue().getChatQNum()
				.clickOnSubmitButton().searchOptionNum().assignCQValue().getResultantCQNum().verifyCreatedChatQ();

	}

}
