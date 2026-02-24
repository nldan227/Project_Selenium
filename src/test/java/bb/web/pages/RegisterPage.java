package bb.web.pages;

import bb.web.common.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//div[@class='login-form']//button")
    WebElementFacade btnCreateAcc;

    @FindBy(xpath = "//div[@class='pull-right']/a")
    WebElementFacade btnContinue;

    private WebElementFacade fieldById(String id) {
        return $("#" + id);
    }

    public void selectTitle(String title){
        if(title.equalsIgnoreCase("Mr")){
            fieldById("id_gender1").click();
        } else {
            fieldById("id_gender2").click();
        }
    }

    public void inputName(String name){
        clearAndType(fieldById("name"), name);
    }

    public void inputEmail(String email){
        clearAndType(fieldById("email"), email);
    }

    public void inputPassword(String password){
        clearAndType(fieldById("password"), password);
    }

    public void selectDateofBirth(String day, String month, String year){
        selectByVisibleText("#days", day);
        selectByVisibleText("#months", month);
        selectByVisibleText("#years", year);
    }

    public void selectCheckboxByLabel(String labelText) {
        WebElementFacade checkbox = $("//label[normalize-space()='" + labelText + "']/preceding-sibling::div//input[@type='checkbox']");
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void inputFirstName(String firstName){
        clearAndType(fieldById("first_name"), firstName);
    }

    public void inputLastName(String lastName){
        clearAndType(fieldById("last_name"), lastName);
    }

    public void inputCompany(String company){
        clearAndType(fieldById("company"), company);
    }

    public void inputAddress1(String address){
        clearAndType(fieldById("address1"), address);
    }

    public void inputAddress2(String address){
        clearAndType(fieldById("address2"), address);
    }

    public void selectCountry(String country){
        fieldById("country").selectByVisibleText(country);
    }

    public void inputState(String state){
        clearAndType(fieldById("state"), state);
    }

    public void inputCity(String city){
        clearAndType(fieldById("city"), city);
    }

    public void inputZipCode(String zipCode){
        clearAndType(fieldById("zipcode"), zipCode);
    }

    public void inputMobileNumber(String phone){
        clearAndType(fieldById("mobile_number"), phone);
    }

    public void clickBtnCreateAcc(){
        btnCreateAcc.click();
    }

    public void clickBtnContinue(){
        btnContinue.click();
    }
}
