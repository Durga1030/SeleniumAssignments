package week4.day2.assignments.incmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IncidentWithoutMandatoryFields {

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

// 4. Click on Create new option and fill the mandatory fields

		// driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		driver.switchTo().frame(0);

		String incidentNumber = driver.findElement(By.name("incident.number")).getAttribute("value");
		System.out.println("Incident Number: " + incidentNumber);

		// 5. Assign the incident to Software group

		// driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']//span[1]")).click();

		driver.findElement(By.id("lookup.incident.assignment_group")).click(); // Lookup using List

		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("WindowHandling: " + allWindowHandles.size());
		List<String> lstWindowHandles = new ArrayList<String>(allWindowHandles);
		System.out.println(" ");

		// Switch to sub-window
		driver.switchTo().window(lstWindowHandles.get(1));
		System.out.println("Sub-Window Title: " + driver.getTitle());
		System.out.println("Sub-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");

		WebElement assignGroup = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		assignGroup.sendKeys("Software");
		assignGroup.sendKeys(Keys.ENTER);
		driver.findElement(By.linkText("Software")).click();
		// driver.close();

		driver.switchTo().window(lstWindowHandles.get(0));

		System.out.println("Parent-Window Title: " + driver.getTitle());
		System.out.println("Parent-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");
		driver.switchTo().frame(0);

		System.out.println("Updated incident Group as Software");
		System.out.println(" ");

		// Enter AssignedTo value

		// driver.findElement(By.id("lookup.incident.assigned_to")).click();
		driver.findElement(By.xpath("//button[@id='lookup.incident.assigned_to']//span[1]")).click(); // Lookup using
		// List

		// Switch to sub-window
		allWindowHandles = driver.getWindowHandles();
		lstWindowHandles = new ArrayList<String>(allWindowHandles);
		System.out.println("Window Handling: " + allWindowHandles.size());
		driver.switchTo().window(lstWindowHandles.get(1));
		System.out.println("Sub-Window Title: " + driver.getTitle());
		System.out.println("Sub-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");

		WebElement assignmentTo = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		assignmentTo.sendKeys("ITIL");
		assignmentTo.sendKeys(Keys.ENTER);
		driver.findElement(By.linkText("ITIL User")).click();

		Thread.sleep(1000);

		driver.switchTo().window(lstWindowHandles.get(0));
		driver.switchTo().frame(0);

		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();

// Verify Error message

		String expectedErrorMessage = "The following mandatory fields are not filled in: Short description, Caller";
		String errorMissingFields = driver.findElement(By.className("outputmsg_text")).getText();

		// System.out.println(errorMissingFields);

		if (errorMissingFields.equalsIgnoreCase(expectedErrorMessage)) {
			System.out.println("Error Message: " + errorMissingFields);
			System.out.println(" ");
			System.out.println("Incident without Mandatory fields >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Incident without Mandatory fields - TestCase failed");
		}

	}

}
