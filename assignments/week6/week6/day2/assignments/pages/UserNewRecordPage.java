package week6.day2.assignments.pages;

import org.openqa.selenium.By;

import week6.day2.assignments.hooks.TestNgHooks;

public class UserNewRecordPage extends TestNgHooks {

	public UserNewRecordPage assignFirstName(String firstName) {
		driver.findElement(By.id("sys_user.first_name")).sendKeys(firstName);
		return this;
	}

	public UserNewRecordPage assignlastName(String lastName) {
		driver.findElement(By.id("sys_user.last_name")).sendKeys(lastName);
		return this;
	}

	public UserNewRecordPage assignEmail(String userEmail) {
		driver.findElement(By.id("sys_user.email")).sendKeys(userEmail);
		return this;
	}

	public UserSelectItemPage clickOnUserTitleLookup() {
		driver.findElement(By.id("lookup.sys_user.title")).click();
		return new UserSelectItemPage();
	}

	public UserSelfService clickOnSubmitButton() {
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		return new UserSelfService();
	}

}
