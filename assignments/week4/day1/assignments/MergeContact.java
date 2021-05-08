package week4.day1.assignments;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

// 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

// 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

// 4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

// 5. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

// 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		Thread.sleep(2000);

		/*
		 * 7 a)Create Set and List to handle the Windows. b) Click on Widget of From
		 * Contact and Switch to From Contact page
		 */
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> lstWindowHandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstWindowHandles.get(1));

// 7 d) Type the Contact id in Search box and Click on Search
		driver.findElement(By.name("id")).sendKeys("10174");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();

		Thread.sleep(2000);

// 8. Click on First Resulting Contact and switch to Parent window
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		driver.switchTo().window(lstWindowHandles.get(0));

		System.out.println("From ContactId has been taken - moving to parent window");

// 9 a) Click on Widget of To Contact and Navigate to next window
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();

		windowHandles = driver.getWindowHandles();
		lstWindowHandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstWindowHandles.get(1));

// 9 b) Type the Contact id in Search box and Click on Search
		driver.findElement(By.name("id")).sendKeys("10176");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();

		Thread.sleep(2000);

// 10. Click on Second Resulting Contact
		driver.findElement(By.xpath("//a[@class='linktext']")).click();

		System.out.println("To ContactId has been taken - moving to parent window");

		driver.switchTo().window(lstWindowHandles.get(0));

// 11. Click on Merge button using Xpath Locator
		driver.findElement(By.linkText("Merge")).click();
		System.out.println(" ");
		System.out.println("Alert: - Confirmation on Contacts Merge");
		System.out.println(" ");

// 12. Accept the Alert
		Alert mergeAlert = driver.switchTo().alert();
		mergeAlert.accept();

// 13. Verify the title of the page
		System.out.println(driver.getTitle());

	}
}