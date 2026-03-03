package bb.Hooks;

import bb.api.dataobjects.model.Agency;
import bb.api.steps.CreateAgencySteps;
import bb.api.steps.GetAgencySteps;
import bb.utils.AgencyUtils;
import bb.utils.DataUtils;
import bb.web.steps.HomeSteps;
import bb.web.steps.RegisterSteps;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

public class BeforeClass {

    @Steps
    HomeSteps homeSteps;

    @Steps
    RegisterSteps registerSteps;

    @Steps
    CreateAgencySteps createAgencySteps;

    @Before(value= "@CreateAcc", order = 1)
    public void register() {
        homeSteps.openHomePage();
        homeSteps.clickOnSignupOrLogin();
        registerSteps.register();
        registerSteps.clickBtnContinue();
        homeSteps.clickOnLogout();
    }

    @Before(value = "@deleteInvoice", order = 1)
    public void deleteInvoice() {
        DataUtils.deleteFiles("C:/Users/dan.linh.nguyen/Downloads", "invoice");
    }


}
