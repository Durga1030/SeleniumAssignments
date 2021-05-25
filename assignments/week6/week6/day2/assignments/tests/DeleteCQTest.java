package week6.day2.assignments.tests;

import org.testng.annotations.Test;

import week6.day2.assignments.hooks.TestNgHooks;
import week6.day2.assignments.pages.ServiceLoginPage;

public class DeleteCQTest extends TestNgHooks {

	static String inputDeleteCQNum = "CHAT0010080";

	@Test
	public void deleteChatQueue() throws InterruptedException {

		new ServiceLoginPage().typeUName().typePwd().clickLoginButton().filterNavigatorExistingWork().getNumOption()
				.enterExistingCQNum(inputDeleteCQNum).clickFirstResultantCQNum().getCQNum()
				.clickDeleteBtn(inputDeleteCQNum).getCQNumOption().enterExistingCQNum(inputDeleteCQNum)
				.getResultantText().verifyDeleteCQStatus();
	}

}
