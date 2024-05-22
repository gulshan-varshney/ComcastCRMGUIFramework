package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	WebDriver driver;

	public ContactInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;

	@FindBy(id = "dtlview_Last Name")
	private WebElement lastNameInfo;

	@FindBy(id = "mouseArea_Organization Name")
	private WebElement organizationName;

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startDatetxt;

	@FindBy(id = "dtlview_Support End Date")
	private WebElement endDatetxt;

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getLastNameInfo() {
		return lastNameInfo;
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getStartDatetxt() {
		return startDatetxt;
	}

	public WebElement getEndDatetxt() {
		return endDatetxt;
	}

}
