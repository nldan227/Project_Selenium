package bb.web.defs;

import bb.web.steps.PaymentSteps;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;

public class PaymentDefs {

    @Steps
    PaymentSteps paymentSteps;

    @And("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void fillPaymentForm(){
        paymentSteps.fillPaymentForm();
    }

    @And("Click Pay and Confirm Order button")
    public void clickBtnPayAndCf(){
        paymentSteps.clickBtnPayAndCf();
    }
}
