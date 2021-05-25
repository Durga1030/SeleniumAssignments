package week6.day2.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import week6.day2.assignments.hooks.TestNgHooks;

public class TaskSelfService extends TestNgHooks {

	static String resultState;
	static String resultNumber;
	static String resultantCQNum;
	static String resultantShortDesc;
	static String resultantCQText;

	public TypesOfTaskPage clickOnTaskNewButton() {
		driver.findElement(By.id("sysverb_new")).click();
		return new TypesOfTaskPage();
	}

	public TaskSelfService getNumOption() {
		WebElement searchNum = driver.findElement(By.cssSelector("span#task_hide_search>div>div>span>span>select"));
		new Select(searchNum).selectByIndex(1);
		return this;
	}

	public TaskSelfService getNumOptionValue() {
		WebElement enterNum = driver.findElement(By.cssSelector("span#task_hide_search>div>div>input"));
		enterNum.click();
		enterNum.sendKeys(RequestNewRecordPage.reqNum, Keys.ENTER);
		return this;
	}

	public TaskSelfService getExistingData(String reqNum) throws InterruptedException {
		WebElement setReqNum = driver.findElement(By.cssSelector("span#task_hide_search>div>div>input"));
		setReqNum.click();
		setReqNum.sendKeys(reqNum, Keys.ENTER);
		Thread.sleep(1000);
		return this;
	}

	public ChatQueueEntry clickFirstResultantCQNum() {
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		return new ChatQueueEntry();
	}

	public RequestPage clickFirstResultantNumber() {
		driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(3)>a")).click();
		return new RequestPage();
	}

	public TaskSelfService getResultantStateValue() {
		resultState = driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(5)")).getText();
		return this;
	}

	public TaskSelfService getResultantNumberValue() {
		resultNumber = driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(3)")).getText();
		return this;
	}

	public TaskSelfService verifyWorkCreationStatus() {

		if (resultNumber.equalsIgnoreCase(RequestNewRecordPage.reqNum)) {
			System.out.println(resultNumber + " has been created successfully.");
			System.out.println(" ");
			System.out.println("State: " + resultState);
			System.out.println(" ");
			System.out.println("Create New Work>> Test Case passed - closing window");
			driver.close();

		} else {
			System.err.println("Unable to create work >> TestCase failed");

		}

		return this;
	}

	public TaskSelfService verifyWorkDeletionStatus(String reqNum) {

		String expectedResult = "No records to display";
		String verifyCancelStatus = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();

		if (verifyCancelStatus.equalsIgnoreCase(expectedResult)) {
			System.out.println("Your request number: " + reqNum + " has been deleted successfully");
			System.out.println(" ");
			System.out.println("Test Case passed - closing window");

		} else {
			System.err.println("TestCase failed");
		}

		return this;
	}

	public TaskSelfService getCQNumOption() {
		WebElement forTextNum = driver.findElement(By.cssSelector("span#task_hide_search>div>div>span>span>select"));
		new Select(forTextNum).selectByIndex(1);

		return this;
	}

	public TaskSelfService getCQnumValue() {
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys(ChatQueueNewEntryPage.cQEntryNum, Keys.ENTER);
		return this;
	}

	public TaskSelfService enterExistingCQNum(String extCQNum) {
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys(extCQNum, Keys.ENTER);
		return this;
	}

	public TaskSelfService getResultantShortDesc() {
		resultantShortDesc = driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(7)"))
				.getText();
		System.out.println(resultantShortDesc);

		return this;
	}

	public TaskSelfService getResultantCQNum() {
		resultantCQNum = driver.findElement(By.cssSelector("table#task_table>tbody>tr>td:nth-of-type(3)")).getText();
		return this;
	}

	public TaskSelfService verifyCreatedChatQ() {
		if (resultantCQNum.equalsIgnoreCase(ChatQueueNewEntryPage.cQEntryNum)) {
			System.out.println(resultantCQNum + " has been created >> Test Case passed - closing window");
		} else {
			System.err.println("Failed to create Chat Queue, Error occurred");
		}

		return this;
	}

	public TaskSelfService verifyCQEntryUpdate(String shortDescVal) {
		if (resultantCQNum.equalsIgnoreCase(ChatQueueEntry.cQEntryNum)
				&& resultantShortDesc.equalsIgnoreCase(shortDescVal)) {
			System.out.println(resultantCQNum + " has been updated with description: " + shortDescVal
					+ ">> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println("Failed to update Chat Queue, Error occurred");
		}
		return this;
	}

	public TaskSelfService getResultantText() {
		resultantCQText = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();

		return this;
	}

	public TaskSelfService verifyDeleteCQStatus() {

		String expectedText = "No records to display";

		if (resultantCQText.equalsIgnoreCase(expectedText)) {
			System.out.println(ChatQueueEntry.cQEntryNum + " has been deleted");
			System.out.println(" ");
			System.out.println("Delete Existing CQ >> Test Case passed - closing window");
			driver.quit();

		} else {
			System.err.println(ChatQueueEntry.cQEntryNum + " hasn't been deleted");
			System.out.println(" ");
			System.err.println("Delete CQ - TestCase failed");
		}
		return this;

	}

}
