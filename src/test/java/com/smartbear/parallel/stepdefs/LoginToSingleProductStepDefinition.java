package com.smartbear.parallel.stepdefs;

import com.smartbear.hooks.ServiceHooks;
import com.smartbear.pageobject.home.Header;
import com.smartbear.pageobject.login.SelectProducts;
import com.smartbear.utilities.PropertiesReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class LoginToSingleProductStepDefinition {
    Header headerPageObj = new Header(ServiceHooks.driver2);
    SelectProducts selectProducts = new SelectProducts(ServiceHooks.driver2);

    @Given("I clicked on Login button at header")
    public void i_clicked_on_login_button_at_header() throws IOException {
        ServiceHooks.driver2.get(PropertiesReader.getValue("appBaseURL"));
        headerPageObj.isLogoDisplayedonHeader();
        headerPageObj.clickOnLogin();
    }

    @When("I choose following Product")
    public void i_choose_following_product(DataTable dataTable) {
        String productName = dataTable.asList().get(0).toString();
        selectProducts.selectProductToLogin(productName);
    }

    @Then("I shall be redirected to that Product own login page")
    public void i_shall_be_redirected_to_that_product_own_login_page() throws InterruptedException {
        String smartBearPageHandle = ServiceHooks.driver2.getWindowHandle();
        Set<String> windowHandles = ServiceHooks.driver2.getWindowHandles();
        for (String currentWindowHandle : windowHandles) {
            if (currentWindowHandle.equals(smartBearPageHandle)) {
                continue;
            } else {
                ServiceHooks.driver2.switchTo().window(currentWindowHandle);
                break;
            }

        }

        Thread.sleep(10000);
    }
}
