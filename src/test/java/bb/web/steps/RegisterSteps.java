package bb.web.steps;

import bb.utils.StringUtils;
import bb.web.pages.LoginPage;
import bb.web.pages.RegisterPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class RegisterSteps extends UIInteractionSteps {

    LoginPage loginPage;
    RegisterPage registerPage;

    @Step
    public void clickOnSignupBtn(){
        loginPage.clickOnSignupBtn();
    }

    @Step
    public void register(){
        String email = StringUtils.generateEmailAddress();
        Serenity.setSessionVariable("existEmail").to(email);

        String title = "Mrs";
        String firstName = StringUtils.generateFirstName();
        String lastName = StringUtils.generateLastName();
        String address1 = "2 CT";
        String address2 = "3 CT";
        String company = "AGH";
        String country = "Canada";
        String state = "Ontario";
        String city = "Toronto";
        String zipcode = "M5H2N2";
        String phone = StringUtils.generatePhoneNumber();
        String password = StringUtils.generateRandomNumeric(10);

        Serenity.setSessionVariable("password").to(password);
        Serenity.setSessionVariable("title").to(title);
        Serenity.setSessionVariable("firstname").to(firstName);
        Serenity.setSessionVariable("lastname").to(lastName);
        Serenity.setSessionVariable("company").to(company);
        Serenity.setSessionVariable("address1").to(address1);
        Serenity.setSessionVariable("address2").to(address2);
        Serenity.setSessionVariable("city").to(city);
        Serenity.setSessionVariable("state").to(state);
        Serenity.setSessionVariable("zipcode").to(zipcode);
        Serenity.setSessionVariable("country").to(country);
        Serenity.setSessionVariable("phone").to(phone);

        registerWithNameAndEmail(firstName, email);
        loginPage.clickOnSignupBtn();

        fillAccInfo(title, firstName, password, "1-January-2000");
        fillAddressInfo(firstName, lastName, company, address1, address2, country, state, city, zipcode, phone);

        clickBtnCreateAcc();
    }

    @Step
    public void registerWithNameAndEmail(String name, String email){
        loginPage.inputNameSignup(name);
        loginPage.inputRegisterEmail(email);
    }

    @Step
    public void fillAccInfo(String title, String name, String password, String dob){
        String[] parts = dob.split("-");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

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
