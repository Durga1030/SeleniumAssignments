package week6.day1.assignments.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class RunLeadTests {
	@CucumberOptions(dryRun = false, features = { "src/test/java/week6/day1/assignments/features/DuplicateLead.feature",
			"src/test/java/week6/day1/assignments/features/MergeLead.feature",
			"src/test/java/week6/day1/assignments/features/DeleteLead.feature" }, glue = {
					"week6/day1/assignments/stepsdefinition" }, monochrome = true)

	public class CucucmberRunTests extends AbstractTestNGCucumberTests {

	}

}
