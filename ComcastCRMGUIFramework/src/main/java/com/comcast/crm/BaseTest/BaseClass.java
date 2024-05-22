package com.comcast.crm.BaseTest;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.FileUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;

/**
 * 
 * @author gulshan
 *
 */
public class BaseClass {

	/* create Objects */
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();

	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(alwaysRun = true)
	public void configBS() {
		System.out.println("==DB connected==");
	}

	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC(@Optional("chrome") String BROWSER) throws IOException {
		// String BROWSER = fLib.getDataFromPropertyFile("browser");
		Reporter.log("==" + BROWSER + " Browser launching==", true);

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
		wLib.maximize(driver);
		wLib.waitForPageToLoad(driver);
	}

	@BeforeMethod(alwaysRun = true)
	public void configBM() throws IOException {
		String URL = fLib.getDataFromPropertyFile("url");
		String USERNAME = fLib.getDataFromPropertyFile("username");
		String PASSWORD = fLib.getDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(alwaysRun = true)
	public void comfigAM() {
		HomePage hp = new HomePage(driver);
		hp.logout(wLib);
	}

	@AfterClass(alwaysRun = true)
	public void configAC() {
		Reporter.log("==closing the browser==", true);
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void configAS() {
		Reporter.log("==close DB==", true);

	}

}
