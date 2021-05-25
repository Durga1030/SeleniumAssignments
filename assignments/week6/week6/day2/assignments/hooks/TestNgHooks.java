package week6.day2.assignments.hooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgHooks {
	public static ChromeDriver driver;
	public static Set<String> allWindowHandles;
	public static List<String> lstWindowHandles;

	@BeforeMethod
	public void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dev103117.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.switchTo().frame(0);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public static void switchToFrame0() {
		driver.switchTo().frame(0);
	}

	public static void switchToSubWindow1() {

		allWindowHandles = driver.getWindowHandles();
		System.out.println("WindowHandling: " + allWindowHandles.size());
		lstWindowHandles = new ArrayList<String>(allWindowHandles);
		System.out.println(" ");

		driver.switchTo().window(lstWindowHandles.get(1));

		System.out.println("Sub-Window Title: " + driver.getTitle());
		System.out.println("Sub-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");
	}

	public static void switchToParentWindow() throws InterruptedException {
		allWindowHandles = driver.getWindowHandles();
		lstWindowHandles = new ArrayList<String>(allWindowHandles);
		driver.switchTo().window(lstWindowHandles.get(0));

		System.out.println("Parent-Window Title: " + driver.getTitle());
		System.out.println("Parent-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");
		Thread.sleep(1000);

	}

}
