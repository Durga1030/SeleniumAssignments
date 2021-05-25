package week6.day2.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import week6.day2.assignments.hooks.TestNgHooks;

public class ServiceHomePage extends TestNgHooks {

	public ServiceHomePage verifySuccessMessage() {
		String message = driver.findElement(By.className("navbar-header")).getText();

		if (message.contains("Welcome")) {
			System.out.println("Login Success");
		}
		return this;
	}

	public IncidentSelfService filterNavigatorIncident() {
		WebElement filterNav = driver.findElement(By.id("filter"));
		filterNav.sendKeys("Incident");
		filterNav.sendKeys(Keys.ENTER);
		driver.switchTo().frame(0);
		return new IncidentSelfService();
	}

	public ProposalSelfService filterNavigatorProposal() {
		WebElement filterNav = driver.findElement(By.id("filter"));
		filterNav.sendKeys("Proposals");
		filterNav.sendKeys(Keys.ENTER);
		driver.switchTo().frame(0);
		return new ProposalSelfService();
	}

	public UserSelfService filterNavigatorCaller() {
		WebElement filterNav = driver.findElement(By.id("filter"));
		filterNav.sendKeys("Callers");
		filterNav.sendKeys(Keys.ENTER);
		TestNgHooks.switchToFrame0();
		return new UserSelfService();

	}

	public TaskSelfService filterNavigatorWork() throws InterruptedException {

		// My Work is for both Request Management & Chat Queue

		WebElement filterNav = driver.findElement(By.id("filter"));
		filterNav.sendKeys("My Work");
		Thread.sleep(500);
		filterNav.sendKeys(Keys.ENTER);
		TestNgHooks.switchToFrame0();
		return new TaskSelfService();

	}

	public TaskSelfService filterNavigatorExistingWork() throws InterruptedException {

		// My Work is for both Request Management & Chat Queue

		WebElement filterNav = driver.findElement(By.id("filter"));
		filterNav.sendKeys("My Work");
		Thread.sleep(500);
		filterNav.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='My Work']")).click();
		TestNgHooks.switchToFrame0();
		return new TaskSelfService();

	}

	/*
	 * public TaskSelfService clickMyWorkOption() {
	 * driver.findElement(By.xpath("//div[text()='My Work']")).click(); //
	 * TestNgHooks.switchToFrame0(); return new TaskSelfService(); }
	 */

	public KnowledgeSelfService filterNavigatorArticle() throws InterruptedException {
		WebElement filterNav = driver.findElement(By.id("filter"));
		filterNav.sendKeys("Knowledge");
		filterNav.sendKeys(Keys.ENTER);
		// TestNgHooks.switchToFrame0();
		return new KnowledgeSelfService();

	}

}
