package practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class SampleScreenshotTest {

	@Test
	public void screenshot() throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/amazon.png");
		Files.copy(src, dest);
	}
}
