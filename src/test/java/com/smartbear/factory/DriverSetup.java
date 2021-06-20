package com.smartbear.factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.smartbear.enums.*;
import com.smartbear.utilities.PropertiesReader;

public class DriverSetup {

    private static WebDriver driverDS;
    private static final String userDir = System.getProperty("user.dir");

    private DriverSetup() {

    }

    public static WebDriver selectBrowser(String browser) throws IOException {
        if (System.getProperty("os.name").toLowerCase().contains(OS.WINDOW.name().toLowerCase())) {
            if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
                System.setProperty("webdriver.chrome.driver", userDir
                        + PropertiesReader.getValue("chromedriverRelativePath"));
                driverDS = new ChromeDriver();
                maximizeBrowserWindow();
            } else if (browser.equalsIgnoreCase(Browsers.EDGE.name())) {
                System.setProperty("webdriver.edge.driver", userDir
                        + PropertiesReader.getValue("edgedriverRelativePath"));
                driverDS = new EdgeDriver();
                maximizeBrowserWindow();
            } else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
                System.setProperty("webdriver.gecko.driver", userDir
                        + PropertiesReader.getValue("firefoxdriverRelativePath"));
                driverDS = new FirefoxDriver();
                maximizeBrowserWindow();
            }
        } else if (System.getProperty("os.name").toLowerCase().contains(OS.MAC.name().toLowerCase())) {
            if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
                System.setProperty("webdriver.chrome.driver", userDir
                        + PropertiesReader.getValue("chromedriverRelativePath"));
                driverDS = new ChromeDriver();
                maximizeBrowserWindow();
            } else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
                System.setProperty("webdriver.gecko.driver", userDir
                        + PropertiesReader.getValue("firefoxdriverRelativePath"));
                driverDS = new FirefoxDriver();
                maximizeBrowserWindow();
            }
        }

        return driverDS;
    }

    public static void maximizeBrowserWindow() {
        DriverSetup.driverDS.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        DriverSetup.driverDS.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        //this.driverDS.manage().window().setSize(new Dimension(1080, 1920));
        DriverSetup.driverDS.manage().window().maximize();
    }
}
