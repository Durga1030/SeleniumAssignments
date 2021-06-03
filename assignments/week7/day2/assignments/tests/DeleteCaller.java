package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class DeleteCaller extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Delete Existing caller";
		testDescription = "Delete an existing caller from Service Now application";
		nodes = "Caller";
		dataSheetName = "TC_DeleteCaller";
		category = "Regression";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void updateExistingCallerData(String userName, String password, String filterNav, String firstName,
			String lastName, String businessNum, String userEmail, String expectedDeletedResult)
			throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton().filterNavigatorCaller(filterNav)
				.searchLastNameOption().searchLastNameValue(lastName).clickOnResultingResult().getExistingBusinessNum()
				.clickOnDeleteButton().searchTextOption().searchLastNameValue(lastName).getResultantStatus()
				.verifyDeletedCallerStatus(expectedDeletedResult);

		/*
		 * .clickNewButton().assignFirstName(firstName).assignlastName(lastName).
		 * assignBusinessNum(businessNum)
		 * .assignEmail(userEmail).clickOnUserTitleLookup().selectUserTitle().
		 * clickOnSubmitButton()
		 * .searchLastNameOption().searchLastNameValue(lastName).verifyCreatedUserCaller
		 * (firstName, lastName);
		 */}

}
