package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonHyperlinkFind {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		String str = "Bond with Buttons";

		driver.get("http://www.leafground.com/pages/Link.html");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@href ='Button.html']")).click();

		Thread.sleep(2000);

		String hPage = driver.findElement(By.className("wp-heading")).getText();

		if (str.equalsIgnoreCase(hPage)) {
			System.out.println("Navigated to Buttons.html page");
			driver.close();
		} else
			System.err.println("Login failed: Have a check on it");
	}

}
