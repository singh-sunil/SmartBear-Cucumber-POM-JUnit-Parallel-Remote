package com.smartbear.junitparalleltests;

import com.smartbear.base.DONOTUSE_ParallelSeleniumTestBase;
import com.smartbear.enums.Browsers;
import com.smartbear.factory.WebDriverFactory;
import com.smartbear.pageobject.home.Header;
import com.smartbear.pageobject.login.SelectProducts;
import com.smartbear.utilities.PropertiesReader;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class SmartBearParallelTest2 extends WebDriverFactory {

    Header header;
    SelectProducts selectProducts;
    WebDriver driver;

    @Test
    public void viewResourcesMenu() throws IOException, InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get(PropertiesReader.getValue("appBaseURL"));
        driver.manage().window().maximize();
        header = new Header(driver);
        header.showResourcesDropDownMenu();
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

}
