package bb.web.steps;

import bb.web.pages.CartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CartSteps extends UIInteractionSteps {
    CartPage cartPage;

    @Step
    public void verifyItemInCartDisplayCorrectly(){
        assertThat(cartPage.isCartQuantityMatch()).isTrue();
    }

    @Step
    public void verifyCartInfoDisplayCorrectly(){
        assertThat(cartPage.isCartInfoDisplayCorrectly()).isTrue();
    }

    @Step
    public void verifyQuantityInCartDisplayCorrectly(){
        assertThat(cartPage.isQuantityDisplayCorrectInCart()).isTrue();
    }

    @Step
    public void verifyCartPageIsDisplayed(){
        assertThat(cartPage.isCartPageDisplayed()).isTrue();
    }

    @Step
    public void clickBtnCheckout(){
        cartPage.clickBtnCheckout();
    }

    @Step
    public void clickBtnRegisterOrLogin(){
        cartPage.clickBtnRegisterOrLogin();
    }

    @Step
    public void clickDeleteByProductName(String productName){
        cartPage.clickDeleteByProductName(productName);
    }

    @Step
    public void verifyProductRemoved(String productName){
        assertThat(cartPage.isProductRemovedFromCart(productName)).isTrue();
    }
}
