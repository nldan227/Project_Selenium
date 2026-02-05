package bb.pages;
import bb.common.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//div[@class='login-form']//input[@type='email']")
    WebElementFacade inputLoginEmail;

    @FindBy(xpath = "//div[@class='login-form']//input[@type='password']")
    WebElementFacade inputPassword;

    @FindBy(xpath = "//div[@class='login-form']//button[@type='submit']")
    WebElementFacade btnLogin;

    @FindBy(xpath = "//div[@class='signup-form']//input[@type='text']")
    WebElementFacade inputName;

    @FindBy(xpath = "//div[@class='signup-form']//input[@type='email']")
    WebElementFacade inputRegisterEmail;

    @FindBy(xpath = "//div[@class='signup-form']//button[@type='submit']")
    WebElementFacade btnSignup;

    public void inputLoginEmail(String email){
        clearAndType(inputLoginEmail, email);
    }

    public void inputPassword(String password){
        clearAndType(inputPassword, password);
    }

    public void clickOnLoginButton(){
        clickOnce(btnLogin);
    }

    public void inputName(String name){
        clearAndType(inputName, name);
    }

    public void inputRegisterEmail(String email){
        clearAndType(inputRegisterEmail, email);
    }

    public void clickOnSignupBtn(){
        clickOnce(btnSignup);
    }
}

