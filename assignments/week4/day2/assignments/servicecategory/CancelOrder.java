package week4.day2.assignments.servicecategory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CancelOrder {

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
		String orderNumber = "REQ0010038";

// 3. Enter Service catalog in filter navigator and press enter
		WebElement filterNavigator = driver.findElement(By.id("filter"));
		filterNavigator.sendKeys("Service Catalog");
		Thread.sleep(1000);
		filterNavigator.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//div[text()='Requests']")).click();

		System.out.println(orderNumber);

// 4.Select MyRequest and paste the copied request number in request and search

		driver.switchTo().frame(0);
		/*
		 * driver.findElement(By.cssSelector("div#list_nav_task>div>div>h1>a")).click();
		 * driver.findElement(By.xpath("//div[text()='View']")).click();
		 * driver.findElement(By.xpath("//div[text()='Default view']")).click();
		 */

		// Search by number
		WebElement forTextNum = driver
				.findElement(By.xpath("//span[@class='input-group-addon input-group-select']//select[1]"));
		new Select(forTextNum).selectByIndex(1);

		WebElement searchRequest = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchRequest.click();
		searchRequest.sendKeys(orderNumber);
		searchRequest.sendKeys(Keys.ENTER);

		Thread.sleep(1000);

// 5. Select the shown request number
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

// 6. Update Approval field to Requested and Request State Field to Approved

		WebElement requestApproval = driver.findElement(By.id("sc_request.approval"));
		new Select(requestApproval).selectByIndex(3); // rejected

		WebElement requestState = driver.findElement(By.id("sc_request.request_state"));
		new Select(requestState).selectByIndex(5); // closed cancelled

// 7. Click on Cancel request button and verfy the REQ status

		driver.findElement(By.xpath("(//button[text()='Cancel Request'])[2]")).click();
		// System.out.println("Updated existing order");
		/*
		 * String expectedStateValue = "Closed Cancelled"; String resultstate =
		 * driver.findElement(By.cssSelector(
		 * "table#task_table>tbody>tr>td:nth-of-type(5)")) .getText();
		 */
		String expectedResult = "No records to display";
		String verifyCancelStatus = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();

		if (verifyCancelStatus.equalsIgnoreCase(expectedResult)) {
			System.out.println("Your request number: " + orderNumber + " has been cancelled successfully");
			System.out.println(" ");
			System.out.println("Test Case passed - closing window");
			driver.close();

		} else {
			System.err.println("TestCase failed");
		}

	}

}
