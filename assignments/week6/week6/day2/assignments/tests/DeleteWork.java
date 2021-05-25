package week6.day2.assignments.tests;

import org.testng.annotations.Test;

import week6.day2.assignments.hooks.TestNgHooks;
import week6.day2.assignments.pages.ServiceLoginPage;

public class DeleteWork extends TestNgHooks {

	@Test
	public void deleteWork() throws InterruptedException {

		new ServiceLoginPage().typeUName().typePwd().clickLoginButton().filterNavigatorWork().getNumOption()
				.getExistingData("REQ0010237").clickFirstResultantNumber().clickOnDeleteButton().clickOnDelOkButn()
				.getNumOption().getExistingData("REQ0010237").verifyWorkDeletionStatus("REQ0010237");
	}

}
