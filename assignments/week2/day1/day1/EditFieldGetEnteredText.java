package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFieldGetEnteredText {

	public static void main(String[] args) {

//username

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.manage().window().maximize();

		String inputField = driver.findElement(By.xpath("//input[@value='TestLeaf']")).getAttribute("value");

		System.out.println("Get Entered Text:" + inputField);

	}

}
