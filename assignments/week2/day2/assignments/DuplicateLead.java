package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		// 1. Launch URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		// 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// 4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

//		6.	Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();

//		7.	Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

//		8.	Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();

//		9.	Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys("xyz@gmail.com");

//		10.	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(2000);

//		11.	Capture name of First Resulting lead
		String firstName = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])/a"))
				.getText();
		System.out.println("First Resulting lead: " + firstName);

//		12.	Click First Resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])/a")).click();

//		13.	Click Duplicate Lead
		driver.findElement(By.xpath("(//a[text()='Duplicate Lead'])")).click();

//		14.	Verify the title as 'Duplicate Lead'
		String getTitle = driver.findElement(By.xpath("(//div[@id='sectionHeaderTitle_leads'])")).getText();
		if (getTitle.equalsIgnoreCase("Duplicate Lead")) {
			System.out.println("Title verification success");
		} else {
			System.out.println("Incorrect Title. Have a check on it");
		}

//		15.	Click Create Lead
		driver.findElement(By.className("smallSubmit")).click();

//		16.	Confirm the duplicated lead name is same as captured name
		String duplicatedFname = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(duplicatedFname);

		if (firstName.equalsIgnoreCase(duplicatedFname)) {
			System.out.println("Duplicated lead name is same as captured name: ");
		} else {
			System.err.println("Name not matched !! Have a check on it");
		}

// 		17. Close the browser (Do not log out)
		driver.close();

	}
}