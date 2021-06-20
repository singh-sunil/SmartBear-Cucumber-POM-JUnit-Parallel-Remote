package com.smartbear.pageobject.shopstore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import com.smartbear.pageobject.PageObject;

public class ShoppingStore extends PageObject {

    @FindBy (xpath= "//h1[normalize-space()='SmartBear Online Store']")
    private WebElement smartBearStoreHeaderText;

    @FindBys({
            @FindBy(how = How.XPATH, using = "//div[normalize-space()='Shop AQTime Pro']"),
            @FindBy(how = How.XPATH, using = "//*[normalize-space()='Shop AQTime Pro']")
    })
    private WebElement shopAQTimeProBtn;

    public ShoppingStore(WebDriver driver) {
        super(driver);
         //Check that we're on the right page.
        String currentPageTitle = driver.getTitle();
        if (!"Online Store | SmartBear".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the Online Store page");
        }
    }

    public boolean isSmartBearStoreHeaderDisplayed() {
        return smartBearStoreHeaderText.isDisplayed();
    }

    public AQTimeProOrder shopForAQTimePro() {
        shopAQTimeProBtn.click();
        return new AQTimeProOrder(driver);
    }

}
