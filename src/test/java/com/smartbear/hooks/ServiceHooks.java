package com.smartbear.hooks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.smartbear.parallel.ScenarioFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.smartbear.factory.DriverSetup;
import com.smartbear.helper.LoggerHelper;
import com.smartbear.utilities.PropertiesReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ServiceHooks {

    public static WebDriver driver1;
    public static WebDriver driver2;
    public static WebDriver driver3;

    Logger log = LoggerHelper.getLogger(ServiceHooks.class);

    @Before("@chrome")
    public void initializeScenario(Scenario currentScenario) throws IOException {
        String scenarioName = currentScenario.getName();
        String featureName = ScenarioFactory.getFeatureFileNameFromScenarioId(currentScenario);
        driver1 = DriverSetup.selectBrowser(PropertiesReader.getValue("browser").toUpperCase());
        System.out.format("Thread ID ---> %2d Scenario Name ---> %s from ---> %s feature file.\n",
                Thread.currentThread().getId(), currentScenario.getName(),featureName);
    }

    @Before("@edge")
    public void initializeScenarioOnFireFox(Scenario currentScenario) throws IOException {
        String scenarioName = currentScenario.getName();
        String featureName = ScenarioFactory.getFeatureFileNameFromScenarioId(currentScenario);
        driver2 = DriverSetup.selectBrowser(PropertiesReader.getValue("browser2").toUpperCase());
        System.out.format("Thread ID ---> %2d Scenario Name ---> %s from ---> %s feature file.\n",
                Thread.currentThread().getId(), currentScenario.getName(),featureName);
    }

    @Before("@firefox")
    public void initializeScenarioOnEdge(Scenario currentScenario) throws IOException {
        String scenarioName = currentScenario.getName();
        String featureName = ScenarioFactory.getFeatureFileNameFromScenarioId(currentScenario);
        driver3 = DriverSetup.selectBrowser(PropertiesReader.getValue("browser3").toUpperCase());
        System.out.format("Thread ID ---> %2d Scenario Name ---> %s from ---> %s feature file.\n",
                Thread.currentThread().getId(), currentScenario.getName(),featureName);
    }

    @After("@chrome")
    public void tearDownChrome(Scenario scenario) {
        if (scenario.isFailed()) {

            try {
                log.info("Scenario: " + scenario.getName() + " is Failed");
                final byte[] screenshot = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot,  "image/png", scenario.getName());// ... and embed it in
            } catch (WebDriverException e) {
                e.printStackTrace();
            }

        } else {
            try {
                log.info("Scenario: " + scenario.getName() + " has Passed");
                scenario.attach(((TakesScreenshot) driver1).getScreenshotAs(OutputType.BYTES), "image/png",scenario.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver1.quit();
    }

    @After("@edge")
    public void tearDownEdge(Scenario scenario) {
        if (scenario.isFailed()) {

            try {
                log.info("Scenario: " + scenario.getName() + " is Failed");
                final byte[] screenshot = ((TakesScreenshot) driver2).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot,  "image/png", scenario.getName());// ... and embed it in
            } catch (WebDriverException e) {
                e.printStackTrace();
            }

        } else {
            try {
                log.info("Scenario: " + scenario.getName() + " has Passed");
                scenario.attach(((TakesScreenshot) driver2).getScreenshotAs(OutputType.BYTES), "image/png",scenario.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver2.quit();
    }

    @After("@firefox")
    public void tearDownFirefox(Scenario scenario) {
        if (scenario.isFailed()) {

            try {
                log.info("Scenario: " + scenario.getName() + " is Failed");
                final byte[] screenshot = ((TakesScreenshot) driver3).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot,  "image/png", scenario.getName());// ... and embed it in
            } catch (WebDriverException e) {
                e.printStackTrace();
            }

        } else {
            try {
                log.info("Scenario: " + scenario.getName() + " has Passed");
                scenario.attach(((TakesScreenshot) driver3).getScreenshotAs(OutputType.BYTES), "image/png",scenario.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver3.quit();
    }
}
