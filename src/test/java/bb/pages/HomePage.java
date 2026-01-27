package bb.pages;

import bb.common.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'shop-menu')]//a[@href='/login']")
    WebElementFacade btnSignInOrLogin;

    @FindBy(xpath = "//header//img")
    WebElementFacade imgLogoHomePage;

    public void clickOnSignInOrLogin(){
        clickOnce(btnSignInOrLogin);
    }

    public boolean isLogoDisplayed(){
        return isVisible(imgLogoHomePage);

    }



}
