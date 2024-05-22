package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;

/**
 * 
 * @author Gulshan
 * 
 *         contains login page elements and logic
 *
 */
public class LoginPage extends WebDriverUtility {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement userNameEdt;

	@FindBy(name = "user_password")
	private WebElement passwordEdt;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	/**
	 * login method
	 * 
	 * @param url
	 * @param username
	 * @param password
	 */
	public void loginToApp(String url, String username, String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
}
