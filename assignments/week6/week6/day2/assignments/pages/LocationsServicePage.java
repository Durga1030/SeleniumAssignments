package week6.day2.assignments.pages;

import org.openqa.selenium.By;

import week6.day2.assignments.hooks.TestNgHooks;

public class LocationsServicePage extends TestNgHooks {

	public LocationsServicePage expandOptionAmericas() {
		TestNgHooks.switchToSubWindow1();
		driver.findElement(By.xpath("//img[@src='images/gwt/treenode_expand_plus.gifx']")).click();
		return this;
	}

	public LocationsServicePage expandOptionNorthAmerica() {
		driver.findElement(By.xpath(
				"//div[@id='treenode_0']/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/img[1]"))
				.click();
		return this;
	}

	public RequestNewRecordPage clickOnRhodeIsland() throws InterruptedException {
		driver.findElement(By.linkText("Rhode Island")).click();
		TestNgHooks.switchToParentWindow();
		TestNgHooks.switchToFrame0();
		return new RequestNewRecordPage();
	}

}
