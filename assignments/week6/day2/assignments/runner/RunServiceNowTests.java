package week6.day2.assignments.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class RunServiceNowTests {
	@CucumberOptions(dryRun = false, features = {
			"src/test/java/week6/day2/assignments/features/CreateIncident.feature",
			"src/test/java/week6/day2/assignments/features/DeleteIncident.feature",
			"src/test/java/week6/day2/assignments/features/CreateProposal.feature",
			"src/test/java/week6/day2/assignments/features/UpdateProposal.feature",
			"src/test/java/week6/day2/assignments/features/CreateNewChange.feature",
			"src/test/java/week6/day2/assignments/features/AssessChangeRequest.feature" }, glue = {
					"week6/day2/assignments/stepsdefinition" }, monochrome = true)

	public class CucucmberRunTests extends AbstractTestNGCucumberTests {

	}

}
