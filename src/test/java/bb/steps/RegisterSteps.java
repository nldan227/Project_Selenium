package bb.steps;

import bb.pages.LoginPage;
import bb.pages.RegisterPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractionSteps;
import static org.assertj.core.api.Assertions.assertThat;

public class RegisterSteps extends UIInteractionSteps {

    @Steps
    LoginPage loginPage;
    RegisterPage registerPage;


    @Step
    public void clickOnSignupBtn(){
        loginPage.clickOnSignupBtn();
    }

    @Step
    public void registerWithNameAndEmail(String name, String email){
        loginPage.inputName(name);
        loginPage.inputRegisterEmail(email);
    }

    @Step
    public void fillAccInfo(String title, String name, String password, String day, String month, String year){
        registerPage.selectTitle(title);
        registerPage.inputName(name);
        registerPage.inputPassword(password);
        registerPage.selectDateofBirth(day, month, year);
    }

    @Step
    public void selectCheckboxByLabel(String label){
        registerPage.selectCheckboxByLabel(label);
    }

    @Step
    public void fillAddressInfo(String firstName, String lastName, String company, String address, String address2, String country, String state, String city, String zipcode, String mobile_number){
        registerPage.inputFirstName(firstName);
        registerPage.inputLastName(lastName);
        registerPage.inputCompany(company);
        registerPage.inputAddress1(address);
        registerPage.inputAddress2(address2);
        registerPage.selectCountry(country);
        registerPage.inputState(state);
        registerPage.inputCity(city);
        registerPage.inputZipCode(zipcode);
        registerPage.inputMobileNumber(mobile_number);
    }

    @Step
    public void clickBtnCreateAcc(){
        registerPage.clickBtnCreateAcc();
    }

    @Step
    public void clickBtnContinue(){
        registerPage.clickBtnContinue();
    }


}
