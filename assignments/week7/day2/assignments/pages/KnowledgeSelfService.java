package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class KnowledgeSelfService extends TestNgHooks {

	public String resultKNum;
	public String resultantCategory;
	public String resultantShortDesc;
	public String resultantKB;

	public KnowledgeNewRecordPage clickOnCreateNew() {
		click(locateElement("xpath", "//a[@id='d78ed921ff4221009b20ffffffffffdf']/div[1]/div[1]"));
		switchToFrame(0);
		return new KnowledgeNewRecordPage();
	}

	public KnowledgeSelfService searchOptionNum() {
		selectDropDownUsingIndex(
				locateElement("xpath", "//span[@class='input-group-addon input-group-select']//select[1]"), 1);
		return this;
	}

	public KnowledgeSelfService assignSearchValue() throws InterruptedException {
		TypeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"), KnowledgeNewRecordPage.kBNnumber);
		return this;
	}

	public KnowledgeSelfService getResultantKNum() {
		resultKNum = getElementText(locateElement("xpath", "//a[@class='linked formlink']"));
		return this;
	}

	public KnowledgeSelfService getResultantShortDesc() {
		resultantShortDesc = getElementText(locateElement("xpath", "(//tr[@data-list_id='kb_knowledge']//td)[4]"));
		return this;
	}

	public KnowledgeSelfService getResultantCategory() throws InterruptedException {
		resultantCategory = getElementText(locateElement("xpath", "(//a[@class='linked'])[3]"));
		return this;
	}

	public KnowledgeSelfService getResultantKB() {
		resultantKB = getElementText(locateElement("css", "table#kb_knowledge_table>tbody>tr>td:nth-of-type(9)"));

		return this;
	}

	/*
	 * public KnowledgeSelfService arragePersonalizeSettings() {
	 * 
	 * // Settings button - personalize list
	 * driver.findElement(By.xpath("//i[@data-list_id='kb_knowledge']")).click();
	 * 
	 * // Personalize list columns
	 * driver.findElement(By.xpath("//option[text()='Category(category)']")).click()
	 * ;
	 * driver.findElement(By.xpath("//div[@id='addRemoveButtons']//a[1]")).click();
	 * driver.findElement(By.xpath("//option[text()='Knowledge base']")).click();
	 * driver.findElement(By.xpath("//div[@id='addRemoveButtons']//a[1]")).click();
	 * driver.findElement(By.cssSelector("button#ok_button")).click(); return this;
	 * }
	 */

	public KnowledgeSelfService verifyCreatedArticle() {
		verifyExactText(locateElement("xpath", "//a[@class='linked formlink']"), KnowledgeNewRecordPage.kBNnumber);
		return this;

	}

	public KnowledgeSelfService verifyArticlewithMandatoryFields() {
		System.out.println(resultantKB + resultantCategory);
		verifyExactText(locateElement("xpath", "//a[@class='linked formlink']"), KnowledgeNewRecordPage.kBNnumber);
		verifyExactText(locateElement("css", "table#kb_knowledge_table>tbody>tr>td:nth-of-type(9)"), "IT");
		verifyExactText(locateElement("xpath", "(//a[@class='linked'])[3]"), "Java");
		return this;
	}

}
