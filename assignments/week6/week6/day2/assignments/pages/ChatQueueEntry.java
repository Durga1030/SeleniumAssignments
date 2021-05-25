package week6.day2.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import week6.day2.assignments.hooks.TestNgHooks;

public class ChatQueueEntry extends TestNgHooks {

	static String cQEntryNum;

	public ChatQueueEntry getCQNum() {
		cQEntryNum = driver.findElement(By.id("chat_queue_entry.number")).getAttribute("value"); // CHAT0010018,
		return this;
	}

	public ChatQueueEntry getShortDesc(String shortDescVal) {
		WebElement shortDesc = driver.findElement(By.id("chat_queue_entry.short_description"));
		shortDesc.click();
		shortDesc.clear();
		shortDesc.sendKeys(shortDescVal);
		return this;
	}

	public ChatQueueEntry getLongDesc(String longDescVal) {
		WebElement longDesc = driver.findElement(By.id("chat_queue_entry.description"));
		longDesc.click();
		longDesc.clear();
		longDesc.sendKeys(longDescVal);
		return this;
	}

	public TaskSelfService clickOnUpdateBtn() {
		driver.findElement(By.id("sysverb_update")).click();
		return new TaskSelfService();
	}

	public TaskSelfService clickDeleteBtn(String deleteCQVal) {
		System.out.println(cQEntryNum + " needs to delete");
		// Delete the Entry
		if (cQEntryNum.equalsIgnoreCase(deleteCQVal)) {
			driver.findElement(By.id("sysverb_delete")).click();
			driver.findElement(By.cssSelector("button#ok_button")).click();
		}

		return new TaskSelfService();
	}

}
