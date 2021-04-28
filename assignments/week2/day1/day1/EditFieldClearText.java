package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFieldClearText {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		System.out.println("Text has been cleared");

		driver.close();
	}

}
