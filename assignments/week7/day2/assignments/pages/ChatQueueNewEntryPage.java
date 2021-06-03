package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class ChatQueueNewEntryPage extends TestNgHooks {

	static String cQEntryNum;

	public ChatQueueNewEntryPage getChatQNum() {
		cQEntryNum = getTypedText(locateElement("id", "chat_queue_entry.number"));
		// getDriver().findElement(By.id("chat_queue_entry.number")).getAttribute("value");

		// // CHAT0010018,
		System.out.println("New Chat Q Entry: " + cQEntryNum);
		return this;
	}

	public TaskSelfService clickOnSubmitButton() {
		click(locateElement("id", "sysverb_insert_bottom"));

		return new TaskSelfService();
	}

}
