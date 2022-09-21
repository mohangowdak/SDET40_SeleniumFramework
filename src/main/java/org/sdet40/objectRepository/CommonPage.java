package org.sdet40.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.WebDriverUtiltiy;

public class CommonPage {
	private WebDriver driver;
	//declaration
	private String dynamicXpath="//a[.='%s']";
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") 
	private WebElement adminstrationIcon;

	//changes done by engg 1

//changes done by engg-2

	//intialization all element variable
	public CommonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//business Library
	/**
	 * 
	 * @param tabName
	 * @param webDriverUtiltiy
	 */
	public void clickRequiredTab(TabNames tabName, WebDriverUtiltiy webDriverUtiltiy) {
		webDriverUtiltiy.convertDynamicXpathIntoWebElement(dynamicXpath, tabName.getTabName(), driver).click();
	}
	
	
	/**
	 * 
	 * @param webDriverUtiltiy
	 * @param driver
	 */
	public void signoutAction(WebDriverUtiltiy webDriverUtiltiy) {
		webDriverUtiltiy.mouseHoverAction( adminstrationIcon);
		webDriverUtiltiy.convertDynamicXpathIntoWebElement(dynamicXpath, TabNames.SIGNOUT.getTabName(), driver).click();
	}
}
