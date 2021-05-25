package week6.day2.assignments.pages;

import org.openqa.selenium.By;

import week6.day2.assignments.hooks.TestNgHooks;

public class ChatQueueNewEntryPage extends TestNgHooks {

	static String cQEntryNum;

	public ChatQueueNewEntryPage getChatQNum() {
		cQEntryNum = driver.findElement(By.id("chat_queue_entry.number")).getAttribute("value"); // CHAT0010018,
		return this;
	}

	public TaskSelfService clickOnSubmitButton() {
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		return new TaskSelfService();
	}

}
