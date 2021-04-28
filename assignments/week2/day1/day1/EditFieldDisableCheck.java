package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFieldDisableCheck {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.manage().window().maximize();

		String cDisable = driver.findElement(By.xpath("//input[@disabled='true']")).getAttribute("disabled");

		System.out.println("Get Entered Text:" + cDisable);

		driver.close();
	}

}
