package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListboxesUsingText {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();

		WebElement pText = driver.findElement(By.name("dropdown2"));
		Select dd2 = new Select(pText);
		dd2.selectByVisibleText("Selenium");

		// driver.close();
	}

}
