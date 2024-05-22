package com.comcast.crm.ContactTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.ObjectRepositoryUtility.ContactsPage;
import com.comcast.crm.ObjectRepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;

public class CreateContactTest extends BaseClass {

	@Test(groups = "smoke")
	public void createContactTest() throws IOException, Throwable {
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContact();
	}

	@Test(groups = "regression")
	public void createContactWithSupportDate() throws IOException, Throwable {

		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContactWithSupportDate();
	}

	@Test(groups = "regression")
	public void createContactWithOrganizationName() throws IOException, Throwable {

		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContactWithOrganizationName();
	}
}
