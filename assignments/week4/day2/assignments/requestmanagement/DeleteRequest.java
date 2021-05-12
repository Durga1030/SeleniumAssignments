package week4.day2.assignments.requestmanagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteRequest {

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
		String orderNumber = "REQ0010042";

// 3. Enter Service catalog in filter navigator and press enter
		WebElement reqMgmt = driver.findElement(By.id("filter"));
		reqMgmt.sendKeys("My Work");
		Thread.sleep(1000);
		reqMgmt.sendKeys(Keys.ENTER);

// Click on My Work

		driver.findElement(By.xpath("(//div[text()='My Work'])")).click();
		driver.switchTo().frame(0);

// Search by number
		WebElement forTextNum = driver.findElement(By.cssSelector("span#task_hide_search>div>div>span>span>select"));
		new Select(forTextNum).selectByIndex(1);

		WebElement searchRequest = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchRequest.click();
		searchRequest.sendKeys(orderNumber);
		searchRequest.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

// Select the shown request number
		driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(3)>a")).click();

// Delete request and verify
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();

		String expectedResult = "No records to display";
		String verifyCancelStatus = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();

		if (verifyCancelStatus.equalsIgnoreCase(expectedResult)) {
			System.out.println("Your request number: " + orderNumber + " has been deleted successfully");
			System.out.println(" ");
			System.out.println("Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("TestCase failed");
		}

	}

}
