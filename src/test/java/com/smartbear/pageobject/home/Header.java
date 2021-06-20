package com.smartbear.pageobject.home;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.smartbear.helper.LoggerHelper;
import com.smartbear.pageobject.PageObject;

public class Header extends PageObject{

    Logger logger = LoggerHelper.getLogger(Header.class);

    @FindBy (how = How.CSS , using= "path.logo-icon")
    private WebElement smartBearLogo;

    @FindBy (how = How.XPATH , using= "//a[@role='button'][normalize-space()='Products']")
    private WebElement productsMenu;

    @FindBy (how = How.XPATH , using= "//a[@role='button'][normalize-space()='Solutions']")
    private WebElement solutionsMenu;

    @FindBy (how = How.XPATH , using= "//a[@role='button'][normalize-space()='Resources']")
    private WebElement resourcesMenu;

    @FindBy (id="cart")
    private WebElement smartBearCart;

    @FindBy (how = How.PARTIAL_LINK_TEXT, using = "Login")
    public WebElement loginLink;


    public Header(WebDriver driver) {
        super(driver);
    }


    public boolean isLogoDisplayedonHeader() {
        return smartBearLogo.isDisplayed();
    }

    public void showProductsDropDownMenu() {
        productsMenu.click();
    }

    public void showSolutionsDropDownMenu() {
        solutionsMenu.click();
    }

    public void showResourcesDropDownMenu() {
        resourcesMenu.click();
    }

    public void visitSmartBearStore() {
        smartBearCart.click();
    }

    public void clickOnLogin() {
        loginLink.click();
    }

}
