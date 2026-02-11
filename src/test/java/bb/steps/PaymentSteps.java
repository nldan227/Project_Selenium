package bb.steps;

import bb.pages.PaymentPage;
import net.serenitybdd.annotations.Step;

public class PaymentSteps {

    PaymentPage paymentPage;

    @Step
    public void fillPaymentForm(){
        paymentPage.fillNameOnCard();
        paymentPage.fillCardNumber();
        paymentPage.fillCVC();
        paymentPage.fillExMonth();
        paymentPage.fillExYear();
    }

    @Step
    public void clickBtnPayAndCf(){
        paymentPage.clickBtnPayAndCf();
    }
}
