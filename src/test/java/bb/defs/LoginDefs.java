package bb.defs;

//import bb.steps.CommonSteps;
import bb.common.BasePage;
import bb.steps.LoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

public class LoginDefs {

    @Steps
    LoginSteps loginSteps;

    @Given("user open browser")
    public void userOpenEbankApp(){
        Serenity.takeScreenshot();
    }

    @When("Login with email {string} and password {string}")
    public void loginWithEmailAndPwd(String email, String password){
        loginSteps.loginWithEmailAndPwd(email, password);
    }

    @And("Login with created account")
    public void loginWithCreatedAcc(){
        String email = Serenity.sessionVariableCalled("existEmail");
        String password = Serenity.sessionVariableCalled("password");

        loginSteps.loginWithEmailAndPwd(email, password);
    }

}