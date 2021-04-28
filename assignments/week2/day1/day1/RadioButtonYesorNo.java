package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonYesorNo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		boolean status = false;

		driver.get("http://www.leafground.com/pages/radio.html");
		driver.manage().window().maximize();

		WebElement radioYes = driver.findElement(By.xpath("//input[@id='yes']"));
		WebElement radioNo = driver.findElement(By.xpath("//input[@id='no']"));

		if (!status) {
			radioYes.click();
			System.out.println("Enjoying the class");
		}

		else {

			radioNo.click();
			System.out.println(" Not interested ");
		}
	}

}
