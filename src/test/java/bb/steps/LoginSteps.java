package bb.steps;

import bb.pages.LoginPage;
import bb.utils.DataUtils;
import bb.utils.LoggerUtil;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.events.AfterScenario;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.StepEventBus;
import org.openqa.selenium.remote.RemoteWebDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

public class LoginSteps extends UIInteractionSteps {


    LoginPage loginPage;

    @Step
    public void inputEmail(String email) {
        loginPage.inputEmail(email);
    }

    @Step
    public void inputPassword(String password) {
        loginPage.inputPassword(password);
    }

    @Step
    public void clickOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Step
    public void loginWithEmailAndPwd(String email, String password) {
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
    }


}
