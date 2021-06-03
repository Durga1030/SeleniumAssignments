package week7.day2.assignments.pages;

import org.openqa.selenium.By;

import week7.day2.assignments.hooks.TestNgHooks;

public class UserSelfService extends TestNgHooks {

	public static String resultMobileNo;
	public static String resultLastName;
	public static String resultFirstName;
	public static String resultantDeleteCR;

	public UserSelfService verifySuccessMessage() {
		getDriver().switchTo().frame(0);
		String selfServiceView = getDriver().findElement(By.cssSelector("div#list_nav_incident>div>div>h1>a"))
				.getText();

		if (selfServiceView.contains("Users[ITIL view]")) {
			System.out.println("Login Success");
		}
		return this;
	}

	public UserSelfService searchLastNameOption() {
		selectDropDownUsingIndex(locateElement("css", "span#sys_user_hide_search>div>div>span>span>select"), 1);
		return this;
	}

	public UserSelfService searchTextOption() {
		selectDropDownUsingIndex(locateElement("css", "span#sys_user_hide_search>div>div>span>span>select"), 0);
		return this;
	}

	public UserSelfService searchLastNameValue(String lastName) throws InterruptedException {
		click(locateElement("css", "span#sys_user_hide_search>div>div>input"));
		TypeAndEnter(locateElement("css", "span#sys_user_hide_search>div>div>input"), lastName);
		return this;
	}

	public UserSelfService searchBusinessPhnOption() {
		selectDropDownUsingIndex(locateElement("css", "span#sys_user_hide_search>div>div>span>span>select"), 3);
		return this;
	}

	public UserSelfService searchBusinessPhnValue(String businessNum) throws InterruptedException {
		click(locateElement("css", "span#sys_user_hide_search>div>div>input"));
		TypeAndEnter(locateElement("css", "span#sys_user_hide_search>div>div>input"), businessNum);
		return this;
	}

	public UserSelfService getResultantPhNum() {
		resultMobileNo = getElementText(locateElement("xpath", "(//td[@class='vt'])[3]"));
		System.out.println(resultMobileNo);
		return this;
	}

	public UserSelfService getResultantFName() {
		resultFirstName = getElementText(locateElement("css", "table#sys_user_table>tbody>tr>td:nth-of-type(4)"));
		return this;
	}

	public UserSelfService getResultantLName() {
		resultLastName = getElementText(locateElement("css", "table#sys_user_table>tbody>tr>td:nth-of-type(3)>a"));
		return this;
	}

	public UserUpdateRecordPage clickOnResultingResult() {
		click(locateElement("css", "table#sys_user_table>tbody>tr>td:nth-of-type(3)>a"));
		return new UserUpdateRecordPage();
	}

	public UserSelfService verifyUpdatedUserInfo(String businessNum) throws InterruptedException {
		verifyExactText(locateElement("xpath", "(//td[@class='vt'])[3]"), businessNum);
		System.out.println(UserUpdateRecordPage.existingBusinessNum + " has been updated to " + businessNum);
		return this;
	}

	public UserNewRecordPage clickNewButton() {
		// switchToFrame(0);
		click(locateElement("css", "button#sysverb_new"));
		return new UserNewRecordPage();
	}

	public UserSelfService verifyCreatedUserCaller(String firstName, String lastName) {
		verifyExactText(locateElement("css", "table#sys_user_table>tbody>tr>td:nth-of-type(4)"), firstName);
		verifyExactText(locateElement("css", "table#sys_user_table>tbody>tr>td:nth-of-type(3)>a"), lastName);
		return this;
	}

	public UserSelfService getResultantStatus() {
		resultantDeleteCR = getElementText(locateElement("xpath", "//td[text()='No records to display']"));
		System.out.println("Status After deleting the caller: " + resultantDeleteCR);
		return this;
	}

	public UserSelfService verifyDeletedCallerStatus(String expectedDeletedResult) {
		System.out.println(resultantDeleteCR + " matches with the expected result: " + expectedDeletedResult);
		verifyExactText(locateElement("xpath", "//td[text()='No records to display']"), expectedDeletedResult);
		return this;
	}

}
