package bb.defs;

import bb.steps.ProductSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

public class ProductDefs {

    @Steps
    ProductSteps productSteps;

    @Then("The products list is visible")
    public void verifyProdcutsListIsVisible(){
        productSteps.verifyProductsIsVisible();
    }

    @Then("User is landed to product detail page")
    public void verifyProductDetailPageIsVisible(){
        productSteps.verifyProductDetailPageIsVisible();
    }

    @And("Detail info is visible: product name, category, price, availability, condition, brand")
    public void verifyProductDetailInfoIsVisible(){
        productSteps.verifyProductDetailInfoIsVisible();
    }

    @When("Click on View Product of product {int}")
    public void clickBtnViewProductByIndex(int number) {
        productSteps.clickBtnViewProductByIndex(number);
    }

    @When("Enter product name {string} in search input and click search button")
    public void searchProduct(String keyword) {
        productSteps.searchProduct(keyword);
        Serenity.setSessionVariable("SEARCH_KEYWORD").to(keyword);
    }

    @Then("All products name contain searched keyword")
    public void verifyProductsRelatedAreVisible() {
        String keyword = Serenity.sessionVariableCalled("SEARCH_KEYWORD");
        productSteps.verifyProductsRelatedAreVisible(keyword);
    }

    @And("Hover over product {int} and click Add to cart")
    public void clickBtnAddToCartOverlayByIndex(int number){
        productSteps.clickBtnAddToCartOverlayByIndex(number);
    }

    @And("Hover over product {string} and click Add to cart")
    public void clickBtnAddToCartOverlayByName(String name){
        productSteps.clickBtnAddToCartOverlayByName(name);
    }

    @And("Click Continue Shopping button")
    public void clickBtnContinueShopping(){
        productSteps.clickBtnContinueShopping();
    }

    @And("Click View Cart button")
    public void clickBtnViewCart(){
        productSteps.clickBtnViewCart();
    }

    @When("Increase quantity to {int}")
    public void increaseQuantity(int number){
        productSteps.increaseQuantity(number);
    }

    @And("Click Add to cart button on detail product page")
    public void clickBtnAddToCartOnDetailProduct(){
        productSteps.clickBtnAddToCartOnDetailProduct();
    }


}


