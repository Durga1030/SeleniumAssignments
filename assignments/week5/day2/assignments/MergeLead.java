package week5.day2.assignments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MergeLead extends LeadsSetup {

	@DataProvider(name = "TestData")
	public Object[][] getData() throws InvalidFormatException, IOException {

		String[][] data = ReadExcelForData.readExcel("MergeLead");
		return data;

	}

	@Test(dataProvider = "TestData")
	public void mergeLead(String fName1, String fName2) throws InterruptedException {

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
		driver.findElement(By.name("firstName")).sendKeys(fName1);

		// Find Leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);

		// Click on first display result
		driver.findElement(By.xpath("//a[@class='linktext']")).click();

		driver.switchTo().window(lstWindowHandles.get(0));

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
		driver.findElement(By.name("firstName")).sendKeys(fName2);

		// Find Leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);

		// Click on first display result
		driver.findElement(By.xpath("//a[@class='linktext']")).click();

		driver.switchTo().window(lstWindowHandles.get(0));

		System.out.println("Switching back to Parent-Window. Title: " + driver.getTitle());
		// System.out.println("Parent-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");

		// Click on Merge Button
		driver.findElement(By.linkText("Merge")).click();

		System.out.println("Merge Leads >> Test case passed");

	}

}
