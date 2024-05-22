package practice;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice {

	@Test
	public void practiceTest() throws AWTException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}
}
