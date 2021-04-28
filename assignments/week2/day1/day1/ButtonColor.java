package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonColor {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Button.html");
		driver.manage().window().maximize();

		String bColor = driver.findElement(By.xpath("//button[@style='background-color:lightgreen']"))
				.getAttribute("style");

		System.out.println(bColor);

	}

}
