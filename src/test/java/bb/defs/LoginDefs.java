package bb.defs;

//import bb.steps.CommonSteps;
import bb.steps.LoginSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

public class LoginDefs {
    String a;
    @Steps
    LoginSteps loginSteps;

    @Given("user open browser")
    public void userOpenEbankApp(){
        Serenity.takeScreenshot();
    }

    @When("Login with user {string} and password {string}")
    public void loginWithEmailAndPwd(String email, String password){
        loginSteps.loginWithEmailAndPwd(email, password);
        a = "abc";
    }

    @When("get data")
    public void getData(){
        a
    }
}