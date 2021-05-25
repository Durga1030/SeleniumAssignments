package week6.day2.assignments.tests;

import org.testng.annotations.Test;

import week6.day2.assignments.hooks.TestNgHooks;
import week6.day2.assignments.pages.ServiceLoginPage;

public class CreateTestArticleWithUpdates extends TestNgHooks {

	@Test
	public void createArticleTest() throws InterruptedException {

		new ServiceLoginPage().typeUName().typePwd().clickLoginButton().filterNavigatorArticle().clickOnCreateNew()
				.getKnowledgeNum().clickOnKnowledgeITLookup().clickOnITLink().clickOnCategoryLookup().selectITJava()
				.clickOKButton().assignShortDesc("Test - New Article creation by updating Mandatory fields")
				.clickOnSubmitButton().searchOptionNum().assignSearchValue().getResultantKNum().getResultantShortDesc()
				.getResultantCategory().getResultantKB().verifyArticlewithMandatoryFields();
	}

}
