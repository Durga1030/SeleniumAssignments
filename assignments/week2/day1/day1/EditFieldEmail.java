package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFieldEmail {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.manage().window().maximize();

		driver.findElement(By.id("email")).sendKeys("durga110@gmail.com");

		System.out.println("Email id has been added");

		Thread.sleep(2000);

		driver.close();
	}

}
