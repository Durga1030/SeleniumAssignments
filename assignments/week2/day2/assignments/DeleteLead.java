package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

// 1. Launch URL "http://leaftaps.com/opentaps/control/main"
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

// 2. Enter UserName Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

// 3. Enter UserName Using Id Locator
		driver.findElement(By.id("password")).sendKeys("crmsfa");

// 4. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

// 5. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

//		6.	Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();

//		7.	Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

// 		8. Click on Phone
		driver.findElement(By.xpath("(//a[@href='#']//em)[2]")).click();

//		9.	Enter phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("245-678-498");

//		10.	Click find 	leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

//		11.	Capture lead ID of First Resulting lead
		String leadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a"))
				.getText();
		System.out.println("Lead Id: " + leadId);

//		12.	Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();

//		13.	Click Delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();

//		14.	Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

//		15.	Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);

//		16.	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
//		17.	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		boolean status = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();

		if (status) {
			System.out.println("This message confirms the successful deletion of the mentioned Lead Id");
		} else {
			System.err.println("Deletion step failed");
		}
//		18.	Close the browser (Do not log out)
		driver.close();
	}
}