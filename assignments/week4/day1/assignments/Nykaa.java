package week4.day1.assignments;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

// 1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();

// 2) Mouse-over on Brands and Mouse-over on Popular

		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		WebElement nykaaBrands = driver.findElement(By.xpath("//*[@id=\"headerMenu\"]/ul[1]/li[2]/a"));
		WebElement brandsPopular = driver
				.findElement(By.xpath("//*[@id=\"headerMenu\"]/ul[1]/li[2]/ul/li/section[2]/div[1]/a[1]"));
		actions.moveToElement(nykaaBrands).moveToElement(brandsPopular).click().perform();
		Thread.sleep(2000);

// 3) Click L'Oreal Paris

		// hold all window handles in array list

		// switch to parent window
//		driver.switchTo().window(newTb.get(0));
		System.out.println("Page title of parent window: " + driver.getTitle());
		System.out.println(" ");
		driver.findElement(By.xpath("//*[@id=\"brandCont_Popular\"]/ul/li[5]/a/img")).click();
		Thread.sleep(2000);
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
// 4) Go to the newly opened window and check the title contains L'Oreal Paris

		driver.switchTo().window(newTb.get(1));
		System.out.println("Page title of new tab: " + driver.getTitle());
		System.out.println(" ");
// 5) Click sort By and select customer top rated

		driver.findElement(By.xpath("//div[@class='sort-btn clearfix']")).click();
		driver.findElement(By.xpath("//div[@for='3']")).click();
		Thread.sleep(1000);

		// System.out.println("L'Oreal page filtered: " + driver.getCurrentUrl());

// 6) Click Category and click Shampoo

		driver.findElement(By.xpath("//div[text()='Category']")).click();
		driver.findElement(By.xpath("//div[@class='category-wrap-top']//li")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//label[@for='chk_Shampoo_undefined']//div[1]")).click();
		Thread.sleep(2000);

		System.out.println("Category filter applied");

		System.out.println(" ");

// 7) check whether the Filter is applied with Shampoo
		String filterVerification = driver.findElement(By.xpath("//div[@id='sortComponent']/div[1]/div[1]/ul[1]/li[1]"))
				.getText();
		// System.out.println(filterVerification);

		if (!filterVerification.contains("Shampoo")) {
			System.err.println(filterVerification + " --Filter has been failed to update,.. Need to check-- ");
		} else {
			System.out.println(filterVerification + " ---Filter applied--- ");

		}

// 8) Click on L'Oreal Paris Colour Protect Shampoo

		WebElement textbox = driver.findElement(By.xpath("//input[@class='header__search-input form-control']"));
		textbox.sendKeys("L'Oreal Paris Colour Protect Shampoo");
		textbox.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//div[@class='m-content__product-list__title']//span")).click();

		// shampooLP.click();

// 9) GO to the new window and select size as 175ml

		newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(2));

		System.out.println("Page Navigated - Product detailed information");

		WebElement size = driver.findElement(By.tagName("select"));
		new Select(size).selectByVisibleText("175ml");

// 10) Print the MRP of the product
		String MRP = driver.findElement(By.xpath("//span[text()='MRP:']")).getText();
		String rate = driver.findElement(By.xpath("//span[@class='post-card__content-price-offer']")).getText();
		System.out.println(MRP + rate);

// 11) Click on ADD to BAG
		driver.findElement(By.xpath("//button[text()='ADD TO BAG']")).click();

// 12) Go to Shopping Bag
		driver.findElement(By.className("AddBagIcon")).click();

// 13) Print the Grand Total amount

		String grandTotal = driver.findElement(By.xpath("//div[text()='Grand Total:']")).getText();
		grandTotal = grandTotal.replaceAll("\\D", "").trim();

		int totalAmount = Integer.parseInt(grandTotal);
		System.out.println("Grand Total at Step #13: " + totalAmount);
		Thread.sleep(5000);

// 14) Click Proceed
		driver.findElement(
				By.xpath("//*[@id=\"headerWpr\"]/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/div[2]/button/span"))
				.click();
		System.out.println("Navigated to Login page");

// 15) Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

// 16) Check if this grand total is the same in step 13
		String resultantValue = driver.findElement(By.xpath("//div[text()='Grand Total']/following::span")).getText();
		resultantValue = resultantValue.replaceAll("\\D", "").trim();
		int total = Integer.parseInt(resultantValue);
		System.out.println("Grand Total value at final step: " + total);

		if (totalAmount == total) {
			System.out.println("Amount is same - Verification success");
		}

		else {
			System.err.println("Amount is not matching");
		}

// 17) Close all windows
		driver.quit();
	}

}
