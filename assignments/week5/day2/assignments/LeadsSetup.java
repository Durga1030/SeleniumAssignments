package week5.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadsSetup {

	/*
	 * 1. Try to run CreateLead Testcase 3 times sequentially using appropriate
	 * annotation attribute ( Use invocationCount =3) 2. Implement the common
	 * DataProvider. 3. Dynamic data parametrization for all the 5 testcases -
	 * Create new excel document for the testcases that require the multiple data to
	 * operate on. - Implement the Data parametrization for all the required
	 * testcases through the DataProvider class to read the data from the excel
	 * sheet
	 */

	ChromeDriver driver;

	@Parameters({ "url", "uname", "password" })
	@BeforeMethod
	public void loginSetUp(String url, String uname, String password) {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		// Launch URL
		driver.get(url);
		driver.manage().window().maximize();

		// Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(password);

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
