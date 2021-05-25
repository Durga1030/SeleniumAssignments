package week6.day2.assignments.tests;

import org.testng.annotations.Test;

import week6.day2.assignments.hooks.TestNgHooks;
import week6.day2.assignments.pages.ServiceLoginPage;

public class CreateIncident extends TestNgHooks {

	@Test
	public void createIncidentTest() throws InterruptedException {

		new ServiceLoginPage().typeUName().typePwd().clickLoginButton().filterNavigatorIncident().clickNewButton()
				.getIncNumber().clickCallerInfoLookup().assignUserValue().assignShortDesc().clickOnSubmitButton()
				.verifyCreatedIncident();

	}

}
