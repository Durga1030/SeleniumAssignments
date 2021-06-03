package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class ProposalSelfService extends TestNgHooks {

	public static String resultantProposalNum;
	public static String resultantProposalStateValue;

	public ProposalSelfService verifySuccessMessage() {
		return this;

	}

	public PropNewRecordPage clickNewButton() throws InterruptedException {
		// switchToFrame(0);
		click(locateElement("id", "sysverb_new"));
		return new PropNewRecordPage();
	}

	public ProposalSelfService clickOnOpenProposals() {
		click(locateElement("xpath", "//div[text()='Open Proposals']"));
		return this;
	}

	public ProposalSelfService clickOnMyProposals() {
		click(locateElement("xpath", "//div[text()='My Proposals']"));
		switchToFrame(0);
		return this;
	}

	public ProposalSelfService searchOptionNum() {
		selectDropDownUsingIndex(
				locateElement("xpath", "//span[@class='input-group-addon input-group-select']//select[1]"), 1);
		return this;
	}

	public ProposalSelfService assignSearchValue() throws InterruptedException {
		TypeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"), PropNewRecordPage.proposalNumber);
		return this;
	}

	public ProposalSelfService assignExistingProposalSearchValue(String extProposalNum) throws InterruptedException {
		TypeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"), extProposalNum);
		return this;
	}

	public PropExistingRecordPage clickOnResultantProposal() {
		click(locateElement("css", "table#std_change_proposal_table>tbody>tr>td:nth-of-type(3)>a"));
		return new PropExistingRecordPage();
	}

	public ProposalSelfService verifyCreatedProposal() throws InterruptedException {
		System.out.println(PropNewRecordPage.proposalNumber + " needs to verify");
		verifyExactText(locateElement("xpath", "//a[@class='linked formlink']"), PropNewRecordPage.proposalNumber);
		return this;
	}

	public ProposalSelfService getResultantProposalNum() {
		resultantProposalNum = getElementText(
				locateElement("css", "table#std_change_proposal_table>tbody>tr>td:nth-of-type(3)"));
		System.out.println(resultantProposalNum);
		return this;
	}

	public ProposalSelfService getResultantProposalStateValue() {
		resultantProposalStateValue = getElementText(
				locateElement("css", "table#std_change_proposal_table>tbody>tr>td:nth-of-type(6)"));
		System.out.println(resultantProposalStateValue);
		return this;
	}

	public ProposalSelfService verifyUpdatedProposalChanges() {

		verifyExactText(locateElement("css", "table#std_change_proposal_table>tbody>tr>td:nth-of-type(3)"),
				resultantProposalNum);
		verifyExactText(locateElement("css", "table#std_change_proposal_table>tbody>tr>td:nth-of-type(6)"),
				resultantProposalStateValue);
		return this;
	}

}
