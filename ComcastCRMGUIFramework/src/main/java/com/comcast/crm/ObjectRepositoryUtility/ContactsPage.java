package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author gulshan
 * 
 *         Contains Contacts page elements
 *
 */
public class ContactsPage {

	WebDriver driver;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createNewContactBtn;

	public WebElement getCreateNewContactBtn() {
		return createNewContactBtn;
	}

}
