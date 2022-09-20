package org.sdet40.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration
	@FindBy(xpath = "//input[@name='user_name']") 
	private WebElement userNameTextField;
	@FindBy(xpath = "//input[@name='user_password']") 
	private WebElement passwordTextField;
	@FindBy(xpath = "//input[@id='submitButton']") 
	private WebElement loginButton;
	//intialization all element variable
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	//bussiness Library
	public void loginAction(String userName, String password) {
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
	
	
}
