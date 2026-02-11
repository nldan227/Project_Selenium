package bb.defs;

import bb.steps.RegisterSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

public class RegisterDefs {

    @Steps
    RegisterSteps registerSteps;

    @When("Enter name {string} and email {string} in the signup form.")
    public void registerWithNameAndEmail(String name, String email)  {
        registerSteps.registerWithNameAndEmail(name, email);
    }

    @When("Enter name {string} and email existEmail")
    public void enterNameAndExistEmail(String name){
        String email = Serenity.sessionVariableCalled("existEmail");
        registerSteps.registerWithNameAndEmail(name, email);
    }

    @And("Click Signup button")
    public void clickSignupBtn(){
        registerSteps.clickOnSignupBtn();
    }

    @When("Fill account details with title {string}, name {string}, password {string} and date of birth {string}")
    public void fillAccDetail(String title, String name, String password, String dob) {
        registerSteps.fillAccInfo(title, name, password, dob);
    }

    @And("Select checkbox {string}")
    public void selectCheckboxByLabel(String label) {
        registerSteps.selectCheckboxByLabel(label);
    }

    @And("Fill address details with First name {string}, Last name {string}, Company {string}, Address {string}, Address2 {string}, Country {string}, State {string}, City {string}, Zipcode {string}, Mobile Number {string}")
    public void fillAddressDetail(String firstName, String lastName, String company, String address, String address2, String country, String state, String city, String zipcode, String mobile_number){
        registerSteps.fillAddressInfo(firstName, lastName, company, address, address2, country, state, city, zipcode, mobile_number);
    }

    @And("Click Create Account button")
    public void clickBtnCreateAcc(){
        registerSteps.clickBtnCreateAcc();
    }

    @When("Click Continue button")
    public void clickBtnContinue(){
        registerSteps.clickBtnContinue();
    }


    @Then("Fill all details in Signup and create acc")
    public void register(){
        registerSteps.register();
    }

}

