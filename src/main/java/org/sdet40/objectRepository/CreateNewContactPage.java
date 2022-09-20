package org.sdet40.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	//declaration
	@FindBy(xpath = "//input[@name='lastname']") private WebElement lastNameTextField;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement saveButton;

	//intiallization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//business Library
	public void createContact(String lastname) {
		lastNameTextField.sendKeys(lastname);
		saveButton.click();
	}
	
}
