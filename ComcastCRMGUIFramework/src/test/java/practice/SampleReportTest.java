package practice;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {

	@Test
	public void createOrgTest() {

		// step-1 spark report config()
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report.html");
		spark.config().setDocumentTitle("CRM Suite extent repots");
		spark.config().setReportName("Crm report");
		spark.config().setTheme(Theme.DARK);

		// step-2 add env. info and create test

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Browser", "chrome");
		ExtentTest test = report.createTest("CreateOrgTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to org page");
		test.log(Status.INFO, "create org");

		if ("hdfc".equals("hdfc")) {
			test.log(Status.PASS, "Org is created");
		} else {
			test.log(Status.FAIL, "Org is not created");
		}
		report.flush();
	}
}
