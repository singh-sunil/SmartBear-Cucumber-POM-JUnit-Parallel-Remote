package com.smartbear.seleniumgridtests;

import com.smartbear.singleton.SingletonWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class SingleBrowserGridTest {

    static SingletonWebDriver singletonWebDriver;
    private static WebDriver driver;

    public static void main(String[] args) throws IOException {

        try {
            singletonWebDriver = SingletonWebDriver.getInstanceOfSingletonWebDriver();
            driver = singletonWebDriver.getDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");
            System.out.println(driver.getTitle());
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement srchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search']")));
            srchBox.sendKeys("Google");
            srchBox.sendKeys(Keys.chord(Keys.TAB,Keys.ENTER));
        } catch (WebDriverException wde) {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
            wde.printStackTrace();
        } catch (NullPointerException npe) {
            throw new NullPointerException("There is no driver instance available!");
        } finally {
            if (singletonWebDriver != null) {
                singletonWebDriver.listOutRDriverCapabilities();
                singletonWebDriver.closeRemoteDriverSession();
                //driver.quit();
                Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
            }
        }


    }
}
