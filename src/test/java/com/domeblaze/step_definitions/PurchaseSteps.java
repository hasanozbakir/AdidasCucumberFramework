package com.domeblaze.step_definitions;

import com.domeblaze.pages.PlaceOrderPage;
import com.domeblaze.pages.ProductPage;
import com.domeblaze.utilities.ConfigurationReader;
import com.domeblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PurchaseSteps {

    ProductPage productPage=new ProductPage();
    PlaceOrderPage placeOrder= new PlaceOrderPage();
    int expectedPurchaseAmount;

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        Driver.get().get(ConfigurationReader.get("demoblaze.url"));

    }
    @When("User adds {string} from {string}")
    public void user_adds_from(String product, String category) {
        productPage.navigateTo(product, category);
        productPage.addToCart();
        productPage.hpme.click();

    }

    @When("User navigates to cart and removes {string}")
    public void user_navigates_to_cart_and_removes(String product) {
        productPage.cart.click();
        productPage.deleteProduct(product);
    }

    @When("User clicks on place order")
    public void user_clicks_on_place_order() {
        productPage.cart.click();
        expectedPurchaseAmount = Integer.parseInt(productPage.totalPrice.getText());

        productPage.placeOrder.click();

    }
    @When("User fills the form for order and clicks on purchase button")
    public void user_fills_the_form_for_order_and_clicks_on_purchase_button() {
        placeOrder.fillForm();
    }
    @Then("Order ID and order amount should be as expected")
    public void order_ıd_and_order_amount_should_be_as_expected() {
        String orderDetailsText = placeOrder.orderDetails.getText();

        String orderId = orderDetailsText.split("\n")[0];
        System.out.println("orderId = " + orderId);

        int actualPurchaseAmount = Integer.parseInt(orderDetailsText.split("\n")[1].split(" ")[1]);
        System.out.println("actualPurchaseAmount = " + actualPurchaseAmount);

        Assert.assertEquals("Price is NOT as expected",expectedPurchaseAmount,actualPurchaseAmount);

        // in TestNG (actual,expected,message
    }

}
