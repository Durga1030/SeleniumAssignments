package week4.day2.assignments.caller;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteExistingCaller {

	public static void main(String[] args) {

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

// 3. Enter Callers in filter navigator and press enter"
		WebElement filterNav = driver.findElement(By.id("filter"));
		filterNav.sendKeys("Callers");
		filterNav.sendKeys(Keys.ENTER);

// 4. Create new Caller by filling all the fields and click 'Submit'.

		// Switch to frame
		driver.switchTo().frame(0);

		String firstName = "Durga_Test";
		String lastName = "Kandasamy_Test";
		String businessNum = "9999988888";

		WebElement searchOptionLastName = driver
				.findElement(By.cssSelector("span#sys_user_hide_search>div>div>span>span>select"));
		new Select(searchOptionLastName).selectByIndex(1);

		WebElement searchValue = driver.findElement(By.cssSelector("span#sys_user_hide_search>div>div>input"));
		searchValue.click();
		searchValue.sendKeys(lastName);
		searchValue.sendKeys(Keys.ENTER);

		driver.findElement(By.cssSelector("table#sys_user_table>tbody>tr>td:nth-of-type(3)>a")).click();

		// Delete Caller
		driver.findElement(By.cssSelector("button#sysverb_delete")).click();
		driver.findElement(By.cssSelector("button#ok_button")).click();

		String expectedText = "No records to display";
		String verifyDeleteCR = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		// System.out.println(verifyDeleteCR);

		if (verifyDeleteCR.equalsIgnoreCase(expectedText)) {
			System.out.println(
					"Caller: " + firstName + lastName + " - BusinessNum: " + businessNum + " has been deleted");
			System.out.println(" ");
			System.out.println("Delete Existing Caller >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.out.println("Caller: " + firstName + lastName + " hasn't been deleted");
			System.out.println(" ");
			System.err.println(">> TestCase failed");
		}
	}

}
