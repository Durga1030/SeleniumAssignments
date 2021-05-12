package week4.day2.assignments.changemanagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteChangeRequest {

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

// 3. Enter Change in filter navigator and press enter"
		WebElement changeManagement = driver.findElement(By.id("filter"));
		changeManagement.sendKeys("Change");
		changeManagement.sendKeys(Keys.ENTER);

// 4. Click open and search existing change

		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();

		driver.switchTo().frame(0);

		Select searchStateOption = new Select(
				driver.findElement(By.cssSelector("span#change_request_hide_search>div>div>span>span>select")));
		searchStateOption.selectByIndex(4);

		WebElement searchCHG = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		searchCHG.click();
		searchCHG.sendKeys("New"); // CHG0030073
		searchCHG.sendKeys(Keys.ENTER);

		// Click on Number hyperlink

		WebElement enterNumber = driver
				.findElement(By.xpath("//input[@id='change_request_table_header_search_control']"));
		enterNumber.click();
		enterNumber.sendKeys("CHG0030073");
		enterNumber.sendKeys(Keys.ENTER);

		String stateValue = driver.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(6)"))
				.getText();
		System.out.println(" ");
		System.out.println("State Value before Delete: " + stateValue);
		System.out.println(" ");

		String changeNum = driver.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(3)"))
				.getText();
		System.out.println("Number: " + changeNum);
		System.out.println(" ");
		driver.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(3)>a")).click();

// 4. Delete the Change request
		driver.findElement(By.cssSelector("button#sysverb_delete")).click();

		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();

// 5. Verify the deleted change request
		String expectedText = "No records to display";
		String verifyDeleteCR = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		// System.out.println(verifyDeleteCR);

		if (verifyDeleteCR.equalsIgnoreCase(expectedText)) {
			System.out.println(changeNum + " has been deleted");
			System.out.println(" ");
			System.out.println("Delete Existing CR >> Test Case passed - closing window");
			driver.close();

		} else {
			System.out.println(changeNum + " hasn't been deleted");
			System.out.println(" ");
			System.err.println(changeNum + " Delete CR - TestCase failed");
		}
	}

}
