package week7.day2.assignments.pages;

import cucumber.api.java.en.Given;
import week7.day2.assignments.hooks.TestNgHooks;

public class ServiceLoginPage extends TestNgHooks {

	@Given("Enter the Username as (.*)")
	public ServiceLoginPage typeUName(String data) {
		// switchToFrame(0);
		clearAndType(locateElement("id", "user_name"), data);

		return this;
	}

	@Given("Enter the Password as (.*)")
	public ServiceLoginPage typePwd(String data) {

		clearAndType(locateElement("id", "user_password"), data);

		return this;
	}

	public ServiceHomePage clickLoginButton() {
		click(locateElement("xpath", "//button[text()='Log in']"));
		return new ServiceHomePage();
	}

}
