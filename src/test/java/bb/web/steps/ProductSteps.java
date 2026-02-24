package bb.web.steps;

import bb.web.pages.ProductPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;


import static org.assertj.core.api.Assertions.assertThat;

public class ProductSteps extends UIInteractionSteps {

    ProductPage productPage;

    @Step
    public void verifyProductsIsVisible(){
        assertThat(productPage.isListProductVisible()).isTrue();
    }

    @Step
    public void verifyProductDetailPageIsVisible(){
        assertThat(productPage.isProductDetailPageVisible()).isTrue();
    }

    @Step
    public void verifyProductDetailInfoIsVisible(){
        assertThat(productPage.isProductDetailInfoVisible()).isTrue();
    }

    @Step
    public void clickBtnViewProductByIndex(int number) {
        productPage.clickBtnViewProductByIndex(number);
    }

    @Step
    public void searchProduct(String keyword){
        productPage.searchProduct(keyword);
    }

    @Step
    public void verifyProductsRelatedAreVisible(String keyword) {
        productPage.areAllProductNamesContainKeyword(keyword);
    }

    @Step
    public void clickBtnAddToCartOverlayByIndex(int number){
        productPage.clickBtnAddCartOverlayByIndex(number);
    }

    @Step
    public void clickBtnAddToCartOverlayByName(String name){
        productPage.clickBtnAddCartOverlayByName(name);
    }

    @Step
    public void clickBtnAddToCartRcmProductByName(String name){
        productPage.clickBtnAddCartOverlayByName(name, "recommended");
    }

    @Step
    public void clickBtnContinueShopping(){
        productPage.clickBtnContinueShopping();
    }

    @Step
    public void clickBtnViewCart(){
        productPage.clickBtnViewCart();
    }

    @Step
    public void increaseQuantity(int number){
        productPage.increaseQuantity(number);
    }


    @Step
    public void clickBtnAddToCartOnDetailProduct(){
        productPage.clickBtnAddToCartOnDetailProduct();
    }

    @Step
    public void fillReviewForm(String name, String email, String review) {
        productPage.inputName(name);
        productPage.inputEmail(email);
        productPage.inputReview(review);
    }

    @Step
    public void clickBtnSubmit() {
        productPage.clickBtnSubmit();
    }

}
