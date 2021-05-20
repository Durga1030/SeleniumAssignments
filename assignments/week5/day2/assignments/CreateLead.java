package week5.day2.assignments;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends LeadsSetup {

	@DataProvider(name = "TestData", indices = { 1 })
	public Object[][] getData() throws InvalidFormatException, IOException {

		String[][] data = ReadExcelForData.readExcel("CreateLead");
		return data;

	}

	@Test(dataProvider = "TestData", invocationCount = 3)
	public void createLead(String companyName, String firstName, String lastName) throws InterruptedException {

		driver.findElement(By.linkText("Create Lead")).click();

		// Assign value to Company Name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);

		// Assign value to Last Name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);

		// Assign value to First Name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);

		driver.findElement(By.className("smallSubmit")).click();

		System.out.println("create Lead completed >> Test case passed, closing window");

	}

}
