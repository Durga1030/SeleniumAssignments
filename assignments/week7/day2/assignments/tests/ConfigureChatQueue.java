package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class ConfigureChatQueue extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Configure Chat Queue Entry";
		testDescription = "Configure Chat Queue Entry on Service Now application";
		nodes = "Queue Entry";
		dataSheetName = "TC_ConfigureChatQueue";
		category = "Regression";
		authors = "Durga";
	}
	// CHAT0010112

	@Test(dataProvider = "fetchData")
	public void configureChatQueueEntry(String userName, String password, String filterNav, String extCQNum,
			String shortDescVal, String longDescVal, String inputConfigureItem) throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorExistingWork(filterNav).enterExistingCQNum(extCQNum).clickFirstResultantCQNum()
				.getCQNum().getShortDesc(shortDescVal).getLongDesc(longDescVal).selectStateValAbandoned()
				.selectPriorityValCritical().clickOnConfigutaionItemLookup().assignConfigureItem(inputConfigureItem)
				.clickOnApacheLink(inputConfigureItem).clickOnUpdateBtn().getResultantConfigureItem()
				.verifyConfiguredCQEntry(inputConfigureItem);
	}

}
