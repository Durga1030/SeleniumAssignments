package week6.day1.assignments.stepsdefinition;

import org.openqa.selenium.Alert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AlertsHandling extends BaseSetup {

	@Then("Close the Browser")
	public static void closeBrowser() {
		driver.quit();
	}

	@And("Handle Alerts for Merge Step")
	public void alertsHandling() {

		// Switch to Alert and accept.
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert: " + alert.getText());
		alert.accept();
	}

}
