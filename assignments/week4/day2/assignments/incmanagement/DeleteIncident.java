package week4.day2.assignments.incmanagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
// 1. Launch ServiceNow application - https://dev103117.service-now.com
		driver.get("https://dev103117.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

// 2. Login with valid credentials username as admin and password as India@123

		// Switch to frame
		driver.switchTo().frame(0);

		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();

// 3. Enter Incident in filter navigator and press enter"
		WebElement incident = driver.findElement(By.id("filter"));
		incident.sendKeys("Incident");
		incident.sendKeys(Keys.ENTER);

// 4. Search for the existing incident and click on the incident

		driver.findElement(By.xpath("//div[text()='Open']")).click();
		driver.switchTo().frame(0);

		Thread.sleep(2000);
		WebElement searchIncident = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchIncident.click();
		searchIncident.sendKeys("INC0010251");
		searchIncident.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		WebElement resultantNumber = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		System.out.println("Incident Number to be update: " + resultantNumber.getText());
		System.out.println(" ");
		resultantNumber.click();

		String incidentNumber = "INC0010251";

// 5. Delete the incident
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();

// 6. Verify the deleted incident
		String expectedText = "No records to display";
		String verifyIncident = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		System.out.println(verifyIncident);

		if (verifyIncident.equalsIgnoreCase(expectedText)) {
			System.out.println("Incident: " + incidentNumber + " has been deleted");
			System.out.println(" ");
			System.out.println("Delete Existing Incident >> Test Case passed - closing window");
			driver.close();

		} else {
			System.out.println(incidentNumber + " hasn't been deleted");
			System.out.println(" ");
			System.err.println(incidentNumber + " Delete Incident - TestCase failed");
		}
	}
}
