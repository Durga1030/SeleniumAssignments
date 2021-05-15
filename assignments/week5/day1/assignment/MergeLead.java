package week5.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MergeLead extends Leads {

	@Test
	public void mergeLead() throws InterruptedException {

		// Click on Merge Leads
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();

		// Assign From Lead Value
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click(); // Lookup

		// Window Handle
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("WindowHandling: " + allWindowHandles.size());
		List<String> lstWindowHandles = new ArrayList<String>(allWindowHandles);
		System.out.println(" ");

		// Switch to sub-window
		driver.switchTo().window(lstWindowHandles.get(1));
		System.out.println("Sub-Window(From Lead) Title: " + driver.getTitle());
		System.out.println("Sub-Window(From Lead) URL: " + driver.getCurrentUrl());
		System.out.println(" ");

		// Assign First Name in Find Leads popup window
		driver.findElement(By.name("firstName")).sendKeys("Durga_Test");

		// Find Leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);

		// Click on first display result
		driver.findElement(By.xpath("//a[@class='linktext']")).click();

		driver.switchTo().window(lstWindowHandles.get(0));

		String fromId = driver.findElement(By.id("ComboBox_partyIdFrom")).getAttribute("value");
		System.out.println("From Id: " + fromId);

		System.out.println("Parent-Window Title: " + driver.getTitle());
		System.out.println("Parent-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");

		// Assign To Lead Value

		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click(); // Lookup

		allWindowHandles = driver.getWindowHandles();
		System.out.println("WindowHandling: " + allWindowHandles.size());
		lstWindowHandles = new ArrayList<String>(allWindowHandles);
		System.out.println(" ");

		// Switch to sub-window
		driver.switchTo().window(lstWindowHandles.get(1));
		System.out.println("Sub-Window(To Lead) Title: " + driver.getTitle());
		System.out.println("Sub-Window(To Lead) URL: " + driver.getCurrentUrl());
		System.out.println(" ");

		// Assign First Name in Find Leads popup window
		driver.findElement(By.name("firstName")).sendKeys("DJ_Test");

		// Find Leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);

		// Click on first display result
		driver.findElement(By.xpath("//a[@class='linktext']")).click();

		driver.switchTo().window(lstWindowHandles.get(0));

		String toId = driver.findElement(By.id("ComboBox_partyIdTo")).getAttribute("value");
		System.out.println("To Id: " + toId);

		System.out.println("Switching back to Parent-Window. Title: " + driver.getTitle());
		// System.out.println("Parent-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");

		// Click on Merge Button

		driver.findElement(By.linkText("Merge")).click();

		// Switch to Alert and accept.
		Alert alert = driver.switchTo().alert();
		// System.out.println("Alert: " + alert.getText());
		alert.accept();

		// Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		// Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(fromId);

		// Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		// Verify message "No records to display" in the Lead List. This message
		// confirms the successful deletion
		boolean status = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();

		if (status) {
			System.out.println(fromId + " has been merged with " + toId);
		} else {
			System.err.println("Merge step failed");
		}

	}
}
