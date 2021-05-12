package week4.day2.assignments.changemanagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateSchedule {

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

		Select searchNumberOption = new Select(
				driver.findElement(By.cssSelector("span#change_request_hide_search>div>div>span>span>select")));
		searchNumberOption.selectByIndex(1);

		WebElement searchCHG = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		searchCHG.click();
		searchCHG.sendKeys("CHG0030085");
		searchCHG.sendKeys(Keys.ENTER);

		// Click on Number hyperlink
		String changeNum = driver.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(3)"))
				.getText();
		System.out.println("Number: " + changeNum);
		System.out.println(" ");
		driver.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(3)>a")).click();

// 5. Update the Change Schedule with Start date and End date 

		driver.findElement(By.xpath("//span[text()='Schedule']")).click(); // Click on schedule option

		driver.findElement(By.xpath("(//button[@id='change_request.start_date.ui_policy_sensitive']//span)[3]"))
				.click(); // Click on start date - calender icon
		driver.findElement(By.xpath("(//a[@class='calOtherMonthDateAnchor'])[2]")).click(); // click on start date

		// Save start date
		WebElement dateTimePickerFrom = driver.findElement(By.id("GwtDateTimePicker_ok"));
		dateTimePickerFrom.click();

		// Get Planned Start date/time
		String changerequeststartdate = driver.findElement(By.id("change_request.start_date")).getAttribute("value");

		// click on end date - calender icon
		driver.findElement(By.xpath("(//button[@id='change_request.end_date.ui_policy_sensitive'])[2]")).click();
		WebElement dateTimePickerTo = driver.findElement(By.id("GwtDateTimePicker_ok"));
		dateTimePickerTo.click();

		// Get planned end date/time
		String changerequestenddate = driver.findElement(By.id("change_request.end_date")).getAttribute("value");

// 6. Select CAB Required and CAB date

		// Click on CSB reuired check box
		driver.findElement(By.id("label.ni.change_request.cab_required")).click();

		// Click on CAB date calender icon and select date
		driver.findElement(By.xpath("//a[@data-date_time_format='yyyy-MM-dd']//span[1]")).click();
		driver.findElement(By.cssSelector("a#GwtDateTimePicker_day8")).click();

		System.out.println("Schedule has been updated with date");
		System.out.println(" ");

// 7. Update the Change Request and verify the changes

		driver.findElement(By.id("sysverb_update_bottom")).click();

		String resultantNumber = driver
				.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(3)")).getText();

		String plannedStartDate = driver
				.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(7)")).getText();
		String plannedEndDate = driver
				.findElement(By.cssSelector("table#change_request_table>tbody>tr>td:nth-of-type(8)")).getText();

		if (resultantNumber.equalsIgnoreCase(changeNum) && plannedStartDate.equalsIgnoreCase(changerequeststartdate)
				&& plannedEndDate.equalsIgnoreCase(changerequestenddate)) {

			System.out.println("Change Reuest: " + resultantNumber + " ; " + " Planned Start Date: " + plannedStartDate
					+ " ; " + "Planned End Date: " + plannedEndDate);
			System.out.println(" ");
			System.out.println("Updated schedule for the existing Change >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Error!! " + " >> TestCase failed");
		}

	}

}
