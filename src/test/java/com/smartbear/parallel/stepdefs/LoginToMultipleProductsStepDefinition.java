package com.smartbear.parallel.stepdefs;

import com.smartbear.hooks.ServiceHooks;
import com.smartbear.pageobject.home.Header;
import com.smartbear.pageobject.login.SelectProducts;
import com.smartbear.utilities.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class LoginToMultipleProductsStepDefinition {

    Header headerPageObj = new Header(ServiceHooks.driver1);
    SelectProducts selectProducts = new SelectProducts(ServiceHooks.driver1);


    @Given("I clicked on Login button")
    public void iClickedOnLoginButton() throws IOException {
        ServiceHooks.driver1.get(PropertiesReader.getValue("appBaseURL"));
        headerPageObj.isLogoDisplayedonHeader();
        headerPageObj.clickOnLogin();
    }

    @When("I choose any {string}")
    public void i_choose_any(String productName) {
        selectProducts.selectProductToLogin(productName);
    }

    @Then("I shall be redirected to that {string} own login page")
    public void i_shall_be_redirected_to_that_own_login_page(String string) throws InterruptedException {
        String smartBearPageHandle = ServiceHooks.driver1.getWindowHandle();
        Set<String> windowHandles = ServiceHooks.driver1.getWindowHandles();
        Iterator<String> iterate = windowHandles.iterator();
        while (iterate.hasNext()) {
            String currentWindowHandle = iterate.next();
            if (currentWindowHandle.equals(smartBearPageHandle)) {
                continue;
            } else {
                ServiceHooks.driver1.switchTo().window(currentWindowHandle);
                break;
            }

        }

        Thread.sleep(10000);
    }


}
