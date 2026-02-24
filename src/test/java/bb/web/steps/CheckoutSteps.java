package bb.web.steps;

import bb.web.pages.CheckOutPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckoutSteps extends UIInteractionSteps {

    CheckOutPage checkOutPage;

    @Step
    public void verifyAddressInfo(){
        assertThat(checkOutPage.isAddressInfoDisplayedCorrectly()).isTrue();
    }

    @Step
    public void fillDescription(String text){
        checkOutPage.fillDescription(text);
    }

    @Step
    public void clickBtnPlaceOrder(){
        checkOutPage.clickBtnPlaceOrder();
    }

    @Step
    public void clickBtnDownloadInvoice() {
        checkOutPage.clickBtnDownloadInvoice();
    }


}
