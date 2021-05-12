package week4.day2.assignments.queueentry;

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

public class ConfigureExistingQueue {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		String inputId = "CHAT0010018";
		String inputDescription = "Test - Update to an Existing Entry";
		String inputConfigureItem = "PS Apache02";

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

// 3. Enter My Work in filter navigator and press enter"
		WebElement myWork = driver.findElement(By.id("filter"));
		myWork.sendKeys("My work");
		myWork.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//div[text()='My Work']")).click();

		driver.switchTo().frame(0);

		WebElement forTextNum = driver.findElement(By.cssSelector("span#task_hide_search>div>div>span>span>select"));
		new Select(forTextNum).selectByIndex(1);

		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys(inputId);
		search.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		String cQEntryNum = driver.findElement(By.id("chat_queue_entry.number")).getAttribute("value"); // CHAT0010018,
																										// 19
		System.out.println(cQEntryNum);

		// Update Configuration item field to PS Apache02

		driver.findElement(By.id("lookup.chat_queue_entry.cmdb_ci")).click();// Configutre itemLookup using List

		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("WindowHandling: " + allWindowHandles.size());
		List<String> lstWindowHandles = new ArrayList<String>(allWindowHandles);
		System.out.println(" ");

		// Switch to sub-window
		driver.switchTo().window(lstWindowHandles.get(1));
		System.out.println("Configure Item - Sub-Window Title: " + driver.getTitle());
		System.out.println("Configure Item - Sub-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");

		WebElement assignGroup = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		assignGroup.sendKeys(inputConfigureItem);
		assignGroup.sendKeys(Keys.ENTER);
		driver.findElement(By.linkText(inputConfigureItem)).click();

		driver.switchTo().window(lstWindowHandles.get(0));

		System.out.println("Parent-Window Title: " + driver.getTitle());
		System.out.println("Parent-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");
		driver.switchTo().frame(0);

		System.out.println("Updated Configure Item to PS Apache02");
		System.out.println(" ");

		WebElement shortDesc = driver.findElement(By.id("chat_queue_entry.short_description"));
		shortDesc.click();
		shortDesc.clear();
		shortDesc.sendKeys(inputDescription);

		WebElement longDesc = driver.findElement(By.id("chat_queue_entry.description"));
		longDesc.click();
		longDesc.clear();
		longDesc.sendKeys(inputDescription);

		// Update State field to closed abandoned and Priority to Critical

		WebElement chatqueueentrypriority = driver.findElement(By.id("chat_queue_entry.priority"));
		new Select(chatqueueentrypriority).selectByVisibleText("1 - Critical");

		WebElement chatqueueentrystate = driver.findElement(By.id("chat_queue_entry.state"));
		new Select(chatqueueentrystate).selectByIndex(2);

		// Update
		driver.findElement(By.id("sysverb_update")).click();

		// Verify the New creation

		// Settings button - personalize list
		// driver.findElement(By.xpath("//i[@data-list_id='kb_knowledge']")).click();
		driver.findElement(By.xpath("//i[@data-list_id='task']")).click();
		Thread.sleep(1000);

		// Personalize list columns
		driver.findElement(By.xpath("//option[text()='Configuration item']")).click(); // Configure item
		driver.findElement(By.xpath("//div[@id='addRemoveButtons']//a[1]")).click();
		driver.findElement(By.cssSelector("button#ok_button")).click();

		WebElement selectCQNum = driver.findElement(By.cssSelector("span#task_hide_search>div>div>span>span>select"));
		new Select(selectCQNum).selectByIndex(1);

		WebElement searchNum = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchNum.click();
		searchNum.sendKeys(cQEntryNum);
		searchNum.sendKeys(Keys.ENTER);

		String resultantCQNum = driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(3)"))
				.getText();
		String resultantShortDesc = driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(7)"))
				.getText();
		String resultantState = driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(5)"))
				.getText();
		String resultantPriority = driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(4)"))
				.getText();
		String resultantConfigureItem = driver
				.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(9)")).getText();

		if (resultantCQNum.equalsIgnoreCase(cQEntryNum) && resultantShortDesc.equalsIgnoreCase(inputDescription)
				&& resultantConfigureItem.equalsIgnoreCase(inputConfigureItem)) {
			System.out.println(resultantCQNum + " has been configured ");
			System.out.println(" ");
			System.out.println("Priority: " + resultantPriority + "State: " + resultantState + " | "
					+ " >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Failed to configure existing Chat Queue, Error occurred");
		}

	}

}
