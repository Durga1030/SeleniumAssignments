package week6.day2.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import week6.day2.assignments.hooks.TestNgHooks;

public class KnowledgeNewRecordPage extends TestNgHooks {

	static String kBNnumber;

	public KnowledgeNewRecordPage getKnowledgeNum() {

		driver.switchTo().frame(0);

		kBNnumber = driver.findElement(By.id("sys_readonly.kb_knowledge.number")).getAttribute("value");
		System.out.println("K Num: " + kBNnumber);

		return this;
	}

	public KnowledgeBases clickOnKnowledgeLookup() {
		driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_knowledge_base']//span[1]")).click(); // Knowledge
		TestNgHooks.switchToSubWindow1();
		return new KnowledgeBases();
	}

	public KnowledgeNewRecordPage assignShortDesc(String shortDescVal) {
		WebElement shortDesc = driver.findElement(By.id("kb_knowledge.short_description"));
		shortDesc.click();
		shortDesc.clear();
		shortDesc.sendKeys(shortDescVal);
		// "Test - New Article creation"

		System.out.println("Updated Short Description");
		System.out.println(" ");

		return this;
	}

	public KnowledgeSelfService clickOnSubmitButton() {
		driver.findElement(By.cssSelector("button#sysverb_insert_bottom")).click();
		return new KnowledgeSelfService();
	}

	public KnowledgeBases clickOnKnowledgeITLookup() {
		driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_knowledge_base']//span[1]")).click(); // Knowledge
		TestNgHooks.switchToSubWindow1();
		return new KnowledgeBases();
	}

	public CategoryPicker clickOnCategoryLookup() {
		driver.findElement(By.id("lookup.kb_knowledge.kb_category")).click(); // Lookup
		return new CategoryPicker();
	}

}
