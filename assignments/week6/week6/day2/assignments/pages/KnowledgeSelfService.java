package week6.day2.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import week6.day2.assignments.hooks.TestNgHooks;

public class KnowledgeSelfService extends TestNgHooks {

	static String resultKNum;
	static String resultShortDesc;
	static String resultCategory;
	static String resultKB;

	public KnowledgeNewRecordPage clickOnCreateNew() {

		driver.findElement(By.xpath("//div[@data-id='d78ed921ff4221009b20ffffffffffdf']//div[1]")).click();

		return new KnowledgeNewRecordPage();
	}

	public KnowledgeSelfService searchOptionNum() {
		WebElement searchOptionNum = driver
				.findElement(By.cssSelector("span#kb_knowledge_hide_search>div>div>span>span>select"));
		new Select(searchOptionNum).selectByIndex(1);
		return this;
	}

	public KnowledgeSelfService assignSearchValue() {
		WebElement eleSearch = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		eleSearch.click();
		eleSearch.sendKeys(KnowledgeNewRecordPage.kBNnumber);
		eleSearch.sendKeys(Keys.ENTER);

		return this;
	}

	public KnowledgeSelfService getResultantKNum() {
		resultKNum = driver.findElement(By.xpath("(//tr[@data-list_id='kb_knowledge']//td)[3]")).getText();
		return this;
	}

	public KnowledgeSelfService getResultantShortDesc() {
		resultShortDesc = driver.findElement(By.xpath("(//tr[@data-list_id='kb_knowledge']//td)[4]")).getText();
		return this;
	}

	public KnowledgeSelfService getResultantCategory() throws InterruptedException {
		resultCategory = driver.findElement(By.xpath("(//a[@class='linked'])[2]")).getText();
		Thread.sleep(200);
		return this;
	}

	public KnowledgeSelfService getResultantKB() {
		resultKB = driver.findElement(By.cssSelector("table#kb_knowledge_table>tbody>tr>td:nth-of-type(10)")).getText();

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
		if (resultKNum.equalsIgnoreCase(KnowledgeNewRecordPage.kBNnumber)) {

			System.out.println("Knowledge Number:" + resultKNum + " & Description: " + resultShortDesc);
			System.out.println(" ");
			System.out.println("Created New Article >> Test Case passed - closing window");

		} else {
			System.err.println("Error!! >> TestCase failed");
		}

		return this;

	}

	public KnowledgeSelfService verifyArticlewithMandatoryFields() {
		if (resultKNum.equalsIgnoreCase(KnowledgeNewRecordPage.kBNnumber) && resultCategory.equalsIgnoreCase("Java")
				&& resultKB.equalsIgnoreCase("IT")) {

			System.out.println("Knowledge Number: " + resultKNum + " ; Description: " + resultShortDesc
					+ " ; Category: " + resultCategory + " ; Knowledge Base: " + resultKB);
			System.out.println(" ");
			System.out.println("Updated Article >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Error!! >> TestCase failed");
		}

		return this;
	}

}
