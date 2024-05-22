package com.comcast.crm.ObjectRepositoryUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;

/**
 * 
 * @author gulshan
 * 
 *         contains CreatingNewOrganizationPage elements & business logics
 *
 */
public class CreatingNewOrganizationPage {

	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();

	public WebDriver driver;

	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;

	@FindBy(name = "industry")
	private WebElement industryDD;

	@FindBy(name = "accounttype")
	private WebElement accTypeDD;

	@FindBy(id = "phone")
	private WebElement phoneEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getAccTypeDD() {
		return accTypeDD;
	}

	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createOrg() throws EncryptedDocumentException, IOException {

		// read data from excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = eLib.getDataFromExcelFile("org", 1, 2) + jLib.getRandomNumber();
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
		// verify header msg expected result
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status = actOrgName.contains(orgName);
		Assert.assertEquals(status, true);
		Reporter.log("OrgName " + orgName + " is created==>PASS", true);
		UtilityClassObject.getTest().log(Status.PASS, orgName + " created");

//		// go back to organization page
//		hp.getOrgLink().click();
//
//		// search for organization
//		op.getSearchBox().sendKeys(orgName);
//		wLib.select(op.getSerchDD(), "Organization Name");
//		op.getSearchBtn().click();
//		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
//		
//		wLib.switchToAlertAccept(driver);
//		System.out.println(orgName+" is deleted");
	}

	public void createOrganizationWithPhoneNumber() throws EncryptedDocumentException, IOException {

		// read data from excel file
		String orgName = eLib.getDataFromExcelFile("org", 7, 2) + jLib.getRandomNumber();
		String phoneNum = eLib.getDataFromExcelFile("org", 7, 4);

		orgNameEdt.sendKeys(orgName);
		phoneEdt.sendKeys(phoneNum);
		saveBtn.click();
		// verify header msg expected result
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status = actOrgName.contains(orgName);
		Assert.assertEquals(status, true);
		Reporter.log("OrgName " + orgName + " is created==>PASS", true);

		// verify phone number
		String actPhoneNum = oip.getPhoneTxt().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actPhoneNum, phoneNum);
		Reporter.log("phoneNum " + phoneNum + " is verified==>PASS", true);
	}

	public void createOrgWIthIndustryAndType() throws Throwable, IOException {
		// read data from excel file
		String orgName = eLib.getDataFromExcelFile("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcelFile("org", 4, 3);
		String type = eLib.getDataFromExcelFile("org", 4, 4);
		orgNameEdt.sendKeys(orgName);
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.handleDDUsingVisibleText(industryDD, industry);
		wLib.handleDDUsingVisibleText(accTypeDD, type);
		saveBtn.click();

		// verify the industry and type
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean status = actOrgName.contains(orgName);
		Assert.assertEquals(status, true);
		Reporter.log("OrgName " + orgName + " is created==>PASS", true);

		String actType = oip.getTypeTxt().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actType, type);
		Reporter.log("type " + type + " is verified==>PASS", true);

	}
}
