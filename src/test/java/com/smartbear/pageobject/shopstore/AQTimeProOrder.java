package com.smartbear.pageobject.shopstore;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.smartbear.pageobject.PageObject;

public class AQTimeProOrder extends PageObject {

    @FindBy (xpath= "//h1[normalize-space()='AQTime Pro Order']")
    private WebElement aqTimeProOrderHeaderText;

    @FindBy (xpath= "//button[@data-toggle='dropdown']")
    private WebElement licenseDropDown;

    @FindBy (xpath= "//a[contains(@class,'dropdown-item')]//strong")
    private List<WebElement> allLicenses;

    @FindBy (xpath= "//a[contains(@class,'dropdown-item selected active')]//strong")
    private WebElement activeLicenseonDD;

    @FindBy (xpath= "//a[normalize-space()='Add to Cart']")
    private WebElement addToCartBtn;

    public AQTimeProOrder(WebDriver driver) {
        super(driver);
        // Check that we're on the right page.
        //if (!"AQtime Pro Online Store | SmartBear".equals(driver.getTitle())) {
        //    throw new IllegalStateException("This is not the AQtime Pro Online Store page");
        //}
    }

    public boolean isAQTimeProOrderHeaderDisplayed() {
        return aqTimeProOrderHeaderText.isDisplayed();
    }

    public void chooseYourLicense(String licenseName) {
        licenseDropDown.click();
        String licenseType1 = allLicenses.get(0).getText();
        String licenseType2 = allLicenses.get(1).getText();
        if(licenseType1.equalsIgnoreCase(licenseName)) {
            allLicenses.get(0).click();
        }
        else {
            allLicenses.get(1).click();
        }
    }

    public ReviewOrderPage addToCart() {
        addToCartBtn.click();
        return new ReviewOrderPage(driver);
    }
}
