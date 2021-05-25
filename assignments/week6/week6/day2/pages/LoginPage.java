package week6.day2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import week6.day2.hooks.HooksTest;

public class LoginPage extends HooksTest {

	public LoginPage typeUName() {
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		return this;
	}

	public LoginPage typePwd() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		return this;
	}

	public HomePage clickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new HomePage();
	}

	public HomePage typePwdAndEnter() {
		driver.findElement(By.id("password")).sendKeys("crmsfa", Keys.ENTER);
		return new HomePage();
	}

	public LoginPage loginFailure() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return this;
	}

}
