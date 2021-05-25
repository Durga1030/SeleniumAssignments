package week6.day2.assignments.stepsdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class IncidentCreationCucumber extends BaseSetup {

	public static String incidentNumber;

	@And("Click New Option")
	public void clickCreateNewOption() {
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
	}

// And Switch to ParentFrame

	@And("Get Incident Number")
	public static void getIncNumber() {
		incidentNumber = driver.findElement(By.name("incident.number")).getAttribute("value");
		System.out.println("Incident Number: " + incidentNumber);
	}

	@And("Click on Lookup option to get CallerInfo")
	public void clickCallerLookup() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']//span[1]")).click(); // Lookup using List
	}

	@And("Search and Get User as (.*)$")
	public void getUserInfo(String searchUser) {
		WebElement getUserInfo = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		getUserInfo.sendKeys(searchUser, Keys.ENTER);
		driver.findElement(By.linkText("System Administrator")).click();

	}

	// switch to parent window
//swtch to parent frame

	@And("Assign ShortDescription as {string}")
	public void assignShortDesc(String shortDescValue) {
		WebElement shortDescription = driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));
		shortDescription.click();
		shortDescription.sendKeys(shortDescValue);
	}

	@And("Click on Submit Button")
	public void clickOnSubmit() {
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
	}

	@Then("Verify the Created Incident")

	public void verifyCreatedIncident() throws InterruptedException {
		System.out.println("Verify:" + incidentNumber);

		WebElement searchOptionNum = driver
				.findElement(By.cssSelector("span#incident_hide_search>div>div>span>span>select"));
		new Select(searchOptionNum).selectByIndex(1);

		WebElement searchIncident = driver.findElement(By.cssSelector("span#incident_hide_search>div>div>input"));
		searchIncident.click();
		searchIncident.sendKeys(incidentNumber, Keys.ENTER);

		Thread.sleep(2000);

		String resultantNumber = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if (resultantNumber.equalsIgnoreCase(incidentNumber)) {
			System.out.println(resultantNumber + " has been created >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Failed to create Incident, Error occurred");
		}
	}

}
