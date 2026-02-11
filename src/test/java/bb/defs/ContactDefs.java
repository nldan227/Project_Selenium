package bb.defs;

import bb.steps.ContactSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class ContactDefs {

    @Steps
    ContactSteps contactSteps;

    @When("Enter name {string}, email {string}, subject {string}, messsage {string} and upload file in the Contact form")
    public void fillContactForm(String name, String email, String subject, String message){
        contactSteps.filLContactForm(name, email, subject, message);
    }

    @And("Click Submit button")
    public void clickBtnSubmit(){
        contactSteps.clickBtnSubmit();
    }

    @When("Click Home button")
    public void clickBtnHome(){
        contactSteps.clickBtnHome();
    }
}
