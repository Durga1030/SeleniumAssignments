package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class KnowledgeNewRecordPage extends TestNgHooks {

	static String kBNnumber;

	public KnowledgeNewRecordPage getKnowledgeNum() {
		kBNnumber = getTypedText(locateElement("id", "sys_readonly.kb_knowledge.number"));
		return this;
	}

	public KnowledgeBases clickOnKnowledgeLookup() {

		clickWithNoSnap(locateElement("xpath", "//button[@id='lookup.kb_knowledge.kb_knowledge_base']//span[1]"));
		// getDriver().findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_knowledge_base']//span[1]")).click();
		switchToWindow(1);
		return new KnowledgeBases();
	}

	public KnowledgeNewRecordPage assignShortDesc(String shortDescVal) {
		click(locateElement("id", "kb_knowledge.short_description"));
		clearAndType(locateElement("id", "kb_knowledge.short_description"), shortDescVal);
		System.out.println("Updated Short Description");
		System.out.println(" ");
		return this;
	}

	public KnowledgeSelfService clickOnSubmitButton() {
		click(locateElement("id", "sysverb_insert"));
		return new KnowledgeSelfService();
	}

	public KnowledgeBases clickOnKnowledgeITLookup() {
		clickWithNoSnap(locateElement("xpath", "//button[@id='lookup.kb_knowledge.kb_knowledge_base']//span[1]"));
		switchToWindow(1);
		return new KnowledgeBases();
	}

	public CategoryPicker clickOnCategoryLookup() {
		clickWithNoSnap(locateElement("lookup.kb_knowledge.kb_category"));
		return new CategoryPicker();
	}

}
