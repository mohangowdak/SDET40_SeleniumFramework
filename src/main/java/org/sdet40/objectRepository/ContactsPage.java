package org.sdet40.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//Declaration
	@FindBy(xpath = "//img[@title='Create Contact...']") private WebElement createContactButton;
	
	//intiallization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//business library
	public void clickCreateContactButton() {
		createContactButton.click();
	}
}
