package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class CreateChangeRequest extends TestNgHooks {

	public ChangeNewRecordPage clickOnNormalChange() {
		click(locateElement("xpath", "(//div[@class='chg-model-model-description change-model-truncate'])[2]"));
		return new ChangeNewRecordPage();
	}

	public ChangeReqServices clickOpenOption() {
		click(locateElement("xpath", "(//div[text()='Open'])[3]"));
		switchToFrame(0);
		return new ChangeReqServices();

	}

	public CreateChangeRequest clickCreateNewOption() {
		click(locateElement("xpath", "(//div[text()='Create New'])[3]"));
		switchToFrame(0);
		return this;

	}

}
