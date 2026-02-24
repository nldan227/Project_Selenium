package bb.defs;

import bb.steps.CheckoutSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class CheckoutDefs {

    @Steps
    CheckoutSteps checkoutSteps;

    @Then("Address Details display correctly")
    @Then("Delivery address and billing address is same address filled at the time registration of account")
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

    @When("Click Download Invoice button")
    public void clickBtnDownloadInvoice(){
        checkoutSteps.clickBtnDownloadInvoice();
    }
}
