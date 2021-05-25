package week6.day2.assignments.pages;

import org.openqa.selenium.By;

import week6.day2.assignments.hooks.TestNgHooks;

public class UserSelectItemPage extends TestNgHooks {

	public UserNewRecordPage getUserTitle() throws InterruptedException {

		TestNgHooks.switchToSubWindow1();
		// driver.findElement(By.linkText("System Administrator")).click();
		driver.findElement(By.linkText("Senior Developer")).click();
		TestNgHooks.switchToParentWindow();
		driver.switchTo().frame(0);
		return new UserNewRecordPage();
	}

}
