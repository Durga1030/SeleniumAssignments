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

public class CreateNewWork {

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

// 3. Enter Service catalog in filter navigator and press enter
		WebElement changeManagement = driver.findElement(By.id("filter"));
		changeManagement.sendKeys("My Work");
		changeManagement.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

// 4. Click on My Work

		driver.findElement(By.xpath("(//div[text()='My Work'])")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.id("sysverb_new")).click();

// 5.Select Request Link to create a new request
		driver.findElement(By.linkText("Request")).click();

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

//Expand Americas
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

// Set Approval value as REquested
		WebElement screquestapproval = driver.findElement(By.id("sc_request.approval"));
		new Select(screquestapproval).selectByIndex(1);

// Set Request state as Pending Approval
		WebElement screquestrequeststate = driver.findElement(By.id("sc_request.request_state"));
		new Select(screquestrequeststate).selectByIndex(1);
		System.out.println("State value updated");

		String reqNum = driver.findElement(By.id("sc_request.number")).getAttribute("value");
		System.out.println(reqNum);

// Update
		driver.findElement(By.cssSelector("button#sysverb_insert_bottom")).click();

		WebElement searchNum = driver.findElement(By.cssSelector("span#task_hide_search>div>div>span>span>select"));
		new Select(searchNum).selectByIndex(1);

		WebElement enterNum = driver.findElement(By.cssSelector("span#task_hide_search>div>div>input"));
		enterNum.click();
		enterNum.sendKeys(reqNum);
		enterNum.sendKeys(Keys.ENTER);

// Verify 

		String resultState = driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(5)"))
				.getText();

		String resultNumber = driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(3)"))
				.getText();

		if (resultNumber.equalsIgnoreCase(reqNum)) {
			System.out.println(resultNumber + " has been created successfully.");
			System.out.println(" ");
			System.out.println("State: " + resultState);
			System.out.println(" ");
			System.out.println("Create New Work>> Test Case passed - closing window");
			driver.close();

		} else {
			System.err.println("Unable to create work >> TestCase failed");

		}

	}

}
