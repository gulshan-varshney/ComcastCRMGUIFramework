package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author gulshan
 *
 *         contains OrganizationsPage elements
 */
public class OrganizationsPage {

	WebDriver driver;

	public OrganizationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;

	@FindBy(name = "search_text")
	private WebElement searchBox;

	@FindBy(id = "bas_searchfield")
	private WebElement serchDD;

	@FindBy(name = "submit")
	private WebElement searchBtn;

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSerchDD() {
		return serchDD;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

}
