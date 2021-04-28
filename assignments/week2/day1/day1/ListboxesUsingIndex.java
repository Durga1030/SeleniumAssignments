package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListboxesUsingIndex {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();

		WebElement pIndex = driver.findElement(By.id("dropdown1"));

		Select dd1 = new Select(pIndex);
		dd1.selectByIndex(1);

		System.out.println(dd1);

		driver.close();
	}

}
