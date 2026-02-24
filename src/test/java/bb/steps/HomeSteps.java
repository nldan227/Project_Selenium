package bb.steps;

import bb.pages.HomePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import static org.assertj.core.api.Assertions.*;

public class HomeSteps extends UIInteractionSteps {

    HomePage homePage;

    @Step
    public void openHomePage() {
        homePage.openBrowser();
    }

    @Step
    public void verifyHomePageIsDisplayed() {
        assertThat(homePage.isLogoDisplayed()).isTrue();
    }

    @Step
    public void clickOnSignupOrLogin() {
        homePage.clickOnSignupOrLogin();
    }

    @Step
    public void clickBtnContact() {
        homePage.clickBtnContact();
    }

    @Step
    public void clickOnLogout() {
        homePage.clickBtnLogout();
    }

    @Step
    public void clickBtnTCs() {
        homePage.clickBtnTCs();
    }

    @Step
    public void clickBtnDeleteAcc() {
        homePage.clickBtnDeleteAcc();
    }

    @Step
    public void clickBtnProducts() {
        homePage.clickBtnProduct();
    }

    @Step
    public void clickBtnCart() {
        homePage.clickBtnCart();
    }

    @Step
    public void verifyTextLoggedInAsLbl(String expectedText) {
        assertThat(homePage.getTextLoggedInAsLbl().trim()).isEqualTo(expectedText);
    }

    @Step
    public void verifyLoggedInAsLblDisplayed() {
        assertThat(homePage.isLoggedInAsLblDisplayed()).isTrue();
    }

    @Step
    public void submitSubscription(){
        homePage.submitSubscription();
    }

    @Step
    public void scrollToFooter(){
        homePage.scrollToFooter();
    }

    @Step
    public void scrollToTop(){
        homePage.scrollToTop();
    }

    @Step
    public void clickCategory(String categoryName){
        homePage.clickCategory(categoryName);
    }

    @Step
    public void clickSubCategory(String parentCategory, String subCategory) {
        homePage.clickSubCategory(parentCategory, subCategory);
    }

    @Step
    public void verifyRcmItemsAreVisible() {
        assertThat(homePage.isRecommendedItemsVisible()).isTrue();
    }

    @Step
    public void clickIcScrollUp() {
        homePage.clickIcScrollUp();
    }

}
