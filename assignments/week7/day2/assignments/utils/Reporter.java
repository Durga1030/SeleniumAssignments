package week7.day2.assignments.utils;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;

import cucumber.api.testng.AbstractTestNGCucumberTests;

public abstract class Reporter extends AbstractTestNGCucumberTests {

	public static ExtentHtmlReporter reporter;
	private static ExtentReports extent;
	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	private static final ThreadLocal<ExtentTest> node = new ThreadLocal<ExtentTest>();
	private static final ThreadLocal<String> testName = new ThreadLocal<String>();

	public String testCaseName, testDescription, nodes, authors, category;
	public String excelFileName;

	@BeforeSuite
	public void startReport() {
		reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeClass
	public void report() throws IOException {
		ExtentTest parent = extent.createTest(testCaseName, testDescription);
		parent.assignCategory(category);
		parent.assignAuthor(authors);
		test.set(parent);
		testName.set(testCaseName);
	}

	public String getTestName() {
		return testName.get();
	}

	public void setNode() {
		ExtentTest child = test.get().createNode(getTestName());
		node.set(child);
	}

	public abstract long takeSnap();

	public void reportStep(String dec, String status, boolean bSnap) {
		MediaEntityModelProvider img = null;
		if (bSnap && !status.equalsIgnoreCase("INFO")) {

			long snapNumber = 100000L;
			snapNumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/" + snapNumber + ".jpg")
						.build();
			} catch (IOException e) {

			}
		}
		if (status.equalsIgnoreCase("pass")) {
			node.get().pass(dec, img);
		} else if (status.equalsIgnoreCase("fail")) {
			node.get().fail(dec, img);
		}
	}

	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
}
