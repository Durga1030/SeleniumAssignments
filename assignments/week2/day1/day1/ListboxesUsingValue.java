package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListboxesUsingValue {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();

		WebElement pValue = driver.findElement(By.name("dropdown3"));

		Select dd3 = new Select(pValue);
		dd3.selectByValue("1");

		// driver.close();
	}

}
