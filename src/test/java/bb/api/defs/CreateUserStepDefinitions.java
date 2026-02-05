package bb.api.defs;

import bb.api.dataobjects.model.User;
import bb.api.steps.CreateUserApiSteps;
import bb.utils.StringUtils;
import bb.utils.UserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;

public class CreateUserStepDefinitions {

    private final CreateUserApiSteps createUserApiSteps = new CreateUserApiSteps();

    @When("Call API Create User")
    public void createUser() {
        User user = UserUtils.randomValidUser();
        Serenity.setSessionVariable("createdUser").to(user);
        createUserApiSteps.createUser(user);
    }

    @Then("The response data should match the created user")
    public void verifyUserData() {
        User user = Serenity.sessionVariableCalled("createdUser");
        createUserApiSteps.verifyDataCreateUser(user);
    }

}
