package week6.day2.assignments.pages;

import org.openqa.selenium.By;

import week6.day2.assignments.hooks.TestNgHooks;

public class RequestPage extends TestNgHooks {

	public RequestPage clickOnDeleteButton() {

		driver.findElement(By.id("sysverb_delete")).click();

		return this;
	}

	public TaskSelfService clickOnDelOkButn() {
		driver.findElement(By.id("ok_button")).click();
		return new TaskSelfService();
	}

}
