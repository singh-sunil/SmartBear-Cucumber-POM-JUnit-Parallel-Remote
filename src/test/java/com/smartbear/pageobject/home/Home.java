package com.smartbear.pageobject.home;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.smartbear.helper.LoggerHelper;
import com.smartbear.pageobject.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home extends PageObject{

    Logger logger = LoggerHelper.getLogger(Home.class);

    @FindBy (how = How.XPATH , using= "//a[normalize-space()='OK']")
    private WebElement acceptCookiesBtn;

    @FindBy (xpath = "//a[normalize-space()='CONTACT US']")
    private WebElement contactUsBtn;

    public Home(WebDriver driver)
    {
        super(driver);
    }

    public Home consentToUseOfCookies() {
        acceptCookiesBtn.click();
        return this;
    }

    public Home contactUS() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(contactUsBtn));
        wait.until(ExpectedConditions.elementToBeClickable(contactUsBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactUsBtn);
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", contactUsBtn);
        return this;
    }

}
