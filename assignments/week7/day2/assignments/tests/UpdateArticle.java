package week7.day2.assignments.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.assignments.hooks.TestNgHooks;
import week7.day2.assignments.pages.ServiceLoginPage;

public class UpdateArticle extends TestNgHooks {

	@BeforeTest
	public void setData() {
		testCaseName = "Update Existing Article";
		testDescription = "Update Article on Service Now application";
		nodes = "Article";
		dataSheetName = "TC_CreateArticle";
		category = "Regression";
		authors = "Durga";
	}

	@Test(dataProvider = "fetchData")
	public void updateArticleTest(String userName, String password, String filterNav, String shortDesc)
			throws InterruptedException {

		new ServiceLoginPage().typeUName(userName).typePwd(password).clickLoginButton()
				.filterNavigatorArticle(filterNav).clickOnCreateNew().getKnowledgeNum().assignShortDesc(shortDesc)
				.clickOnKnowledgeITLookup().clickOnITLink().clickOnCategoryLookup().selectITJava().clickOKButton()
				.clickOnSubmitButton().searchOptionNum().assignSearchValue().getResultantKB().getResultantCategory()
				.verifyArticlewithMandatoryFields();

	}

}
