package bb.web.steps;

import bb.utils.FileUtils;
import bb.web.pages.ContactPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

import java.io.File;

public class ContactSteps extends UIInteractionSteps {

    ContactPage contactPage;

    @Step
    public void filLContactForm(String name, String email, String subject, String message){
        contactPage.inputName(name);
        contactPage.inputEmail(email);
        contactPage.inputSubject(subject);
        contactPage.inputMsg(message);

        File file = FileUtils.createRandomTextFile();
        contactPage.inputFile(file.getAbsolutePath());

    }

    @Step
    public void clickBtnSubmit(){
        contactPage.clickBtnSubmit();
    }

    @Step
    public void clickBtnHome(){
        contactPage.clickBtnHome();
    }

}
