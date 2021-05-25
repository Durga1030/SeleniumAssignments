package week6.day2.assignments.stepsdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteIncidentCucumber extends BaseSetup {

	@When("Click Open Option")

	public void clickOpenOption() {
		driver.findElement(By.xpath("//div[text()='Open']")).click();
	}
	// And Switch to ParentFrame

	@And("Assign Incident Number as (.*)$")

	public void assignIncNum(String incNum) throws InterruptedException {
		Thread.sleep(2000);

		WebElement searchIncident = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchIncident.click();
		searchIncident.sendKeys(incNum, Keys.ENTER);
	}

	@And("Print and click the resultant number")
	public void clickResultantNum() throws InterruptedException {

		Thread.sleep(2000);

		WebElement resultantNumber = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		System.out.println("Incident Number to be update: " + resultantNumber.getText());
		System.out.println(" ");
		resultantNumber.click();

	}

	@And("Delete the Incident")
	public void deleteIncident() {
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();
	}

	@Then("Verify the Deleted Incident as (.*)$")
	public void verifyDeleteInc(String incNum) throws InterruptedException {

		WebElement searchOptionNum = driver
				.findElement(By.cssSelector("span#incident_hide_search>div>div>span>span>select"));
		new Select(searchOptionNum).selectByIndex(1);

		WebElement searchIncident = driver.findElement(By.cssSelector("span#incident_hide_search>div>div>input"));
		searchIncident.click();
		searchIncident.sendKeys(incNum, Keys.ENTER);

		Thread.sleep(2000);

		String expectedText = "No records to display";
		String verifyIncident = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();

		if (verifyIncident.equalsIgnoreCase(expectedText)) {
			System.out.println("Incident: " + incNum + " has been deleted");
			System.out.println(" ");
			System.out.println("Delete Existing Incident >> Test Case passed - closing window");
			driver.close();

		} else {
			System.out.println(incNum + " hasn't been deleted");
			System.out.println(" ");
			System.err.println(incNum + " Delete Incident - TestCase failed");

		}
	}
}
