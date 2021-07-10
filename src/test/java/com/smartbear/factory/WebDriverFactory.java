package com.smartbear.factory;

import com.smartbear.enums.Browsers;
import com.smartbear.helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    static Logger log = LoggerHelper.getLogger(WebDriverFactory.class);
    private static DesiredCapabilities capabilities;

    public static WebDriver getDriver(String browserType) throws MalformedURLException {
        WebDriver driver;
        switch (browserType) {
            case "chrome":
                capabilities = DesiredCapabilities.chrome();
                //capabilities.setCapability("binary", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
                //capabilities.setCapability("version", "91.0.4472.124");
                //driver = new RemoteWebDriver(new URL(HUB_URL), capabilities);
                break;
            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                //capabilities.setCapability("binary", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                //capabilities.setCapability("version", "89.0.2");
                //driver = new RemoteWebDriver(new URL(HUB_URL), capabilities);
                break;
            default:
                throw new IllegalStateException();
        }
        capabilities.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        log.info(driver.toString() + " created");
        return driver;
    }
}
