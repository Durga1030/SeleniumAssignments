package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Switch to frame
		WebElement frameConfirmBox = driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));
		driver.switchTo().frame(frameConfirmBox);

		// Click on Try It Button
		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		// Click OK on the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// Confirm ‘You Pressed OK
		String result = driver.findElement(By.id("demo")).getText();
		System.out.println(result);

		// Exit from Frame
		driver.switchTo().defaultContent();

		// Close browser
		driver.close();
	}

}
