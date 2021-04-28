package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TravelHomePageByClickOnButton {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("home")).click();

		String str = driver.findElementByClassName("wp-heading").getText();

		System.out.println(str);

		driver.close();
	}

}
