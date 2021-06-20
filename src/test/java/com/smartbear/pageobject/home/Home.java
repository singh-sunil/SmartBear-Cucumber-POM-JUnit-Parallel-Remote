package com.smartbear.pageobject.home;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.smartbear.helper.LoggerHelper;
import com.smartbear.pageobject.PageObject;

public class Home extends PageObject{

    Logger logger = LoggerHelper.getLogger(Home.class);

    @FindBy (how = How.XPATH , using= "//a[normalize-space()='OK']")
    private WebElement acceptCookiesBtn;


    public Home(WebDriver driver)
    {
        super(driver);
    }

    public void consentToUseOfCookies()
    {
        acceptCookiesBtn.click();
    }

    public void doesHomeTitleMatchesExpectedText(String expectedTitle)
    {
        String actualHomePageTitle = driver.getTitle();
        if(actualHomePageTitle.equalsIgnoreCase(expectedTitle))
            logger.info(actualHomePageTitle);
        else
            logger.error(actualHomePageTitle);
    }

}
