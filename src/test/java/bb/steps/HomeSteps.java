package bb.steps;

import bb.pages.HomePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import static org.assertj.core.api.Assertions.*;

public class HomeSteps extends UIInteractionSteps {

    @Steps
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
    public void verifyTextLoggedInAsLbl(String expectedText) {
        assertThat(homePage.getTextLoggedInAsLbl().trim()).isEqualTo(expectedText);
    }

    @Step
    public void verifyLoggedInAsLblDisplayed() {
        assertThat(homePage.isLoggedInAsLblDisplayed()).isTrue();
    }


}
