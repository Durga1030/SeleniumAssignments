package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class UpdateProposal extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Update an Existing Proposal";
		testDescription = "Update Mandatory fields on an Existing Proposal in the Service Now application";
		nodes = "Proposal";
		dataSheetName = "TC_UpdateExistingProposal";
		category = "Regression";
		authors = "Durga";

	}

	// STDCHG0001391,STDCHG0001392,STDCHG0001393,STDCHG0001394
	@Test(dataProvider = "fetchData")
	public void updateExistingProposal(String userName, String password, String filterNav, String extProposalNum,
			String templateDesc, String assignGrpVal, String justificationVal, String rickImpactVal)
			throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorProposal(filterNav).clickOnMyProposals().searchOptionNum()
				.assignExistingProposalSearchValue(extProposalNum).clickOnResultantProposal().selectProposalState()
				.clickOnCategoryLookup().clickOnTemplateManagement().enterTemplateName(templateDesc)
				.enterTemplateDescription(templateDesc).clickOnCRValuesTab().clickOnAssignmentGrpLookup()
				.enterAssignGroupValue(assignGrpVal).clickOnCMLink().enterJustifiction(justificationVal)
				.enterRiskImpact(rickImpactVal).clickOnUpdateButton().getResultantProposalNum()
				.getResultantProposalStateValue().verifyUpdatedProposalChanges();
//.searchOptionNum().assignExistingProposalSearchValue(extProposalNum)
	}

}
