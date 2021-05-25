package week6.day2.assignments.tests;

import org.testng.annotations.Test;

import week6.day2.assignments.hooks.TestNgHooks;
import week6.day2.assignments.pages.ServiceLoginPage;

public class CreateProposal extends TestNgHooks {

	@Test
	public void createIncidentTest() throws InterruptedException {

		new ServiceLoginPage().typeUName().typePwd().clickLoginButton().filterNavigatorProposal().clickOnMyProposals()
				.clickNewButton().getProposalNumber().assignTemplateDesc("Sample Test Proposal Creation")
				.clickChangeReqValuesTab().assignShortDesc("Sample Test Proposal Creation").clickOnSubmitButton()
				.verifyCreatedProposal();

	}

}
