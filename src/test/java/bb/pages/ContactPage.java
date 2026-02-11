package bb.pages;

import bb.common.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class ContactPage extends BasePage {

    @FindBy(xpath = "//div[@id='form-section']//input[@data-qa='name']")
    WebElementFacade inputName;

    @FindBy(xpath = "//div[@id='form-section']//input[@data-qa='email']")
    WebElementFacade inputEmail;

    @FindBy(xpath = "//div[@id='form-section']//input[@data-qa='subject']")
    WebElementFacade inputSubject;

    @FindBy(xpath = "//div[@id='form-section']//textarea[@data-qa='message']")
    WebElementFacade inputMsg;

    @FindBy(xpath = "//div[@id='form-section']//input[@name='upload_file']")
    WebElementFacade inputUpFile;

    @FindBy(xpath = "//div[@id='form-section']//input[@data-qa='submit-button']")
    WebElementFacade btnSubmit;

    @FindBy(xpath = "//div[@class='contact-form']//a[contains(@class,'btn-success')]")
    WebElementFacade btnHome;

    public void inputName(String name) {
        clearAndType(inputName, name);
    }

    public void inputEmail(String email) {
        clearAndType(inputEmail, email);
    }

    public void inputSubject(String subject) {
        clearAndType(inputSubject, subject);
    }

    public void inputMsg(String msg) {
        clearAndType(inputMsg, msg);
    }

    public void inputFile(String filePath) {
        clearAndType(inputUpFile, filePath);
    }

    public void clickBtnSubmit() {
        btnSubmit.waitUntilClickable().click();
    }

    public void clickBtnHome() {
        clickOnce(btnHome);
    }



}
