package week6.day2.tests;

import org.testng.annotations.Test;

import week6.day2.hooks.HooksTest;
import week6.day2.pages.LoginPage;

public class CreateLead extends HooksTest {

	@Test
	public void createLeadTest() {

		new LoginPage().typeUName().typePwd().clickLoginButton().clickCrmSfaLink().clickLeadsOption()
				.clickCreateLeadsMenu().assignCompanyName("Oracle").assignFName("Dev").assignLName("T")
				.clickCreateLeadBtn().verifyCompanyName();

	}

}
