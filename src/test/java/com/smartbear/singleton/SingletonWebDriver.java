package com.smartbear.singleton;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SingletonWebDriver {

    private static SingletonWebDriver instanceOfSingletonWebDriver = null;
    private RemoteWebDriver remoteWebDriver;
    private WebDriver driver;
    private SessionId sessionID;

    private SingletonWebDriver() throws MalformedURLException {
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //capabilities.setCapability("binary", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        //capabilities.setCapability("version", "91.0.4472.124");

        //System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\eclipse-workspace\\SmartBear-Cucumber-POM-JUnit-Parallel\\src\\test\\resources\\drivers\\geckodriver_win32\\geckodriver.exe");
        //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //capabilities.setBrowserName("firefox");
        //capabilities.setCapability("marionette",true);
        //capabilities.setCapability("firefox_binary", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        //capabilities.setCapability("version", "89.0.2");
        //capabilities.setCapability("platform","windows");
        FirefoxOptions options = new FirefoxOptions();

        driver = new RemoteWebDriver(new URL("http://192.168.1.35:18012/wd/hub"), options);
        remoteWebDriver = (RemoteWebDriver) driver;
        sessionID = remoteWebDriver.getSessionId();
        System.out.println("Current remote web driver session id is :" + sessionID);
    }

    public static SingletonWebDriver getInstanceOfSingletonWebDriver() throws MalformedURLException {
        if (instanceOfSingletonWebDriver == null) {
            instanceOfSingletonWebDriver = new SingletonWebDriver();
        }

        return instanceOfSingletonWebDriver;
    }

    // To get driver
    public WebDriver getDriver() {
        return driver;
    }

    public void listOutRDriverCapabilities() {
        Capabilities capabilities = remoteWebDriver.getCapabilities();
        Map<String, Object> mapOfCapabilities = new HashMap<String, Object>();
        Set<String> setOfCapabilityNames = capabilities.getCapabilityNames();
        System.out.println(setOfCapabilityNames);
        Iterator<String> iterator = setOfCapabilityNames.iterator();
        while (iterator.hasNext()) {
            String capabilityName = iterator.next();
            Object capabilityValue = capabilities.getCapability(capabilityName);
            mapOfCapabilities.put(capabilityName, capabilityValue);
        }

        // forEach(action) method to iterate map
        mapOfCapabilities.forEach((k, v) -> System.out.println("CapabilityName = "
                + k + ", CapabilityValue = " + v));
    }

    public void closeRemoteDriverSession() {
        remoteWebDriver.close();
    }
}
