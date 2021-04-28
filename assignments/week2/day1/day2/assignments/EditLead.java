package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		// 1. Launch URL
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

// 		8. Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Durga");

// 		9. Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(2000);

// 		10. Click on first resulting lead
		String firstName = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])/a"))
				.getText();
		System.out.println("First Resulting lead: " + firstName);

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])/a")).click();

// 		11.a Verify title of the page
		String title = driver.getTitle();
		System.out.println(title);

//		b. Get the Company name before edit
		String company = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		company = company.replaceAll("[^a-zA-Z]", "");
//		System.out.println(company);

// 		12. Click Edit
		driver.findElement(By.xpath("(//a[text()='Edit'])")).click();

// 		13. Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Amazon");

// 		14. Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();

// 		15. Confirm the changed name appears
		String cName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		cName = cName.replaceAll("[^a-zA-Z]", "");

		if (cName != company) {
			System.out.println(company + " has been successfully changed to " + cName);
		} else {
			System.out.println(company + "Company name not changed, need to look into it " + cName);
		}

// 		16. Close the browser (Do not log out)
		driver.close();
	}
}