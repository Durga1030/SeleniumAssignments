package week4.day2.assignments.requestmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateMyRequest {

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
		String orderNumber = "REQ0010033";

// 3. Enter Service catalog in filter navigator and press enter
		WebElement reqMgmt = driver.findElement(By.id("filter"));
		reqMgmt.sendKeys("My Work");
		Thread.sleep(1000);
		reqMgmt.sendKeys(Keys.ENTER);

// 4. Click on My Work

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

// 5.Select the shown request number
		driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(3)>a")).click();

// 6.Update Location
		driver.findElement(By.id("lookup.sc_request.location")).click(); // Location lookup using list

		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("WindowHandling: " + allWindowHandles.size());
		List<String> lstWindowHandles = new ArrayList<String>(allWindowHandles);
		System.out.println(" ");

		// Switch to sub-window 1
		driver.switchTo().window(lstWindowHandles.get(1));
		System.out.println("Sub-Window Title: " + driver.getTitle());
		System.out.println("Sub-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");

		// Expand Americas
		driver.findElement(By.xpath("//img[@src='images/gwt/treenode_expand_plus.gifx']")).click();

		// Expand North America
		driver.findElement(By.xpath(
				"//div[@id='treenode_0']/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/img[1]"))
				.click();

		// Click on Rhode Islan
		driver.findElement(By.linkText("Rhode Island")).click();

		driver.switchTo().window(lstWindowHandles.get(0));

		System.out.println("Parent-Window Title: " + driver.getTitle());
		System.out.println("Parent-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");
		driver.switchTo().frame(0);

		// click on due date
		driver.findElement(By.xpath("(//button[@id='sc_request.due_date.ui_policy_sensitive']//span)[3]")).click();
		driver.findElement(By.cssSelector(
				"h1#GwtDateTimePicker_header_contents>div>table>tbody>tr>td>table>tbody>tr:nth-of-type(5)>td:nth-of-type(5)>a"))
				.click();
		driver.findElement(By.id("GwtDateTimePicker_ok")).click();

		WebElement requestApproval = driver.findElement(By.id("sc_request.approval"));
		new Select(requestApproval).selectByIndex(0);

		WebElement requestState = driver.findElement(By.id("sc_request.request_state"));
		new Select(requestState).selectByIndex(1);

// 7.Update the remaining fields available
		WebElement shortDesc = driver.findElement(By.id("sc_request.short_description"));
		shortDesc.click();
		shortDesc.clear();
		shortDesc.sendKeys("Test - Updating the required fields");
		System.out.println(" ");

// 8.Update request
		driver.findElement(By.cssSelector("button#sysverb_update_bottom")).click();
		// System.out.println("Updated existing order");

		String resultDescription = driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(7)"))
				.getText();

		if (resultDescription != null) {
			System.out.println(resultDescription + " | Your request number: " + orderNumber);
			System.out.println(" ");
			System.out.println("Updating Existing request >> Test Case passed - closing window");
			driver.close();

		} else {
			System.err.println("TestCase failed");
		}

	}

}
