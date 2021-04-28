package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProgressPercentage {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/table.html");
		driver.manage().window().maximize();

		List<WebElement> pPercentage = driver.findElements(By.xpath("//table[@id='table_id']//td[2]"));

		for (int i = 0; i < pPercentage.size(); i++) {

			System.out.print("Progress Percentage: ");
			System.out.println(pPercentage.get(i).getText());

		}
	}

}
