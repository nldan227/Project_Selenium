package bb.web.steps;

import bb.web.pages.LoginPage;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.annotations.Step;

public class LoginSteps extends UIInteractionSteps {

    LoginPage loginPage;

    @Step
    public void inputEmail(String email) {
        loginPage.inputLoginEmail(email);
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
        loginPage.inputLoginEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
    }


}
