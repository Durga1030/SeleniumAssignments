package week6.day2.assignments.stepsdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowLoginSetup extends BaseSetup {

	@Given("Launch Chrome browser")
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@When("Load URL {string}")
	public void loadUrl(String url) {
		driver.get(url);
	}

	@And("Type username as {string}")
	public void typeUserName(String username) {
		driver.findElement(By.id("user_name")).sendKeys(username);
	}

	@And("Type password as {string}")
	public void typePassword(String password) {
		driver.findElement(By.id("user_password")).sendKeys(password);
	}

	@And("Click Login Button")
	public void clickLogin() {
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}

	@Then("Verify Login is successful")
	public void isSuccess() {
		String expectedHeaderText = driver.findElement(By.xpath("//span[text()='Service Management']")).getText();
		String serviceNowPage = driver.findElement(By.className("navbar-header")).getText();
		if (expectedHeaderText.contains(serviceNowPage)) {
			System.out.println("Logged in success of Service now Application");
		}

	}

	@When("Enter Value in FilterNavigator as (.*)$")
	public void getValueFilterNav(String filterNav) throws InterruptedException {
		WebElement filterNavigator = driver.findElement(By.id("filter"));
		filterNavigator.sendKeys(filterNav);
		Thread.sleep(1000);
		filterNavigator.sendKeys(Keys.ENTER);
	}
}
