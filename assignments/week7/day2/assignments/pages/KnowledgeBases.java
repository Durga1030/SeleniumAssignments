package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class KnowledgeBases extends TestNgHooks {

	public KnowledgeNewRecordPage clickOnKnowledgeLink() throws InterruptedException {
		clickWithNoSnap(locateElement("link", "Knowledge"));
		switchToWindow(0);
		System.out.println("Updated Knowledge base as Knowledge");
		switchToFrame(0);
		return new KnowledgeNewRecordPage();
	}

	public KnowledgeNewRecordPage clickOnITLink() throws InterruptedException {
		clickWithNoSnap(locateElement("link", "IT"));
		switchToWindow(0);
		System.out.println("Updated Knowledge base as IT - Need to update Category as Java");
		switchToFrame(0);
		return new KnowledgeNewRecordPage();
	}

}
