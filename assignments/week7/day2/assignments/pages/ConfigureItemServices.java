package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class ConfigureItemServices extends TestNgHooks {

	public ConfigureItemServices assignConfigureItem(String inputConfigureItem) throws InterruptedException {
		TypeAndEnter(locateElement("xpath", "(//label[text()='Search'])[2]/following::input"), inputConfigureItem);
		return this;
	}

	public ChatQueueEntry clickOnApacheLink(String inputConfigureItem) {
		click(locateElement("link", inputConfigureItem));
		switchToWindow(0);
		switchToFrame(0);
		return new ChatQueueEntry();
	}
}
