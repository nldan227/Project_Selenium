package bb.pages;

import bb.common.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'shop-menu')]//a[@href='/login']")
    WebElementFacade btnSignupOrLogin;

    @FindBy(xpath = "//div[contains(@class, 'shop-menu')]//a[@href='/test_cases']")
    WebElementFacade btnTestCases;

    @FindBy(xpath = "//div[contains(@class, 'shop-menu')]//a[@href='/logout']")
    WebElementFacade btnLogout;

    @FindBy(xpath = "//header//img")
    WebElementFacade imgLogoHomePage;

    @FindBy(xpath = "//a[normalize-space(text())='Logged in as']")
    WebElementFacade loggedInAsLbl;

    @FindBy(xpath = "//a[@href='/delete_account']")
    WebElementFacade btnDeleteAcc;

    public void clickBtnLogout() {
        clickOnce(btnLogout);
    }

    public void clickBtnTCs() {
        clickOnce(btnTestCases);
    }
    public void clickBtnDeleteAcc(){
        clickOnce(btnDeleteAcc);
    }

    public void clickOnSignupOrLogin(){

        clickOnce(btnSignupOrLogin, 5);
    }

    public boolean isLogoDisplayed(){
        return isVisible(imgLogoHomePage);

    }

    public boolean isLoggedInAsLblDisplayed(){
        return isVisible(loggedInAsLbl);
    }

    public String getTextLoggedInAsLbl(){
        return loggedInAsLbl.getText();
    }



}
