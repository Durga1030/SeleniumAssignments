package week2.day1;

//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);

		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");

		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kandasamy");

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Durga");

		WebElement eleSourceId = driver.findElement(By.name("dataSourceId"));

		Select dd1 = new Select(eleSourceId);
		// dd1.selectByVisibleText("Partner");
		// dd1.selectByIndex(7);
		dd1.selectByValue("LEAD_PARTNER");

		// driver.findElement(By.className("smallSubmit")).click();

	}

}
