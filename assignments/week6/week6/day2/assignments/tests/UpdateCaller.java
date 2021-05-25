package week6.day2.assignments.tests;

import org.testng.annotations.Test;

import week6.day2.assignments.hooks.TestNgHooks;
import week6.day2.assignments.pages.ServiceLoginPage;

public class UpdateCaller extends TestNgHooks {

	@Test
	public void createCallerTest() throws InterruptedException {

		/*
		 * new ServiceLoginPage().typeUName().typePwd().clickLoginButton().
		 * filterNavigatorCaller().clickNewButton()
		 * .assignFirstName("Shri").assignlastName("Test").assignEmail(
		 * "shri123@gmail.com")
		 * .clickOnUserTitleLookup().getUserTitle().clickOnSubmitButton().
		 * verifyCreatedUser("Shri", "Test");
		 */

		new ServiceLoginPage().typeUName().typePwd().clickLoginButton().filterNavigatorCaller().searchLastNameOption()
				.searchLastNameValue("DTest").clickOnResultingResult().updatebusinessNum("(999) 977-8888")
				.clickOnUpdateButton().searchBusinessPhnOption().searchBusinessPhnValue("(999) 977-8888")
				.getResultantFName().getResultantLName().getResultantPhNum()
				.verifyUpdatedUserInfo("Shri", "DTest", "(999) 977-8888");

	}

}
