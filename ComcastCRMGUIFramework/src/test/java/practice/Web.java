package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;

public class Web {

	public static void main(String[] args) throws InterruptedException {
		WebDriverUtility wlib = new WebDriverUtility();
		WebDriver driver = new ChromeDriver();
		wlib.waitForPageToLoad(driver);
		driver.get("https://demoapps.qspiders.com/ui/dropdown?sublist=0");
		WebElement dd = driver.findElement(By.id("select3"));
		wlib.handleDDUsingVisibleText(dd, "Poland");
		Thread.sleep(5000);
		wlib.handleDDUsingIndex(dd, 1);
		
		wlib.mouseMoveOnElement(driver, driver.findElement(By.xpath("//input[@type='radio'][1]")));
	}
}
