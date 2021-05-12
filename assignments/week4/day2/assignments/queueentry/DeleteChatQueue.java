package week4.day2.assignments.queueentry;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteChatQueue {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		String inputId = "CHAT0010018";

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

		String cQEntryNum = driver.findElement(By.id("chat_queue_entry.number")).getAttribute("value"); // CHAT0010018/19
		System.out.println(" ");
		System.out.println(cQEntryNum + " needs to delete");
		System.out.println(" ");

		// Delete the Entry
		if (cQEntryNum.equalsIgnoreCase(inputId)) {
			driver.findElement(By.id("sysverb_delete")).click();
			driver.findElement(By.cssSelector("button#ok_button")).click();
		}

//Verify the changes
		WebElement selectCQNum = driver.findElement(By.cssSelector("span#task_hide_search>div>div>span>span>select"));
		new Select(selectCQNum).selectByIndex(1);

		WebElement searchNum = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchNum.click();
		searchNum.sendKeys(cQEntryNum);
		searchNum.sendKeys(Keys.ENTER);

		String expectedText = "No records to display";
		String verifyDeleteCR = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		// System.out.println(verifyDeleteCR);

		if (verifyDeleteCR.equalsIgnoreCase(expectedText)) {
			System.out.println(inputId + " has been deleted");
			System.out.println(" ");
			System.out.println("Delete Existing CQ >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.out.println(inputId + " hasn't been deleted");
			System.out.println(" ");
			System.err.println("Delete CQ - TestCase failed");
		}
	}

}
