package week6.day2.assignments.pages;

import org.openqa.selenium.By;

import week6.day2.assignments.hooks.TestNgHooks;

public class KnowledgeBases extends TestNgHooks {

	public KnowledgeNewRecordPage clickOnKnowledgeLink() throws InterruptedException {
		driver.findElement(By.linkText("Knowledge")).click();
		TestNgHooks.switchToParentWindow();
		TestNgHooks.switchToFrame0();
		System.out.println("Updated Knowledge base as Knowledge");
		System.out.println(" ");
		return new KnowledgeNewRecordPage();
	}

	public KnowledgeNewRecordPage clickOnITLink() throws InterruptedException {
		driver.findElement(By.linkText("IT")).click();
		TestNgHooks.switchToParentWindow();
		TestNgHooks.switchToFrame0();
		System.out.println("Updated Knowledge base as IT");
		System.out.println(" ");
		return new KnowledgeNewRecordPage();
	}

}
