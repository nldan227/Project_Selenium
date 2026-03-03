package bb.api.defs;

import bb.api.dataobjects.model.Agency;
import bb.api.dataobjects.model.User;
import bb.api.steps.CreateAgencySteps;
import bb.utils.AgencyUtils;
import bb.utils.UserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;

public class CreateAgencyStepDefinitions {


    private final CreateAgencySteps createAgencySteps = new CreateAgencySteps();

    @When("Call API Create Agency")
    public void createAgency() {
        Agency agency = AgencyUtils.randomValidAgency();
        Serenity.setSessionVariable("createdAgency").to(agency);
        createAgencySteps.createAgency(agency);
    }

    @Then("The response data should match the created agency")
    public void verifyAgencyData() {
        Agency agency = Serenity.sessionVariableCalled("createdAgency");
        createAgencySteps.verifyDataCreateAgency(agency);
    }
}
