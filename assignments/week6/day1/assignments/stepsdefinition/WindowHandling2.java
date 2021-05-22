package week6.day1.assignments.stepsdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import io.cucumber.java.en.And;

public class WindowHandling2 extends BaseSetup {

	Set<String> allWindowHandles = driver.getWindowHandles();

	List<String> lstWindowHandles = new ArrayList<String>(allWindowHandles);

	@And("Window Handling to FromLead SubWindow")
	public void switchToSubWindow1() {
		System.out.println("WindowHandling: " + allWindowHandles.size());
		System.out.println(" ");

		// Switch to From Lead sub-window
		driver.switchTo().window(lstWindowHandles.get(1));

		System.out.println("Sub-Window(From Lead) Title: " + driver.getTitle());
		System.out.println("Sub-Window(From Lead) URL: " + driver.getCurrentUrl());
		System.out.println(" ");
	}

	@And("Window Handling to ToLead SubWindow")
	public void switchToSubWindow2() {
		allWindowHandles = driver.getWindowHandles();
		System.out.println("WindowHandling: " + allWindowHandles.size());
		lstWindowHandles = new ArrayList<String>(allWindowHandles);
		System.out.println(" ");

		driver.switchTo().window(lstWindowHandles.get(1));

		System.out.println("Sub-Window(From Lead) Title: " + driver.getTitle());
		System.out.println("Sub-Window(From Lead) URL: " + driver.getCurrentUrl());
		System.out.println(" ");
	}

	@And("Window Handling to ParentWindow")
	public void switchToParentWindow() throws InterruptedException {

		driver.switchTo().window(lstWindowHandles.get(0));

		System.out.println("Parent-Window Title: " + driver.getTitle());
		System.out.println("Parent-Window URL: " + driver.getCurrentUrl());
		System.out.println(" ");
		Thread.sleep(1000);

	}

}
