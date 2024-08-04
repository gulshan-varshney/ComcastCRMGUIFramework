package com.comcast.crm.generic.WebDriverUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author gulshan
 *
 */
public class WebDriverUtility {

	/**
	 * method for maximizing the window
	 * 
	 * @param driver
	 */
	// maximize the window
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * method for implicit wait
	 * 
	 * @param driver
	 */
	// method for implicit wait
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	/**
	 * method for explicit wait
	 * 
	 * @param driver
	 * @param element
	 */
	// method for explicit wait
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * method for explicit wait
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * method for switching tab based on URL
	 * 
	 * @param driver
	 * @param partialUrl
	 */
	// methods for switch the window
	public void switchToTabOnUrl(WebDriver driver, String partialUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);

			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partialUrl)) {
				break;
			}
		}
	}

	/**
	 * method for switching tab based on title
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);

			String actTitle = driver.getTitle();
			if (actTitle.contains(partialTitle)) {
				break;
			}
		}
	}

	/**
	 * method for switching frames on index
	 * 
	 * @param driver
	 * @param index
	 */
	// methods for switching frame
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * method for switching frame by name/id attribute value
	 * 
	 * @param driver
	 * @param nameId
	 */
	public void switchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}

	/**
	 * method for switching frame using webElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	// methods for handle popUps
	public void switchToAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	// methods for select class
	public Select handleDropdown(WebElement element) {
		Select sel = new Select(element);
		return sel;
	}

	public void handleDDUsingVisibleText(WebElement element, String text) {
		handleDropdown(element).selectByVisibleText(text);
	}

	public void handleDDUsingIndex(WebElement element, int index) {
		handleDropdown(element).selectByIndex(index);
	}

	// methods for actions class
	public Actions performAction(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}

	public void mouseMoveOnElement(WebDriver driver, WebElement element) {

		performAction(driver).moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {

		performAction(driver).doubleClick(element).perform();
	}

	public void rightClickOnPage(WebDriver driver) {
		performAction(driver).contextClick().perform();
	}

	public void rightClickOnElement(WebDriver driver, WebElement element) {
		performAction(driver).contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		performAction(driver).dragAndDrop(source, target).perform();
	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		performAction(driver).scrollToElement(element).perform();
	}

	// methods for robot class
	public void keyPress(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyPress(keycode);
	}

	public void keyRelease(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyRelease(keycode);
	}

	// methods for javaScript executor
	public void scrollUp(WebDriver driver, String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script);
	}
}
