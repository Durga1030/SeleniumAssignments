package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class CreateArticle extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Create New Article";
		testDescription = "Create new Article on Service Now application";
		nodes = "Article";
		dataSheetName = "TC_CreateArticle";
		category = "Sanity";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void createArticleTest(String userName, String password, String filterNav, String shortDesc)
			throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorArticle(filterNav).clickOnCreateNew().getKnowledgeNum().clickOnKnowledgeLookup()
				.clickOnKnowledgeLink().assignShortDesc(shortDesc).clickOnSubmitButton().searchOptionNum()
				.assignSearchValue().getResultantKNum().getResultantShortDesc().verifyCreatedArticle();
	}

}
