package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListboxesSendKeysToSelect {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//option[text()='You can also use sendKeys to select']/parent::select"))
				.sendKeys("Appium");

		// driver.close();
	}

}
