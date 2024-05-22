package practice;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;

public class PracticeRobot {

	public static void main(String[]args) throws AWTException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name"));
		
		WebDriverUtility wLib = new WebDriverUtility();
		
		wLib.keyPress(KeyEvent.VK_A);
		wLib.keyPress(KeyEvent.VK_D);
		wLib.keyPress(KeyEvent.VK_M);
		wLib.keyPress(KeyEvent.VK_I);
		wLib.keyPress(KeyEvent.VK_N);
		
		wLib.keyPress(KeyEvent.VK_TAB);
		
		wLib.keyPress(KeyEvent.VK_A);
		wLib.keyPress(KeyEvent.VK_D);
		wLib.keyPress(KeyEvent.VK_M);
		wLib.keyPress(KeyEvent.VK_I);
		wLib.keyPress(KeyEvent.VK_N);
		
		wLib.keyRelease(KeyEvent.VK_A);
		wLib.keyRelease(KeyEvent.VK_D);
		wLib.keyRelease(KeyEvent.VK_M);
		wLib.keyRelease(KeyEvent.VK_I);
		wLib.keyRelease(KeyEvent.VK_N);
	}
}
