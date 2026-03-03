package bb.api.defs;

import bb.api.dataobjects.model.Agency;
import bb.api.steps.CreateUserApiSteps;
import bb.api.steps.GetAgencySteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;

public class GetAgencyStepDefinitions {

    private final GetAgencySteps getAgencySteps = new GetAgencySteps();

    @When("Call API Get Agency")
    public void getAgency(){
        getAgencySteps.getAgency();
    }

    @Then("The response data should match the searched agency")
    public void verifyDataGetAgency(){
        Agency agency = Serenity.sessionVariableCalled("createdAgency");
        getAgencySteps.verifyDataGetAgency(agency);
    }
}
