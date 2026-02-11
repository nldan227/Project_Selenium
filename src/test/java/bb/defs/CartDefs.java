package bb.defs;

import bb.steps.CartSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;


public class CartDefs {

    @Steps
    CartSteps cartSteps;

    @Then("Both products are added to Cart")
    public void verifyItemInCartDisplayCorrectly(){
        cartSteps.verifyItemInCartDisplayCorrectly();
    }

    @And("their prices, quantity and total price is displayd correctly")
    public void verifyCartInfoDisplayCorrectly() {
        cartSteps.verifyCartInfoDisplayCorrectly();
    }

    @Then("Product is displayed in cart page with exact quantity")
    public void verifyQuantityDisplayCorrectly() {
        cartSteps.verifyQuantityInCartDisplayCorrectly();
    }

    @Then("Cart page is displayed")
    public void verifyCartPageIsDisplayed(){
        cartSteps.verifyCartPageIsDisplayed();
    }

    @When("Click Proceed To Checkout button")
    public void clickbtnProceedToCheckout(){
        cartSteps.clickBtnCheckout();
    }

    @And("^Click Register/Login button$")
    public void clickBtnRegisterOrLogin(){
        cartSteps.clickBtnRegisterOrLogin();
    }

    @When ("Click X button corresponding to {string} product")
    public void clickDeleteByProductName(String productName){
        Serenity.setSessionVariable("deletedProduct").to(productName);
        cartSteps.clickDeleteByProductName(productName);
    }

    @Then ("That product is removed from the cart")
    public void verifyProductRemoved(){
        String deletedProduct = Serenity.sessionVariableCalled("productName");
        cartSteps.verifyProductRemoved(deletedProduct);
    }
}
