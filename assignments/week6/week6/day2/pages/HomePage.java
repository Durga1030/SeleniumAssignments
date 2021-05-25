package week6.day2.pages;

import org.openqa.selenium.By;

import week6.day2.hooks.HooksTest;

public class HomePage extends HooksTest {

	public HomePage verifySuccessMessage() {
		String message = driver.findElement(By.cssSelector("div#form>h2")).getText();

		if (message.contains("Welcome")) {
			System.out.println("Login Success");
		}
		return this;
	}

	public ErrorPage verifyfailureMessage() {
		String message = driver.findElement(By.cssSelector("div#form>h2")).getText();

		if (!message.contains("Welcome")) {
			System.out.println("Login Failure");
		}
		return new ErrorPage();
	}

	public LoginPage clickLogout() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new LoginPage();
	}

	public MyHomePage clickCrmSfaLink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage();
	}

}
