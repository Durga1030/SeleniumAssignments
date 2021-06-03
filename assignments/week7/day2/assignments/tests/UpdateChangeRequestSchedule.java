package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class UpdateChangeRequestSchedule extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Update the Change Request Schedule";
		testDescription = "Update schedule Value of Change Request on Service Now application";
		nodes = "Change Request";
		dataSheetName = "TC_UpdateCRSchedule";
		category = "Regression";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void assessChangeRequest(String userName, String password, String filterNav, String existingCRNum,
			String shortDescCRVal) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorChangeReq(filterNav).clickOpenOption().searchOptionNum()
				.assignexistingCRValue(existingCRNum).clickOnResultantCRNum().assignShortDesc(shortDescCRVal)
				.clickOnScheduleTab().clickStartDateCalenderIcon().selectStartDate().clickSaveDateCR()
				.getEnteredStartDateValue().clickEndDateCalenderIcon().clickSaveDateCR().getEnteredEndDateValue()
				.clickOnCabReqCheckBox().clickOnCabDateCalenderIcon().selectCabDate().clickOnUpdateButton()
				.getResultantCRStartDate().getResultantCREndDate().verifyUpdateScheduleChangeReq(existingCRNum);

	}
}
