package week4.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Get the element
		WebElement element = driver.findElement(By.id("btn"));

		System.out.println("Text before change: " + element.getText());

		WebElement clickME = driver.findElement(By.xpath("//button[text()='Click ME!']"));
		String text = clickME.getText();

		// Wait for element text to change
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElement(clickME, text));

		// Check if the element exist
		System.out.println("Text after change: " + text);

		// click on button
		driver.findElement(By.xpath("//button[text()='Click ME!']")).click();

		// Wait for alert to appear and accept it
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert: " + alert.getText());
		alert.accept();

		// Close browser
		driver.close();

	}

}
