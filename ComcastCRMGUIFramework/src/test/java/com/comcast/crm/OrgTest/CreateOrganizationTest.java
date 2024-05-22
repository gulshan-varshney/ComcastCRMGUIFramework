package com.comcast.crm.OrgTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.ObjectRepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationsPage;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;

@Listeners(com.comcast.crm.ListnerUtility.ListnerImpClass.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "smoke")
	public void createOrgTest() throws IOException {

		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to create new org page");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "create new org");
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createOrg();
	}

	@Test(groups = "regression")
	public void createOrganizationWithIndustryTest() throws Throwable, IOException {

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createOrgWIthIndustryAndType();
	}

	@Test(groups = "regression")
	public void createOrganizationWithPhoneNumberTest() throws EncryptedDocumentException, IOException {

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createOrganizationWithPhoneNumber();
	}
}
