package week5.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leads {

	/*
	 * 1. Apply the preCondition and postCondition in the base class ( @BeforeMethod
	 * and @AfterMethod) and implement all the 5 leaftaps testcases (
	 * CreateLead,EditLead,DuplicateLead,MergeLead,DeleteLead). 2. Implement all the
	 * 5 testcases making the annotation attribute "enabled=false" for DeleteLead
	 * testcase alone. Observe how your testcases run.
	 */
	ChromeDriver driver;

	@BeforeMethod
	public void loginSetUp() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		// Launch URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		// Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

//	Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();

	}

	@AfterMethod
	public void tearDown() {
		// Close the browser (Do not log out)
		driver.quit();
	}

}
