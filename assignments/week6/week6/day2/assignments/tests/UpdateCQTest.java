package week6.day2.assignments.tests;

import org.testng.annotations.Test;

import week6.day2.assignments.hooks.TestNgHooks;
import week6.day2.assignments.pages.ServiceLoginPage;

public class UpdateCQTest extends TestNgHooks {

	@Test
	public void createCQTest() throws InterruptedException {

		new ServiceLoginPage().typeUName().typePwd().clickLoginButton().filterNavigatorExistingWork().getNumOption()
				.enterExistingCQNum("CHAT0010076").clickFirstResultantCQNum().getCQNum()
				.getLongDesc("Test - Update an Existing CQ Entry").getShortDesc("Test - Update an Existing CQ Entry")
				.clickOnUpdateBtn().getNumOption().enterExistingCQNum("CHAT0010076").getResultantCQNum()
				.getResultantShortDesc().verifyCQEntryUpdate("Test - Update an Existing CQ Entry");
	}

}
