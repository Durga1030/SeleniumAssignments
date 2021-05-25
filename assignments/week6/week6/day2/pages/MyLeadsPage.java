package week6.day2.pages;

import org.openqa.selenium.By;

import week6.day2.hooks.HooksTest;

public class MyLeadsPage extends HooksTest {

	public CreateLeadPage clickCreateLeadsMenu() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeadPage();

	}

}
