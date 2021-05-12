package week4.day2.assignments.queueentry;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateChatQueue {

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

// 3. Enter My Work in filter navigator and press enter"
		WebElement myWork = driver.findElement(By.id("filter"));
		myWork.sendKeys("My work");
		myWork.sendKeys(Keys.ENTER);

		// driver.findElement(By.xpath("//div[text()='My Work']")).click();

		driver.switchTo().frame(0);

		driver.findElement(By.id("sysverb_new")).click();

		driver.findElement(By.linkText("Chat_queue_entry")).click(); // click chat queue entry

		String cQEntryNum = driver.findElement(By.id("chat_queue_entry.number")).getAttribute("value"); // CHAT0010018,
																										// 19

		// Submit
		driver.findElement(By.id("sysverb_insert_bottom")).click();

		// Verify the New creation

		WebElement forTextNum = driver.findElement(By.cssSelector("span#task_hide_search>div>div>span>span>select"));
		new Select(forTextNum).selectByIndex(1);

		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys(cQEntryNum);
		search.sendKeys(Keys.ENTER);

		String resultantCQNum = driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(3)"))
				.getText();

		if (resultantCQNum.equalsIgnoreCase(cQEntryNum)) {
			System.out.println(resultantCQNum + " has been created >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Failed to create Chat Queue, Error occurred");
		}

	}
}