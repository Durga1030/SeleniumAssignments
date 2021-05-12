package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindows {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("home")).click();

		// Click on button
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();

		// Print the number of window size
		Set<String> allWindowHandles = driver.getWindowHandles();

		System.out.println(allWindowHandles.size());

		List<String> lstWindowHandles = new ArrayList<String>(allWindowHandles);

		// Switch to sub-window 1
		driver.switchTo().window(lstWindowHandles.get(1));
		driver.close();

		// Switch to sub-window 2
		driver.switchTo().window(lstWindowHandles.get(2));
		driver.close();

		// Switch to sub-window 3
		driver.switchTo().window(lstWindowHandles.get(3));
		driver.close();

		// Move to parent window
		driver.switchTo().window(lstWindowHandles.get(0));

		// confirm the page info
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

	}

}
