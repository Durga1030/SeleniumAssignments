package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class CreateProposal extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Create New Proposal";
		testDescription = "Create new Proposal on Service Now application";
		nodes = "Proposal";
		dataSheetName = "TC_CreateProposal";
		category = "Sanity";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void createProposalTest(String userName, String password, String filterNav, String tempDescVal,
			String shortDescVal) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorProposal(filterNav).clickOnMyProposals().clickNewButton().getProposalNumber()
				.assignTemplateDesc(tempDescVal).clickChangeReqValuesTab().assignShortDesc(shortDescVal)
				.clickOnSubmitButton().searchOptionNum().assignSearchValue().verifyCreatedProposal();

	}

}
