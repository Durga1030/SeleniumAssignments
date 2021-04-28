package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListboxSelectProgram {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();

		driver.findElementByXPath("//option[@disabled='true']/following-sibling::option[3]").click();

	}

}
