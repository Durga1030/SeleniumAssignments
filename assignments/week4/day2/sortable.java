package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sortable {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// ScrollDwon
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);

		// Switch to frame
		driver.switchTo().frame(0);

		// find element1
		WebElement element1 = driver.findElement(By.xpath("//li[text()='Item 1']"));

		// find element5
		WebElement element5 = driver.findElement(By.xpath("//li[text()='Item 5']"));

		// DragandDrop
		int resulty = element5.getLocation().getY();
		System.out.println(resulty);

		Actions actions = new Actions(driver);

		actions.dragAndDropBy(element1, 0, resulty).perform();
		System.out.println("Moved");

	}

}
