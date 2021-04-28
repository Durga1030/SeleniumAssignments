package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperlinkHomePage {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		String str = "Locators and Selenium Interactions";

		driver.get("http://www.leafground.com/pages/Link.html");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[text()='Go to Home Page']")).click();

		Thread.sleep(2000);

		String hPage = driver.findElement(By.className("wp-heading")).getText();

		if (str.equalsIgnoreCase(hPage)) {
			System.out.println("Logged in Home Page");
			driver.close();
		} else
			System.err.println("Login failed: Have a check on it");
	}

}
