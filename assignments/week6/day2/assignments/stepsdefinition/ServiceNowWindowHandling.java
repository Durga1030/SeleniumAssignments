package week6.day2.assignments.stepsdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import io.cucumber.java.en.And;

public class ServiceNowWindowHandling extends BaseSetup {

	Set<String> allWindowHandles = driver.getWindowHandles();
	List<String> lstWindowHandles = new ArrayList<String>(allWindowHandles);

	@And("Navigate to SubWindow1")
	public void switchToSubWindow1() {
		allWindowHandles = driver.getWindowHandles();
		System.out.println("WindowHandling: " + allWindowHandles.size());
		lstWindowHandles = new ArrayList<String>(allWindowHandles);
		System.out.println(" ");

		driver.switchTo().window(lstWindowHandles.get(1));

		System.out.println("Sub-Window Title: " + driver.getTitle());
		System.out.println("Sub-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");
	}

	@And("Navigate to SubWindow2")
	public void switchToSubWindow2() {
		allWindowHandles = driver.getWindowHandles();
		System.out.println("WindowHandling: " + allWindowHandles.size());
		lstWindowHandles = new ArrayList<String>(allWindowHandles);
		System.out.println(" ");

		driver.switchTo().window(lstWindowHandles.get(1));

		System.out.println("Sub-Window Title: " + driver.getTitle());
		System.out.println("Sub-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");
	}

	@And("Switch to ParentWindow")
	public void switchToParentWindow() throws InterruptedException {

		driver.switchTo().window(lstWindowHandles.get(0));

		System.out.println("Parent-Window Title: " + driver.getTitle());
		System.out.println("Parent-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");
		Thread.sleep(1000);

	}

	@And("Switch to ParentFrame")
	public void switchToFrame0() {
		driver.switchTo().frame(0);

	}

	@And("Switch to Frame Default")
	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}

}
