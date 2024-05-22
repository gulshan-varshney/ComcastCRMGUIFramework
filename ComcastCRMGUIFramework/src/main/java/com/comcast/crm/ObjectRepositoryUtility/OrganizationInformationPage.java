package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author gulshan
 * 
 *         contains OrganizationInformationPage elements & business logics
 *
 */
public class OrganizationInformationPage {

	WebDriver driver;

	public OrganizationInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;

	@FindBy(id = "dtlview_Industry")
	private WebElement industryTxt;

	@FindBy(id = "dtlview_Type")
	private WebElement typeTxt;

	@FindBy(id = "dtlview_Phone")
	private WebElement phoneTxt;

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getIndustryTxt() {
		return industryTxt;
	}

	public WebElement getTypeTxt() {
		return typeTxt;
	}

	public WebElement getPhoneTxt() {
		return phoneTxt;
	}

}
