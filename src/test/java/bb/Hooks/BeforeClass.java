package bb.Hooks;


import bb.steps.HomeSteps;
import bb.steps.RegisterSteps;
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
    }

    @Before(value = "@deleteInfo", order = 1)
    public void deleteInfo() {
        System.out.println("Before - delete INFO");
    }

    @Before(value = "@createAccount", order = 1)
    public void deleteProduct() {

        System.out.println("Before - Create ACCOUNT");
    }

    @Before(value = "@deleteCategory", order = 2)
    public void deleteCategory() {
        System.out.println("Before - delete CATEGORY");
    }
}
