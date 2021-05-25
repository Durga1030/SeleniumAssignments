package week6.day2.assignments.pages;

import org.openqa.selenium.By;

import week6.day2.assignments.hooks.TestNgHooks;

public class TypesOfTaskPage extends TestNgHooks {

	public RequestNewRecordPage clickOnTypeRequest() {
		driver.findElement(By.linkText("Request")).click();
		return new RequestNewRecordPage();
	}

	public ChatQueueNewEntryPage clickOnTypeChatQueue() {
		driver.findElement(By.linkText("Chat_queue_entry")).click(); // click chat queue entry
		return new ChatQueueNewEntryPage();
	}

}
