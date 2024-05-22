
package com.comcast.crm.ObjectRepositoryUtility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;

/**
 * 
 * @author gulshan
 * 
 *         contains CreatingNewContactPage elements & business logics
 *
 */
public class CreatingNewContactPage {

	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	WebDriver driver;

	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrgNameBtn;

	@FindBy(name = "support_start_date")
	private WebElement supportStartDate;

	@FindBy(name = "support_end_date")
	private WebElement supportEndDate;

	@FindBy(name = "search_field")
	private WebElement searchDDInPopup;

	@FindBy(id = "search_txt")
	private WebElement searchTxtInPopup;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBtnInPopup;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getLastnameEdt() {
		return lastNameEdt;
	}

	public WebElement getSelectOrgNameBtn() {
		return selectOrgNameBtn;
	}

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public WebElement getSearchDDInPopup() {
		return searchDDInPopup;
	}

	public WebElement getSearchTxtInPopup() {
		return searchTxtInPopup;
	}

	public WebElement getSearchBtnInPopup() {
		return searchBtnInPopup;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	/**
	 * logic for create contact
	 * 
	 * @throws Throwable
	 * @throws IOException
	 */
	public void createContact() throws Throwable, IOException {
		// read data from excel file
		String lastName = eLib.getDataFromExcelFile("Contact", 1, 2) + jLib.getRandomNumber();
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
		// verify header msg expected result
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actContact = cip.getHeaderMsg().getText();
		boolean status = actContact.contains(lastName);
		Assert.assertEquals(status, true);
		Reporter.log("contact " + lastName + " is created==>PASS", true);
	}

	/**
	 * logic for create Contact With SupportDate
	 * 
	 * @throws Throwable
	 * @throws IOException
	 */
	public void createContactWithSupportDate() throws Throwable, IOException {
		// read data from excel file
		String lastName = eLib.getDataFromExcelFile("Contact", 4, 2) + jLib.getRandomNumber();
		lastNameEdt.sendKeys(lastName);
		String currentDate = jLib.getSystemDate();
		String endDate = jLib.getRequiredDate(30);
		supportStartDate.clear();
		supportStartDate.sendKeys(currentDate);
		supportEndDate.clear();
		supportEndDate.sendKeys(endDate);
		saveBtn.click();

		ContactInfoPage cip = new ContactInfoPage(driver);
		String actContact = cip.getHeaderMsg().getText();
		boolean status = actContact.contains(lastName);
		Assert.assertEquals(status, true);
		Reporter.log("contact " + lastName + " is created==>PASS", true);

		String startDate = cip.getStartDatetxt().getText();
		boolean status1 = startDate.equals(currentDate);
		Assert.assertEquals(status1, true);
		Reporter.log(currentDate + " is verified==>PASS", true);

		String actEndDate = cip.getEndDatetxt().getText();
		Assert.assertEquals(actEndDate.equals(endDate), true);
		Reporter.log(endDate + " is verified==>PASS", true);
	}

	/**
	 * logic for create Contact With OrganizationName
	 * 
	 * @throws Throwable
	 * @throws IOException
	 */
	public void createContactWithOrganizationName() throws Throwable, IOException {

		// read data from excel file
		String orgName = eLib.getDataFromExcelFile("Contact", 7, 3) + jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcelFile("Contact", 7, 2) + jLib.getRandomNumber();
		wLib.waitForPageToLoad(driver);
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.getOrgNameEdt().sendKeys(orgName);
		cop.getSaveBtn().click();
		Thread.sleep(2000);
		hp.getContactsLink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
		lastNameEdt.sendKeys(lastName);
		selectOrgNameBtn.click();
		wLib.switchToTabOnUrl(driver, "module=Accounts&action");
		searchTxtInPopup.sendKeys(orgName);
		searchBtnInPopup.click();
		driver.findElement(By.linkText(orgName)).click();
		wLib.switchToTabOnTitle(driver, "Contacts - vtiger CRM 5");
		saveBtn.click();

		ContactInfoPage cip = new ContactInfoPage(driver);
		String actLastName = cip.getHeaderMsg().getText();
		boolean status = actLastName.contains(lastName);

		Assert.assertEquals(status, true);
		Reporter.log("contact " + lastName + " is created==>PASS", true);

		String OrganizationName = cip.getOrganizationName().getText();
		Assert.assertEquals(OrganizationName.trim().equalsIgnoreCase(orgName), true);
		Reporter.log(orgName + " is verified==>PASS", true);
	}
}
