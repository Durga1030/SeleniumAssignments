package week4.day2.assignments.servicecategory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateExistingOrder {

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
		filterNavigator.sendKeys("My Requests");
		Thread.sleep(1000);
		filterNavigator.sendKeys(Keys.ENTER);

// 4.Select MyRequest and paste the copied request number in request and search
		// driver.findElement(By.xpath("//div[text()='My Requests']")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("div#list_nav_task>div>div>h1>a")).click();
		driver.findElement(By.xpath("//div[text()='View']")).click();
		driver.findElement(By.xpath("//div[text()='Default view']")).click();
		// driver.findElement(By.xpath("//div[text()='View']/following::div[text()='Default
		// view']")).click();
		Thread.sleep(1000);

		// Search by number
		WebElement forTextNum = driver.findElement(By.cssSelector("span#task_hide_search>div>div>span>span>select"));
		new Select(forTextNum).selectByIndex(1);

		WebElement searchRequest = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchRequest.click();
		searchRequest.sendKeys(orderNumber);
		searchRequest.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

// 5.Select the shown request number
		driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(3)>a")).click();

// 6.Update Approval field to Requested and Request State Field to Approved

		WebElement requestApproval = driver.findElement(By.id("sc_request.approval"));
		new Select(requestApproval).selectByIndex(1);

		WebElement requestState = driver.findElement(By.id("sc_request.request_state"));
		new Select(requestState).selectByIndex(2);

// 7.Update the remaining fields available
		WebElement shortDesc = driver.findElement(By.id("sc_request.short_description"));
		shortDesc.click();
		shortDesc.clear();
		shortDesc.sendKeys("Test - Updating Approval and Request state fields in Existing order");
		System.out.println(" ");

// 8.Update request
		driver.findElement(By.cssSelector("button#sysverb_update_bottom")).click();
		// System.out.println("Updated existing order");

		String resultDescription = driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(7)"))
				.getText();

		if (resultDescription != null) {
			System.out.println(resultDescription + " ordered successfully. Your request number: " + orderNumber);
			System.out.println(" ");
			System.out.println("Updating Existing order>> Test Case passed - closing window");
			driver.close();

		} else {
			System.err.println("TestCase failed");
		}

	}

}
