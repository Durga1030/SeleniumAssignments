package week6.day2.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import week6.day2.assignments.hooks.TestNgHooks;

public class UserSelfService extends TestNgHooks {

	static String resultMobileNo;
	static String resultLastName;
	static String resultFirstName;

	public UserSelfService verifySuccessMessage() {
		driver.switchTo().frame(0);
		String selfServiceView = driver.findElement(By.cssSelector("div#list_nav_incident>div>div>h1>a")).getText();

		if (selfServiceView.contains("Users[ITIL view]")) {
			System.out.println("Login Success");
		}
		return this;

	}

	public UserSelfService searchLastNameOption() {
		WebElement searchOptionLastName = driver
				.findElement(By.cssSelector("span#sys_user_hide_search>div>div>span>span>select"));
		new Select(searchOptionLastName).selectByIndex(1);
		return this;
	}

	public UserSelfService searchLastNameValue(String lastName) {

		WebElement searchValue = driver.findElement(By.cssSelector("span#sys_user_hide_search>div>div>input"));
		searchValue.click();
		searchValue.sendKeys(lastName);
		searchValue.sendKeys(Keys.ENTER);

		return this;
	}

	public UserSelfService searchBusinessPhnOption() {
		WebElement searchOptionLastName = driver
				.findElement(By.cssSelector("span#sys_user_hide_search>div>div>span>span>select"));
		new Select(searchOptionLastName).selectByIndex(3);
		return this;
	}

	public UserSelfService searchBusinessPhnValue(String businessNum) {

		WebElement searchValue = driver.findElement(By.cssSelector("span#sys_user_hide_search>div>div>input"));
		searchValue.click();
		searchValue.sendKeys(businessNum);
		searchValue.sendKeys(Keys.ENTER);

		return this;
	}

	public UserSelfService getResultantPhNum() {
		resultMobileNo = driver.findElement(By.xpath("(//td[@class='vt'])[3]")).getText();
		return this;
	}

	public UserSelfService getResultantFName() {
		resultFirstName = driver.findElement(By.cssSelector("table#sys_user_table>tbody>tr>td:nth-of-type(4)"))
				.getText();

		return this;
	}

	public UserSelfService getResultantLName() {
		resultLastName = driver.findElement(By.cssSelector("table#sys_user_table>tbody>tr>td:nth-of-type(3)>a"))
				.getText();

		return this;
	}

	public UserUpdateRecordPage clickOnResultingResult() {
		driver.findElement(By.cssSelector("table#sys_user_table>tbody>tr>td:nth-of-type(3)>a")).click();
		return new UserUpdateRecordPage();
	}

	public UserSelfService verifyUpdatedUserInfo(String firstName, String lastName, String businessNum)
			throws InterruptedException {
		if (resultLastName.equalsIgnoreCase(lastName) && resultFirstName.equalsIgnoreCase(firstName)
				&& resultMobileNo.equalsIgnoreCase(businessNum)) {

			System.out.println("First Name: " + resultFirstName + " ; " + " Last Name: " + resultLastName
					+ "Business Phone: " + resultMobileNo);
			System.out.println(" ");
			System.out.println("Updated New Caller >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.out.println("First Name: " + resultFirstName + " ; " + " Last Name: " + resultLastName
					+ "Business Phone: " + resultMobileNo);
			System.err.println("Error!! >> TestCase failed");
		}

		return this;
	}

	public UserNewRecordPage clickNewButton() {
		driver.findElement(By.cssSelector("button#sysverb_new")).click();
		return new UserNewRecordPage();
	}

	public UserSelfService verifyCreatedUser(String firstName, String lastName) {
		WebElement forTextLastNameFirst = driver
				.findElement(By.cssSelector("span#sys_user_hide_search>div>div>span>span>select"));
		new Select(forTextLastNameFirst).selectByIndex(1);

		WebElement searchfirstName = driver.findElement(By.cssSelector("span#sys_user_hide_search>div>div>input"));
		searchfirstName.click();
		searchfirstName.sendKeys(firstName, Keys.ENTER);

		if (resultLastName.equalsIgnoreCase(lastName) && resultFirstName.equalsIgnoreCase(firstName)) {

			System.out.println("First Name: " + resultFirstName + " ; " + " Last Name: " + resultLastName);
			System.out.println(" ");
			System.out.println("Create New Caller >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Error!! >> TestCase failed");
		}
		return this;
	}

}
