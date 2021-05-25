package week6.day2.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import week6.day2.assignments.hooks.TestNgHooks;

public class RequestNewRecordPage extends TestNgHooks {

	static String reqNum;

	public LocationsServicePage clickOnLocationLookup() {
		driver.findElement(By.id("lookup.sc_request.location")).click(); // Location lookup using list
		return new LocationsServicePage();
	}

	public RequestNewRecordPage setApprovalValue() {
		// Set approval cval as Requested.
		WebElement screquestapproval = driver.findElement(By.id("sc_request.approval"));
		new Select(screquestapproval).selectByIndex(1);
		return this;
	}

	public RequestNewRecordPage setRequestStateValue() {
		// Set Request state as Pending Approval
		WebElement screquestrequeststate = driver.findElement(By.id("sc_request.request_state"));
		new Select(screquestrequeststate).selectByIndex(1);
		System.out.println("State value updated");
		return this;
	}

	public RequestNewRecordPage getRequestNum() {
		reqNum = driver.findElement(By.id("sc_request.number")).getAttribute("value");
		System.out.println(reqNum);
		return this;

	}

	public TaskSelfService clickOnSubmitButton() {
		driver.findElement(By.cssSelector("button#sysverb_insert_bottom")).click();
		return new TaskSelfService();

	}

}
