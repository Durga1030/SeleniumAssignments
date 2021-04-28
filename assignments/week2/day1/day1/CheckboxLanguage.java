package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxLanguage {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		// boolean status = false;

		driver.get("http://www.leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement l = driver.findElement(By.xpath("//div[text()='Java']"));
		l.click();

		// WebElement checkVB = driver.findElement(By.xpath("//div[text()='VB']"));
		// WebElement checkSql = driver.findElement(By.xpath("//div[text()='Sql']"));
		// WebElement checkC = driver.findElement(By.xpath("//div[text()='VB']"));

		/*
		 * if (!status) { checkJava.click(); // checkSql.click();
		 * 
		 * System.out.println("Success"); }
		 * 
		 * else { System.err.println("Failure: Need to Check"); }
		 */ }

}
