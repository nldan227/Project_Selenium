package bb.pages;
import bb.common.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//div[@class='login-form']//input[@type='email']")
    WebElementFacade inputEmail;

    @FindBy(xpath = "//div[@class='login-form']//input[@type='password']")
    WebElementFacade inputPassword;

    @FindBy(xpath = "//div[@class='login-form']//button[@type='submit']")
    WebElementFacade btnLogin;

    public void inputEmail(String email){
        clearAndType(inputEmail, email);
    }

    public void inputPassword(String password){
        clearAndType(inputPassword, password);
    }

    public void clickOnLoginButton(){
        clickOnce(btnLogin);
    }


}

