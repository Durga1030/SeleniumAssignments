package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class UserUpdateRecordPage extends TestNgHooks {

	public static String existingBusinessNum;
	public static String existingEmailId;

	public UserUpdateRecordPage getExistingBusinessNum() {
		existingBusinessNum = getTypedText(locateElement("sys_user.phone"));
		return this;
	}

	public UserUpdateRecordPage getExistingEmailId() {
		existingEmailId = getTypedText(locateElement("sys_user.email"));
		return this;
	}

	public UserUpdateRecordPage updatebusinessNum(String businessNum) {
		clearAndType(locateElement("id", "sys_user.phone"), businessNum);
		System.out.println("Need to update Business Number from " + existingBusinessNum + " to " + businessNum);
		return this;
	}

	public UserUpdateRecordPage assignMobilePhnNum(String businessNum) {
		clearAndType(locateElement("id", "sys_user.mobile_phone"), businessNum);
		return this;
	}

	public UserSelfService clickOnUpdateButton() {
		click(locateElement("css", "button#sysverb_update_bottom"));
		return new UserSelfService();
	}

	public UserSelfService clickOnDeleteButton() {
		/*
		 * driver.findElement(By.cssSelector("button#sysverb_delete")).click();
		 * driver.findElement(By.cssSelector("button#ok_button")).click();
		 */
		click(locateElement("css", "button#sysverb_delete"));
		click(locateElement("css", "button#ok_button"));

		return new UserSelfService();
	}

}
