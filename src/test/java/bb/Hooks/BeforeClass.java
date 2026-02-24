package bb.Hooks;


import bb.steps.HomeSteps;
import bb.steps.RegisterSteps;
import bb.utils.DataUtils;
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
