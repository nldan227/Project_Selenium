package bb.api.defs;

import bb.api.steps.AuthApiSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthStepDefinitions {

    private final AuthApiSteps authSteps = new AuthApiSteps();

    @When("Call api Login with phone {string} and password {string}")
    public void login(String phone, String password) {
        authSteps.login(phone, password);
    }

    @Then("Save access token")
    public void storeToken() {
        authSteps.saveToken();
    }

    @Then("Save Airu access token")
    public void storeAiruToken() {
        authSteps.saveTokenAiru();
    }

    @When("Call api Login with username {string} and password {string}")
    public void loginAiru(String username, String password) {
        authSteps.loginAiru(username, password);
    }
}
