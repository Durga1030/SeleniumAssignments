package week5.day1.assignment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteLead extends Leads {

	@Test(enabled = false)
	public void deleteLead() throws InterruptedException {

//		Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

// 		Click on Phone
		driver.findElement(By.xpath("(//a[@href='#']//em)[2]")).click();

//		Enter phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("245-678-498");

//		Click find 	leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

//		Capture lead ID of First Resulting lead
		String leadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a"))
				.getText();
		System.out.println("Lead Id: " + leadId);

//		Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();

//		Click Delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();

//		Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

//		Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);

//		Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
//		Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		boolean status = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();

		if (status) {
			System.out.println("This message confirms the successful deletion of the mentioned Lead Id");
		} else {
			System.err.println("Deletion step failed");
		}
	}
}