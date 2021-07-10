package com.smartbear.pageobject.home;

import com.smartbear.pageobject.product.ProductsPage;
import com.smartbear.pageobject.shopstore.ShoppingStore;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.smartbear.helper.LoggerHelper;
import com.smartbear.pageobject.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    private WebElement loginLink;

    @FindBy (xpath = "//a[normalize-space()='VIEW ALL PRODUCTS']")
    private WebElement viewAllProductsBtn;


    public Header(WebDriver driver) {
        super(driver);
    }


    public boolean isLogoDisplayedonHeader() {
        return smartBearLogo.isDisplayed();
    }

    public Header showProductsDropDownMenu() {
        productsMenu.click();
        return this;
    }

    public Header showSolutionsDropDownMenu() {
        solutionsMenu.click();
        return this;
    }

    public Header showResourcesDropDownMenu() {
        resourcesMenu.click();
        return this;
    }

    public ShoppingStore visitSmartBearStore() {
        smartBearCart.click();
        return new ShoppingStore(driver);
    }

    public ProductsPage viewAllProducts() throws InterruptedException {
        final WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(viewAllProductsBtn));
        wait.until(ExpectedConditions.elementToBeClickable(viewAllProductsBtn));
        viewAllProductsBtn.click();
        Thread.sleep(2000);
        return new ProductsPage(driver);
    }

    public void clickOnLogin() {
        loginLink.click();
    }

    public Home goBackToHome() {
        smartBearLogo.click();
        return new Home(driver);
    }

}
