package week6.day2.assignments.tests;

import org.testng.annotations.Test;

import week6.day2.assignments.hooks.TestNgHooks;
import week6.day2.assignments.pages.ServiceLoginPage;

public class CreateTestArticle extends TestNgHooks {

	@Test
	public void createArticleTest() throws InterruptedException {

		new ServiceLoginPage().typeUName().typePwd().clickLoginButton().filterNavigatorArticle().clickOnCreateNew()
				.getKnowledgeNum().clickOnKnowledgeLookup().clickOnKnowledgeLink()
				.assignShortDesc("Test - New Article creation").clickOnSubmitButton().searchOptionNum()
				.assignSearchValue().getResultantKNum().getResultantShortDesc().verifyCreatedArticle();
	}

}
