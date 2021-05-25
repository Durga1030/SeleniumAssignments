package week6.day2.assignments.pages;

import org.openqa.selenium.By;

import week6.day2.assignments.hooks.TestNgHooks;

public class CategoryPicker extends TestNgHooks {

	public CategoryPicker selectITJava() {

		driver.findElement(By.xpath("//div[@id='kbCategoriesJSON-columnview-container']/div[1]/div[4]")).click(); // click
		// on
		// IT
		driver.findElement(By.xpath("//span[text()='Java']")).click(); // click on Java
		return this;
	}

	public KnowledgeNewRecordPage clickOKButton() {
		driver.findElement(By.cssSelector("button#ok_button")).click(); // click OK
		return new KnowledgeNewRecordPage();
	}
}
