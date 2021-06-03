package week7.day2.assignments.pages;

import week7.day2.assignments.hooks.TestNgHooks;

public class ServiceHomePage extends TestNgHooks {

	public ServiceHomePage verifySuccessMessage() {
		/*
		 * String message = driver.findElement(By.className("navbar-header")).getText();
		 * 
		 * if (message.contains("Welcome")) { System.out.println("Login Success"); }
		 */ return this;
	}

	public IncidentSelfService filterNavigatorIncident(String filterNav) throws InterruptedException {

		TypeAndEnter(locateElement("id", "filter"), filterNav);
		// switchToFrame(0);
		return new IncidentSelfService();
	}

	public CreateChangeRequest filterNavigatorChangeReq(String filterNav) throws InterruptedException {

		TypeAndEnter(locateElement("id", "filter"), filterNav);
		// switchToFrame(0);
		return new CreateChangeRequest();
	}

	public ProposalSelfService filterNavigatorProposal(String filterNav) throws InterruptedException {
		TypeAndEnter(locateElement("id", "filter"), filterNav);
		return new ProposalSelfService();
	}

	public UserSelfService filterNavigatorCaller(String filterNav) throws InterruptedException {
		TypeAndEnter(locateElement("id", "filter"), filterNav);
		// driver.findElement(By.xpath("//div[text()='Callers']")).click();
		click(locateElement("xpath", "//div[text()='Callers']"));
		switchToFrame(0);
		return new UserSelfService();

	}

	public TaskSelfService filterNavigatorWork(String filterNav) throws InterruptedException {
		TypeAndEnter(locateElement("id", "filter"), filterNav);
		// switchToFrame(0);
		return new TaskSelfService();
	}

	public TaskSelfService filterNavigatorExistingWork(String filterNav) throws InterruptedException {

		TypeAndEnter(locateElement("id", "filter"), filterNav);
		click(locateElement("xpath", "//div[text()='My Work']"));
		switchToFrame(0);
		return new TaskSelfService();

	}

	public KnowledgeSelfService filterNavigatorArticle(String filterNav) throws InterruptedException {
		TypeAndEnter(locateElement("id", "filter"), filterNav);
		// switchToFrame(0);
		return new KnowledgeSelfService();

	}

	public CatalogServiceNow filterNavigatorServiceCategory(String filterNav) throws InterruptedException {

		TypeAndEnter(locateElement("id", "filter"), filterNav);
		click(locateElement("xpath", "//div[text()='Service Catalog']"));

		// switchToFrame(0);
		return new CatalogServiceNow();
	}

}
