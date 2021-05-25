package week6.day2.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import week6.day2.assignments.hooks.TestNgHooks;

public class IncidentSelfService extends TestNgHooks {

	public IncidentSelfService verifySuccessMessage() {
		driver.switchTo().frame(0);
		String selfServiceView = driver.findElement(By.cssSelector("div#list_nav_incident>div>div>h1>a")).getText();

		if (selfServiceView.contains("Incidents")) {
			System.out.println("Login Success");
		}
		return this;

	}

	public IncNewRecordPage clickNewButton() {
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		driver.switchTo().frame(0);
		return new IncNewRecordPage();
	}

	public IncidentSelfService verifyCreatedIncident() throws InterruptedException {

		WebElement searchOptionNum = driver
				.findElement(By.cssSelector("span#incident_hide_search>div>div>span>span>select"));
		new Select(searchOptionNum).selectByIndex(1);

		WebElement searchIncident = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchIncident.click();
		searchIncident.sendKeys(IncNewRecordPage.incidentNumber);
		searchIncident.sendKeys(Keys.ENTER);

		Thread.sleep(1000);

		String resultantNumber = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();

		if (resultantNumber.equalsIgnoreCase(IncNewRecordPage.incidentNumber)) {
			System.out.println(resultantNumber + " has been created >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Failed to create Incident, Error occurred");
		}

		return this;
	}
}
