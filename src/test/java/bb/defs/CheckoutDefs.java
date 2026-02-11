package bb.defs;

import bb.steps.CheckoutSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class CheckoutDefs {

    @Steps
    CheckoutSteps checkoutSteps;

    @Then("Address Details and Review Your Order display correctly")
    public void verifyAddressInfo(){
        checkoutSteps.verifyAddressInfo();
    }

    @When("Enter description {string} in comment text area")
    public void fillDescription(String text){
        checkoutSteps.fillDescription(text);
    }

    @And("Click Place Order button")
    public void clickBtnPlaceOrder(){
        checkoutSteps.clickBtnPlaceOrder();
    }
}
