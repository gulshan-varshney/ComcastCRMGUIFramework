package com.comcast.crm.ListnerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;

/**
 * 
 * @author gulshan
 * 
 * @description listener implementation class, contains all abstract methods of
 *              ITestListener & ISuiteListener
 *
 */
public class ListnerImpClass implements ITestListener, ISuiteListener {

	public ExtentReports report;
	public ExtentTest test;

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("Report configuration", true);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports./report_" + time + ".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Browser", "Chrome");

	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("Report backup", true);
		report.flush();

	}

	public void onTestStart(ITestResult result) {
		Reporter.log("=====" + result.getMethod().getMethodName() + "===Start===", true);
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "===STARTED===");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("=====" + result.getMethod().getMethodName() + "===End===", true);
		test.log(Status.PASS, result.getMethod().getMethodName() + "===COMPLETED===");
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(src, testName + "_" + time);
		test.log(Status.FAIL, testName + "==>Failed==<");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
