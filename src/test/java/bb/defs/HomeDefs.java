package bb.defs;

import bb.common.BasePage;
import bb.steps.HomeSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

public class HomeDefs extends BasePage {

    @Steps
    HomeSteps homeSteps;

    @Given("Navigate to Automation Exercise")
    public void navigateToAutomationExercise(){
        homeSteps.openHomePage();
        homeSteps.verifyHomePageIsDisplayed();
    }

    @When("Click on SignIn")
    public void clickOnSigIn(){
        homeSteps.clickOnSignInOrLogin();
        Serenity.sessionVariableCalled("data");
    }
}
