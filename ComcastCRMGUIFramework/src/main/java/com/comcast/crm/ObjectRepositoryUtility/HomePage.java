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
 *         contains HomePage elements & business logic
 */
public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	/**
	 * method for logOut
	 * 
	 * @param wLib
	 */
	public void logout(WebDriverUtility wLib) {
		wLib.mouseMoveOnElement(driver, adminImg);
		signoutLink.click();

	}
}
