package week4.day2.assignments.caller;

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

public class CreateNewCaller {

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

		driver.findElement(By.cssSelector("button#sysverb_new")).click();

		String firstName = "Durga_Test";
		String lastName = "Kandasamy_Test";

		driver.findElement(By.id("sys_user.first_name")).sendKeys(firstName);
		driver.findElement(By.id("sys_user.last_name")).sendKeys(lastName);
		driver.findElement(By.id("sys_user.email")).sendKeys("test123@example.com");

		driver.findElement(By.id("lookup.sys_user.title")).click(); // Lookup

		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("WindowHandling: " + allWindowHandles.size());
		List<String> lstWindowHandles = new ArrayList<String>(allWindowHandles);
		System.out.println(" ");

		// Switch to sub-window
		driver.switchTo().window(lstWindowHandles.get(1));
		System.out.println("Sub-Window Title: " + driver.getTitle());
		System.out.println("Sub-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");

		driver.findElement(By.linkText("System Administrator")).click();

		driver.switchTo().window(lstWindowHandles.get(0));

		System.out.println("Parent-Window Title: " + driver.getTitle());
		System.out.println("Parent-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");
		driver.switchTo().frame(0);

		System.out.println("Updated Title");
		System.out.println(" ");

		driver.findElement(By.id("sysverb_insert_bottom")).click();

// 5. Search and verify the newly created Caller New Caller should be created  with right values

		WebElement forTextLastNameFirst = driver
				.findElement(By.cssSelector("span#sys_user_hide_search>div>div>span>span>select"));
		new Select(forTextLastNameFirst).selectByIndex(1);

		WebElement searchLastName = driver.findElement(By.cssSelector("span#sys_user_hide_search>div>div>input"));
		searchLastName.click();
		searchLastName.sendKeys(lastName);
		searchLastName.sendKeys(Keys.ENTER);

		String resultLastName = driver.findElement(By.cssSelector("table#sys_user_table>tbody>tr>td:nth-of-type(3)>a"))
				.getText();
		String resultFirstName = driver.findElement(By.cssSelector("table#sys_user_table>tbody>tr>td:nth-of-type(4)"))
				.getText();

		if (resultLastName.equalsIgnoreCase(lastName) && resultFirstName.equalsIgnoreCase(firstName)) {

			System.out.println("First Name: " + resultFirstName + " ; " + " Last Name: " + resultLastName);
			System.out.println(" ");
			System.out.println("Create New Caller >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Error!! >> TestCase failed");
		}

	}

}
