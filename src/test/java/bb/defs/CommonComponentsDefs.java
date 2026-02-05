package bb.defs;

import bb.steps.CommonComponentsSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class CommonComponentsDefs {

    @Steps
    CommonComponentsSteps commonComponentsSteps;

    @Then("{string} heading is visible")
    @Then("Login page is visible")
    public void verifyHeadingIsVisible(String headingText) {
        commonComponentsSteps.verifyHeadingIsVisible(headingText);
    }

    @Then("Message {string} is visible")
    public void verifyMessageIsVisbile(String message) {
        commonComponentsSteps.verifyMessageIsVisbile(message);
    }


}
