package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class TypesOfTaskPage extends TestNgHooks {

	public RequestNewRecordPage clickOnTypeRequest() {
		click(locateElement("link", "Request"));
		return new RequestNewRecordPage();
	}

	public ChatQueueNewEntryPage clickOnTypeChatQueue() {

		// click chat queue entry
		click(locateElement("link", "Chat_queue_entry"));
		return new ChatQueueNewEntryPage();
	}

}
