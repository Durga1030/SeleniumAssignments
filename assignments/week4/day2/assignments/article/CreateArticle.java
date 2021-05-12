package week4.day2.assignments.article;

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

public class CreateArticle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
// Launch ServiceNow application - https://dev103117.service-now.com
		driver.get("https://dev103117.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

// Login with valid credentials username as admin and password as India@123

		// Switch to frame
		driver.switchTo().frame(0);

		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();

// Enter Knowledge in filter navigator and press enter"

		WebElement filterNav = driver.findElement(By.id("filter"));
		filterNav.sendKeys("Knowledge");
		filterNav.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//div[@data-id='d78ed921ff4221009b20ffffffffffdf']//div[1]")).click();

		driver.switchTo().frame(0);

		String number = driver.findElement(By.id("sys_readonly.kb_knowledge.number")).getAttribute("value");
		System.out.println("K Num: " + number);

		driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_knowledge_base']//span[1]")).click(); // Knowledge
																												// Lookup
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("WindowHandling: " + allWindowHandles.size());
		List<String> lstWindowHandles = new ArrayList<String>(allWindowHandles);
		System.out.println(" ");

		// Switch to sub-window
		driver.switchTo().window(lstWindowHandles.get(1));
		System.out.println("Sub-Window Title: " + driver.getTitle());
		System.out.println("Sub-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");

		driver.findElement(By.linkText("Knowledge")).click();

		driver.switchTo().window(lstWindowHandles.get(0));

		System.out.println("Parent-Window Title: " + driver.getTitle());
		System.out.println("Parent-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");
		driver.switchTo().frame(0);

		System.out.println("Updated Knowledge");
		System.out.println(" ");

		WebElement shortDesc = driver.findElement(By.id("kb_knowledge.short_description"));
		shortDesc.click();
		shortDesc.clear();
		shortDesc.sendKeys("Test - New proposal creation");

		System.out.println("Updated Short Description");
		System.out.println(" ");

		driver.findElement(By.cssSelector("button#sysverb_insert_bottom")).click();

		// Verify

		WebElement searchOptionNum = driver
				.findElement(By.cssSelector("span#kb_knowledge_hide_search>div>div>span>span>select"));
		new Select(searchOptionNum).selectByIndex(1);

		WebElement eleSearch = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		eleSearch.click();
		eleSearch.sendKeys(number);
		eleSearch.sendKeys(Keys.ENTER);

		String resultKNum = driver.findElement(By.xpath("(//tr[@data-list_id='kb_knowledge']//td)[3]")).getText();
		String resultShortDesc = driver.findElement(By.xpath("(//tr[@data-list_id='kb_knowledge']//td)[4]")).getText();

		if (resultKNum.equalsIgnoreCase(number)) {

			System.out.println("Knowledge Number:" + resultKNum + " & Description: " + resultShortDesc);
			System.out.println(" ");
			System.out.println("Created New Article >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Error!! >> TestCase failed");
		}

	}
}
