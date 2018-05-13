package com.microfocus.leanft;

import static org.junit.Assert.*;
import java.io.IOException;
import com.hp.lft.report.*;
import com.hp.lft.sdk.*;
import com.hp.lft.sdk.web.*;
import com.hp.lft.verifications.Verify;
import cucumber.api.*;
import cucumber.api.java.*;
import cucumber.api.java.en.*;

public class LeanFtStepDefinitions {
    Browser browser;

    public LeanFtStepDefinitions() {}

    @Before
    public void setUp() throws GeneralLeanFtException {
        browser = BrowserFactory.launch(BrowserType.CHROME);
        browser.deleteCookies();
    }

    @After
    public void cleanUp() throws GeneralLeanFtException {
        browser.close();
    }

    //Implementation of feature’s steps
    @Given("^I navigate to www.advantageonlineshopping.com$")
    public void i_navigate_to() throws Throwable {
        browser.navigate("http://www.advantageonlineshopping.com");
    }

    @When("^I select the ([^\"]*) category")
    public void i_select_category(String categoryName) throws GeneralLeanFtException {
        String innerText = categoryName.toUpperCase() + " Shop Now ";
        Link category = browser.describe(Link.class, new LinkDescription.Builder()
                .tagName("DIV")
                .innerText(innerText).build());
        category.click();
    }

    @And("^I add the first product to the cart$")
    public void i_add_the_first_product_to_the_cart() throws GeneralLeanFtException{
        WebElement firstItem = browser.describe(Image.class, new ImageDescription.Builder()
                .className("imgProduct")
                .index(0).build());
        firstItem.click();

        Button button = browser.describe(Button.class, new ButtonDescription.Builder()
                .buttonType("submit")
                .tagName("BUTTON")
                .name("ADD TO CART").build());
        button.click();
    }

    @And("^I navigate to the cart$")
    public void i_navigate_to_the_cart() throws GeneralLeanFtException{
        WebElement cart = browser.describe(WebElement.class, new CSSDescription("svg#menuCart > path"));
        cart.click();
    }

    @Then("^the total price is (\\$[0-9,.]+)$")
    public void the_total_price_is(String price) throws GeneralLeanFtException{
        WebElement totalPrice = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .className("roboto-medium ng-binding")
                .innerText(new RegExpProperty("\\$.*")).build());

        Verify.areEqual(price, totalPrice.getInnerText());
    }
}