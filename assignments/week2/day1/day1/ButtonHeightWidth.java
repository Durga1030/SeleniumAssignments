package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonHeightWidth {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Button.html");
		driver.manage().window().maximize();

		driver.findElement(By.id("size")).getSize().getHeight();

		WebElement eleSize = driver.findElement(By.id("size"));
		int hSize = eleSize.getSize().getHeight();
		int wSize = eleSize.getSize().getWidth();
		System.out.println("Height: " + hSize + " and " + "Width: " + wSize);
		driver.close();
	}

}
