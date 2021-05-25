package week6.day2.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import week6.day2.assignments.hooks.TestNgHooks;

public class IncUserServiceNow extends TestNgHooks {

	public IncNewRecordPage assignUserValue() throws InterruptedException {
		TestNgHooks.switchToSubWindow1();
		WebElement searchUser = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		searchUser.sendKeys("System");
		searchUser.sendKeys(Keys.ENTER);
		driver.findElement(By.linkText("System Administrator")).click();
		TestNgHooks.switchToParentWindow();
		driver.switchTo().frame(0);
		return new IncNewRecordPage();
	}
}
