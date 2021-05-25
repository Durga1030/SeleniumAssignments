package week6.day2.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import week6.day2.assignments.hooks.TestNgHooks;

public class IncNewRecordPage extends TestNgHooks {

	public static String incidentNumber;

	public IncNewRecordPage verifySuccessMessage() {
		driver.switchTo().frame(0);
		String recordSelfServiceView = driver.findElement(By.xpath("//div[@class='container-fluid']")).getText();
		System.out.println(recordSelfServiceView);
		if (recordSelfServiceView.contains("Incident")) {
			System.out.println("Login Success");
		}
		return this;

	}

	public IncNewRecordPage getIncNumber() {
		incidentNumber = driver.findElement(By.name("incident.number")).getAttribute("value");
		System.out.println("Incident Number: " + incidentNumber);
		return this;
	}

	public IncUserServiceNow clickCallerInfoLookup() {
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']//span[1]")).click(); // Lookup using List
		return new IncUserServiceNow();
	}

	public IncNewRecordPage assignShortDesc() {
		WebElement shortDescription = driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));
		shortDescription.click();
		shortDescription.sendKeys("Sample - New Incident Creation");
		return this;
	}

	public IncidentSelfService clickOnSubmitButton() {
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		return new IncidentSelfService();
	}

}
