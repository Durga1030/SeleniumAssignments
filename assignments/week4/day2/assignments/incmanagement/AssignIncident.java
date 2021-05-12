package week4.day2.assignments.incmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident {

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
		searchIncident.sendKeys("INC0010254");
		searchIncident.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		WebElement resultantNumber = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		System.out.println("Incident Number to be update: " + resultantNumber.getText());
		System.out.println(" ");
		resultantNumber.click();

// 5. Assign the incident to  Software group

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

// 6. Update the incident with Work Notes  -- Assignment group and Assigned to should be Software and ITIL User

		// Work notes
		// driver.switchTo().frame(0);

		driver.switchTo().window(lstWindowHandles.get(0));
		driver.switchTo().frame(0);
		Actions actions = new Actions(driver);
		WebElement nav1 = driver.findElement(By.id("cxs_maximize_results"));
		WebElement nav2 = driver.findElement(By.xpath("//span[text()='Notes']"));
		WebElement workNotes = driver.findElement(By.id("activity-stream-work_notes-textarea"));
		actions.moveToElement(nav1).moveToElement(nav2).moveToElement(workNotes).click().perform();
		workNotes.sendKeys("Test - Assigning Existing Incident Group and To values");

		driver.findElement(By.id("sysverb_update_bottom")).click();

// 7. Verification after the assignment
		String verifyAssignmentGroup = driver
				.findElement(By.cssSelector("table#incident_table>tbody>tr>td:nth-of-type(10)")).getText();
		String verifyAssignedT0 = driver.findElement(By.cssSelector("table#incident_table>tbody>tr>td:nth-of-type(11)"))
				.getText();

		if ((verifyAssignmentGroup.equalsIgnoreCase("Software")) && (verifyAssignedT0.equalsIgnoreCase("ITIL User"))) {
			System.out.println(
					"Assignment Group: " + verifyAssignmentGroup + " & " + " Assigned To: " + verifyAssignedT0);
			System.out.println(" ");
			System.out.println("Assign Incident >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Assign Incident - TestCase failed");
		}
	}
}
