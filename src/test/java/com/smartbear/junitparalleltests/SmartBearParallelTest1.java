package com.smartbear.junitparalleltests;

import com.smartbear.enums.Browsers;
import com.smartbear.factory.WebDriverFactory;
import com.smartbear.pageobject.home.Header;
import com.smartbear.pageobject.login.SelectProducts;
import com.smartbear.utilities.PropertiesReader;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class SmartBearParallelTest1 extends WebDriverFactory {

    Header header;
    SelectProducts selectProducts;
    WebDriver driver;

    @Test
    public void viewAllProducts() throws IOException, InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get(PropertiesReader.getValue("appBaseURL"));
        driver.manage().window().maximize();
        header = new Header(driver);
        header.showProductsDropDownMenu();
        header.viewAllProducts();
    }

    @Test
    public void visitEachSmartBearProductSite() throws IOException {
        driver = WebDriverFactory.getDriver("firefox");
        driver.get(PropertiesReader.getValue("appBaseURL"));
        driver.manage().window().maximize();
        header = new Header(driver);
        selectProducts = new SelectProducts(driver);
        header.clickOnLogin();
        selectProducts.selectProductToLogin("CrossBrowserTesting");
        String currentWindow = driver.getWindowHandle();
        Set<String> setOfWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = setOfWindowHandles.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().equalsIgnoreCase(currentWindow)) {
                continue;
            }
            else {
                driver.switchTo().window(iterator.next());
            }
        }

    }

    @After
    public void quitDriver() {
        driver.quit();
    }

}
