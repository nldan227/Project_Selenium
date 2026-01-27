package bb.steps;

import bb.pages.HomePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import static org.assertj.core.api.Assertions.*;

public class HomeSteps extends UIInteractionSteps {

    HomePage homePage;


    @Step
    public void openHomePage(){
        homePage.openBrowser();
    }

    @Step
    public void verifyHomePageIsDisplayed(){
        assertThat(homePage.isLogoDisplayed()).isTrue();
    }

    @Step
    public void clickOnSignInOrLogin(){
        homePage.clickOnSignInOrLogin();
    }
}
