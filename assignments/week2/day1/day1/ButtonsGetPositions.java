package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonsGetPositions {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("position"));
		Point point = element.getLocation();
		System.out.println("Element's position from left side: " + point.getX() + " pixels.");
		System.out.println("Element's position from top is " + point.getY() + " pixels.");
		Thread.sleep(2000);
		driver.close();
	}

}
