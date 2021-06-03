package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class CategoryPicker extends TestNgHooks {

	public CategoryPicker selectITJava() {

		// Click on IT
		click(locateElement("xpath", "//div[@id='kbCategoriesJSON-columnview-container']/div[1]/div[4]"));

		// Click on Java
		click(locateElement("xpath", "//span[text()='Java']"));

		return this;
	}

	public KnowledgeNewRecordPage clickOKButton() {

		// Click OK Button
		click(locateElement("css", "button#ok_button"));
		return new KnowledgeNewRecordPage();
	}
}
