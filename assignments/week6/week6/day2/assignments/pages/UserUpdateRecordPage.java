package week6.day2.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import week6.day2.assignments.hooks.TestNgHooks;

public class UserUpdateRecordPage extends TestNgHooks {

	public UserUpdateRecordPage updatebusinessNum(String businessNum) {

		WebElement businessMobileNo = driver.findElement(By.id("sys_user.phone"));
		businessMobileNo.click();
		businessMobileNo.clear();
		businessMobileNo.sendKeys(businessNum);

		return this;
	}

	public UserSelfService clickOnUpdateButton() {
		driver.findElement(By.cssSelector("button#sysverb_update_bottom")).click();
		return new UserSelfService();
	}

}
