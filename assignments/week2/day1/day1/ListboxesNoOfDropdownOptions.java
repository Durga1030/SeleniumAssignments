package week2.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListboxesNoOfDropdownOptions {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		Select dd3 = new Select(driver.findElement(By.className("dropdown")));
		List<WebElement> doptions = dd3.getOptions();
		int ddcount = doptions.size();
		System.out.println("Number of dropdown options: " + ddcount);
		driver.close();
	}

}
