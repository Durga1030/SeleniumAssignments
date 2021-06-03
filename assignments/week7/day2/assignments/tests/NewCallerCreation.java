package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class NewCallerCreation extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Create New Caller";
		testDescription = "Create new Caller on Service Now application";
		nodes = "Caller";
		dataSheetName = "TC_CreateCaller";
		category = "Sanity";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void createNewCallerTest(String userName, String password, String filterNav, String firstName,
			String lastName, String businessNum, String userEmail) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton().filterNavigatorCaller(filterNav)
				.clickNewButton().assignFirstName(firstName).assignlastName(lastName).assignBusinessNum(businessNum)
				.assignEmail(userEmail).clickOnUserTitleLookup().selectUserTitle().clickOnSubmitButton()
				.searchLastNameOption().searchLastNameValue(lastName).verifyCreatedUserCaller(firstName, lastName);
	}

}