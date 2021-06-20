package com.smartbear.pageobject.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.smartbear.pageobject.home.Header;

public class SelectProducts extends Header{

    @FindBy (how = How.XPATH, using = "//span[@class='tile-prod-title'][normalize-space()='AlertSite']")
    private WebElement alertSite;

    @FindBy (how = How.XPATH, using = "//span[@class='tile-prod-title'][normalize-space()='CrossBrowserTesting']")
    private WebElement crossBrowserTesting;

    @FindBy (how = How.XPATH, using = "//span[@class='tile-prod-title'][normalize-space()='CucumberStudio']")
    private WebElement cucumberStudio;

    @FindBy (how = How.XPATH, using = "//span[@class='tile-prod-title'][normalize-space()='LoadNinja']")
    private WebElement loadNinja;

    @FindBy (how = How.XPATH, using = "//span[@class='tile-prod-title'][normalize-space()='QAComplete']")
    private WebElement qaComplete;

    @FindBy (how = How.XPATH, using = "//span[@class='tile-prod-title'][normalize-space()='SwaggerHub']")
    private WebElement swaggerHub;

    @FindBy (how = How.CLASS_NAME, using = "fal fa-times")
    private WebElement closeBtn;

    public SelectProducts(WebDriver driver) {
        super(driver);
    }

    public void selectProductToLogin(String productName) {
        switch(productName) {
            case "AlertSite" :
                alertSite.click();
                break;
            case "CrossBrowserTesting" :
                crossBrowserTesting.click();
                break;
            case "CucumberStudio" :
                cucumberStudio.click();
                break;
            case "LoadNinja" :
                loadNinja.click();
                break;
            case "QAComplete" :
                qaComplete.click();
                break;
            case "SwaggerHub" :
                swaggerHub.click();
                break;
            default :
                cucumberStudio.click();
                break;

        }
    }

    public void close() {
        closeBtn.click();
    }
}
