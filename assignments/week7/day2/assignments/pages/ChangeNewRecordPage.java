package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class ChangeNewRecordPage extends TestNgHooks {

	public static String newCRNum;

	public ChangeNewRecordPage getChangeReqNum() {// CHG0031392

		// get attribute value

		newCRNum = getTypedText(locateElement("name", "change_request.number"));
		System.out.println(newCRNum);
		return this;
	}

	public ChangeNewRecordPage assignShortDesc(String shortDescCRVal) {
		click(locateElement("change_request.short_description"));
		clearAndType(locateElement("change_request.short_description"), shortDescCRVal);
		return this;
	}

	public CreateChangeRequest clickOnSubmitButton() {
		click(locateElement("sysverb_insert_bottom"));
		getDriver().switchTo().defaultContent();
		return new CreateChangeRequest();
	}

}
