package week6.day2.assignments.tests;

import org.testng.annotations.Test;

import week6.day2.assignments.hooks.TestNgHooks;
import week6.day2.assignments.pages.ServiceLoginPage;

public class CreateTestCQ extends TestNgHooks {

	@Test
	public void createCQTest() throws InterruptedException {

		new ServiceLoginPage().typeUName().typePwd().clickLoginButton().filterNavigatorWork().clickOnTaskNewButton()
				.clickOnTypeChatQueue().getChatQNum().clickOnSubmitButton().getCQNumOption().getCQnumValue()
				.getResultantCQNum().verifyCreatedChatQ();
	}

}
