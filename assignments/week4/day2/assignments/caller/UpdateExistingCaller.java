package week4.day2.assignments.caller;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateExistingCaller {

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

		// Update Mobile number
		WebElement businessMobileNo = driver.findElement(By.id("sys_user.phone"));
		businessMobileNo.click();
		businessMobileNo.clear();
		businessMobileNo.sendKeys(businessNum);

		// Click on Update
		driver.findElement(By.cssSelector("button#sysverb_update_bottom")).click();

		WebElement searchOptionBusinessNo = driver
				.findElement(By.cssSelector("span#sys_user_hide_search>div>div>span>span>select"));
		new Select(searchOptionBusinessNo).selectByIndex(3);

		WebElement searchValueNum = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchValueNum.click();
		searchValueNum.sendKeys("(999) 998-8888");
		searchValueNum.sendKeys(Keys.ENTER);

		String resultMobileNo = driver.findElement(By.xpath("(//td[@class='vt'])[3]")).getText();

		String resultLastName = driver.findElement(By.cssSelector("table#sys_user_table>tbody>tr>td:nth-of-type(3)>a"))
				.getText();
		String resultFirstName = driver.findElement(By.cssSelector("table#sys_user_table>tbody>tr>td:nth-of-type(4)"))
				.getText();

		if (resultLastName.equalsIgnoreCase(lastName) && resultFirstName.equalsIgnoreCase(firstName)
				&& resultMobileNo.equalsIgnoreCase("(999) 998-8888")) {

			System.out.println("First Name: " + resultFirstName + " ; " + " Last Name: " + resultLastName
					+ "Business Phone: " + resultMobileNo);
			System.out.println(" ");
			System.out.println("Updated New Caller >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Error!! >> TestCase failed");
		}

	}

}
