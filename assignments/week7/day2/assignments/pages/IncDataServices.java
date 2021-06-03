package week7.day2.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import week7.day2.assignments.hooks.TestNgHooks;

public class IncDataServices extends TestNgHooks {

	public IncDataServices assignStateValue() {
		selectDropDownUsingIndex(locateElement("incident.state"), 1);
		return this;
	}

	public IncDataServices assignStateValueResolve() {
		selectDropDownUsingIndex(locateElement("incident.state"), 3);
		return this;
	}

	public IncDataServices assignUrgencyValue() {
		selectDropDownUsingIndex(locateElement("incident.urgency"), 0);
		return this;
	}

	public IncDataServices assignShortDesc() {
		return this;
	}

	public ServiceNowGrpHierarchy clickOnAssignGrpLookup() {
//lookup.incident.assignment_group
		clickWithNoSnap(locateElement("lookup.incident.assignment_group"));
		switchToWindow(1);
		return new ServiceNowGrpHierarchy();
	}

	public ServiceNowGrpHierarchy clickOnAssignedToLookup() {
		clickWithNoSnap(locateElement("lookup.incident.assigned_to"));
		// clickWithNoSnap(locateElement("id", "lookup.incident.assigned_to"));
		switchToWindow(1);
		return new ServiceNowGrpHierarchy();
	}

	public IncDataServices assignResolutionInformation(String notesValue) {
		Actions actions = new Actions(getDriver());
		WebElement navRelatedSearchResults = getDriver().findElement(By.id("cxs_maximize_results"));
		WebElement navResolutionInfo = getDriver().findElement(By.xpath("//span[text()='Resolution Information']"));
		WebElement resolutionNotes = getDriver().findElement(By.id("incident.close_notes"));
		actions.moveToElement(navRelatedSearchResults).moveToElement(navResolutionInfo).click()
				.moveToElement(resolutionNotes).click().perform();
		// resolutionNotes.sendKeys(notesValue);
		clearAndType(resolutionNotes, notesValue);
		selectDropDownUsingIndex(locateElement("incident.close_code"), 7);
		return this;
	}

	public IncidentSelfService clickOnUpdateButton() {
		click(locateElement("sysverb_update"));
		return new IncidentSelfService();
	}

	public IncidentSelfService clickOnResolveButton() {
		click(locateElement("resolve_incident"));
		return new IncidentSelfService();
	}

	public IncidentSelfService clickOnDeleteButton() {
		click(locateElement("sysverb_delete"));
		return new IncidentSelfService();
	}

}
