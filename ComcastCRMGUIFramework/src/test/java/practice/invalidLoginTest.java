package practice;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.comcast.crm.generic.FileUtility.ExcelUtility;

public class invalidLoginTest {

	@DataProvider(name = "TestData")
	public Object[][] testData() throws EncryptedDocumentException, IOException {
		ExcelUtility elib = new ExcelUtility();
		return elib.getMultipleDataFromExcel("invalid");

	}

	@Test(dataProvider = "TestData")
	public void getProductInfoTest(String username, String password) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.quit();
	}

}