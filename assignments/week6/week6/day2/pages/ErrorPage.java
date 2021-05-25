package week6.day2.pages;

import week6.day2.hooks.HooksTest;

public class ErrorPage extends HooksTest {

	public ErrorPage captureErrorDisplayed() {
		String title = driver.getTitle();

		if (!title.contains("Leaftaps")) {
			System.err.println("Error occurred!! - Expected page is not displayed");
		}
		return this;

	}

}
