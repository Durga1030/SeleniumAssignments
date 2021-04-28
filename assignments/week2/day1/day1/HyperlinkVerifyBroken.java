package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperlinkVerifyBroken {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		String str = "HTTP Status 404 – Not Found";

		driver.get("http://www.leafground.com/pages/Link.html");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@href ='error.html']")).click();

		Thread.sleep(2000);

		String hPage = driver.getTitle();

		if (str.equalsIgnoreCase(hPage)) {
			System.out.println("Navigated to error.html page");
			driver.close();
		}
	}

}
