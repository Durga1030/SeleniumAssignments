package week6.day2.assignments.tests;

import org.testng.annotations.Test;

import week6.day2.assignments.hooks.TestNgHooks;
import week6.day2.assignments.pages.ServiceLoginPage;

public class CreateCaller extends TestNgHooks {

	@Test
	public void createCallerTest() throws InterruptedException {

		new ServiceLoginPage().typeUName().typePwd().clickLoginButton().filterNavigatorCaller().clickNewButton()
				.assignFirstName("Shri").assignlastName("Test").assignEmail("shri123@gmail.com")
				.clickOnUserTitleLookup().getUserTitle().clickOnSubmitButton().verifyCreatedUser("Shri", "Test");

	}

}
