package week6.day2.assignments.tests;

import org.testng.annotations.Test;

import week6.day2.assignments.hooks.TestNgHooks;
import week6.day2.assignments.pages.ServiceLoginPage;

public class CreateWork extends TestNgHooks {

	@Test
	public void createWork() throws InterruptedException {

		new ServiceLoginPage().typeUName().typePwd().clickLoginButton().filterNavigatorWork().clickOnTaskNewButton()
				.clickOnTypeRequest().clickOnLocationLookup().expandOptionAmericas().expandOptionNorthAmerica()
				.clickOnRhodeIsland().setApprovalValue().setRequestStateValue().getRequestNum().clickOnSubmitButton()
				.getNumOption().getNumOptionValue().getResultantNumberValue().getResultantStateValue()
				.verifyWorkCreationStatus();
	}

}
