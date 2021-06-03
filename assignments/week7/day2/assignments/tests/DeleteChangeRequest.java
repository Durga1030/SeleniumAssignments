package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class DeleteChangeRequest extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Delete Existing Change Request";
		testDescription = "Delete an existing Change Request from Service Now application";
		nodes = "Change Request";
		dataSheetName = "TC_DeleteCR";
		category = "Regression";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void deleteChangeRequest(String userName, String password, String filterNav, String searchStateVal,
			String existingCRNum, String expectedDeletedResult) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorChangeReq(filterNav).clickOpenOption().searchOptionState()
				.assignStateValue(searchStateVal).getFilterOptionsToDelete().clickOnResultantCRNum()
				.clickOnDeleteButton().getResultantDelStatus().verifyDeletedCRStatus(expectedDeletedResult);
//.assignExistingCRNumDel(existingCRNum)

	}

}
