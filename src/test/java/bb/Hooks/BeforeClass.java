package bb.Hooks;

import bb.utils.DataUtils;
import bb.web.steps.HomeSteps;
import bb.web.steps.RegisterSteps;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Steps;

public class BeforeClass {

    @Steps
    HomeSteps homeSteps;

    @Steps
    RegisterSteps registerSteps;

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
