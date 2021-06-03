package week7.day2.assignments.pages;

import org.openqa.selenium.By;

import week7.day2.assignments.hooks.TestNgHooks;

public class UserNewRecordPage extends TestNgHooks {

	public UserNewRecordPage assignFirstName(String firstName) {
		clearAndType(locateElement("id", "sys_user.first_name"), firstName);
		return this;
	}

	public UserNewRecordPage assignlastName(String lastName) {
		clearAndType(locateElement("id", "sys_user.last_name"), lastName);
		return this;
	}

	public UserNewRecordPage assignEmail(String userEmail) {
		clearAndType(locateElement("id", "sys_user.email"), userEmail);
		return this;
	}

	public UserNewRecordPage assignBusinessNum(String businessNum) {
		clearAndType(locateElement("id", "sys_user.phone"), businessNum);
		return this;
	}

	public UserNewRecordPage assignMobilePhnNum(String mobileNum) {
		clearAndType(locateElement("id", "sys_user.mobile_phone"), mobileNum);
		return this;
	}

	public UserSelectItemPage clickOnUserTitleLookup() {
		// click(locateElement("id", "lookup.sys_user.title"));
		getDriver().findElement(By.id("lookup.sys_user.title")).click();
		switchToWindow(1);
		return new UserSelectItemPage();
	}

	public UserSelfService clickOnSubmitButton() {
		click(locateElement("id", "sysverb_insert_bottom"));
		return new UserSelfService();
	}

}
