package week6.day2.pages;

import org.openqa.selenium.By;

import week6.day2.hooks.HooksTest;

public class CreateLeadPage extends HooksTest {

	public CreateLeadPage assignCompanyName(String companyName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		return this;
	}

	public CreateLeadPage assignFName(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		return this;
	}

	public CreateLeadPage assignLName(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		return this;
	}

	public ViewLeadPage clickCreateLeadBtn() {

		driver.findElement(By.className("smallSubmit")).click();
		return new ViewLeadPage();
	}
}
