package org.vtiger.contacts;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.sdet40.genericUtility.BaseClass;
import org.sdet40.objectRepository.ContactInformationPage;
import org.sdet40.objectRepository.ContactsPage;
import org.sdet40.objectRepository.CreateNewContactPage;
import org.sdet40.objectRepository.TabNames;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateContactsTest extends BaseClass{

	@Test(groups = "sanity")
	public  void createContactsTest() throws IOException, InterruptedException {
		System.out.println("current thread id -----> "+Thread.currentThread().getId());
		
		//Fetch the data from Excel File
		String expectedContactLastName = excelUtility.getDataFromExcel("Contacts", "contactLastName", "CreateContactsTest")+randomNumber;
		System.out.println(expectedContactLastName);
		ContactsPage contactsPage=new ContactsPage(driver);
		CreateNewContactPage createNewContactPage=new CreateNewContactPage(driver);
		ContactInformationPage contactInformationPage=new ContactInformationPage(driver);
		commonPage.clickRequiredTab(TabNames.CONTACTS, webDriverUtiltiy);
		
		contactsPage.clickCreateContactButton();
		createNewContactPage.createContact(expectedContactLastName);
		String actualLastName = contactInformationPage.getLastNameText();
		//String actualLastName ="RMG";
		webDriverUtiltiy.verifyResult(actualLastName, expectedContactLastName);
//	webDriverUtiltiy.verifyResult(actualLastName.equals(expectedContactLastName));
	}
}

