package week6.day2.pages;

import org.openqa.selenium.By;

import week6.day2.hooks.HooksTest;

public class MyHomePage extends HooksTest {

	public MyLeadsPage clickLeadsOption() {
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		return new MyLeadsPage();
	}

}
