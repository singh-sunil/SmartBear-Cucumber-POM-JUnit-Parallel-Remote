package com.smartbear.base;

import com.smartbear.enums.Browsers;
import com.smartbear.factory.WebDriverFactory;
import com.smartbear.helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.*;

@RunWith(Parallelized.class)
public class DONOTUSE_ParallelSeleniumTestBase {

    static Logger log = LoggerHelper.getLogger(DONOTUSE_ParallelSeleniumTestBase.class);

    @Parameterized.Parameter
    public Browsers currentDriverType;

    // test case naming requires junit 4.11
    @Parameterized.Parameters(name= "{0}")
    public static Collection<Object[]> driverTypes() {
        return Arrays.asList(new Object[][] { //
                { Browsers.CHROME }, //
                { Browsers.FIREFOX }//, //
                //{ Browsers.EDGE }
        });
    }

    protected static ThreadLocal<WebDriver> currentDriver = new ThreadLocal<WebDriver>();
    protected static List<WebDriver> driversToCleanup = Collections.synchronizedList(new ArrayList<WebDriver>());

    @Before
    public void driverInit() throws MalformedURLException {
        if (currentDriver.get()==null) {
            WebDriver driver = WebDriverFactory.getDriver("");
            driversToCleanup.add(driver);
            currentDriver.set(driver);
        }
    }

    protected WebDriver getDriver() {
        return currentDriver.get();
    }

    @AfterClass
    public static void driverCleanup() {
        Iterator<WebDriver> iterator = driversToCleanup.iterator();
        while (iterator.hasNext()) {
            WebDriver driver = iterator.next();
            log(driver, "about to quit");
            driver.quit();
            iterator.remove();
        }
    }

    /**
     * Log: current thread, current {@link WebDriver} and message.
     */
    protected static void log(WebDriver driver, String message) {
        String driverShortName = driver.getClass().getName()+ ".";
        log.info(String.format("%15s, %15s: %s", Thread.currentThread().getName(), driverShortName, message));
    }
}
