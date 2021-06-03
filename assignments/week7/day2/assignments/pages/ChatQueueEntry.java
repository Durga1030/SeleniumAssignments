package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class ChatQueueEntry extends TestNgHooks {

	static String cQEntryNum;

	public ChatQueueEntry getCQNum() {
		cQEntryNum = getTypedText(locateElement("id", "chat_queue_entry.number"));
		return this;
	}

	public ChatQueueEntry getShortDesc(String shortDescVal) {
		clearAndType(locateElement("id", "chat_queue_entry.short_description"), shortDescVal);
		return this;
	}

	public ChatQueueEntry getLongDesc(String longDescVal) {
		clearAndType(locateElement("id", "chat_queue_entry.description"), longDescVal);
		return this;
	}

	public ChatQueueEntry selectPriorityValCritical() {
		selectDropDownUsingText(locateElement("chat_queue_entry.priority"), "1 - Critical");
		return this;
	}

	public ChatQueueEntry selectStateValAbandoned() {
		selectDropDownUsingIndex(locateElement("chat_queue_entry.state"), 2);
		return this;
	}

	public ConfigureItemServices clickOnConfigutaionItemLookup() {
		clickWithNoSnap(locateElement("lookup.chat_queue_entry.cmdb_ci"));
		switchToWindow(1);
		return new ConfigureItemServices();
	}

	public TaskSelfService clickOnUpdateBtn() {
		click(locateElement("id", "sysverb_update"));
		return new TaskSelfService();
	}

	public TaskSelfService clickDeleteBtn() {
		System.out.println(cQEntryNum + " needs to delete");

		// Delete the Entry the condition matches

		click(locateElement("id", "sysverb_delete"));
		click(locateElement("css", "button#ok_button"));

		return new TaskSelfService();
	}

}
