package org.sdet40.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	//declaration
	@FindBy(xpath = "//span[@id='dtlview_Last Name']") 
	private WebElement actualLastNameText;

	//intaillization
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//business library
	public String getLastNameText() {
		return actualLastNameText.getText();
	}
}
