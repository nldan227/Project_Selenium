package bb.pages;

import bb.common.BasePage;
import bb.utils.StringUtils;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//div[contains(@class, 'shop-menu')]//a[@href='/contact_us']")
    WebElementFacade btnContact;

    @FindBy(xpath = "//div[contains(@class, 'shop-menu')]//a[@href='/products']")
    WebElementFacade btnProducts;

    @FindBy(xpath = "//form[@class='searchform']//input[@id='susbscribe_email']")
    WebElementFacade inputSubscribeEmail;

    @FindBy(xpath = "//form[@class='searchform']//button[@id='subscribe']")
    WebElementFacade btnSubscribe;

    @FindBy(xpath = "//div[contains(@class, 'shop-menu')]//a[@href='/view_cart']")
    WebElementFacade btnCart;

    @FindBy(id = "footer")
    WebElementFacade footer;

    public void clickBtnProduct(){
        clickOnce(btnProducts);
    }

    public void clickBtnContact() {clickOnce(btnContact);}

    public void clickBtnLogout() {
        clickOnce(btnLogout);
    }

    public void clickBtnTCs() {
        clickOnce(btnTestCases);
    }
    public void clickBtnDeleteAcc(){
        clickOnce(btnDeleteAcc);
    }

    public void clickBtnCart() {
        clickOnce(btnCart);
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

    public void submitSubscription(){
        clearAndType(inputSubscribeEmail, StringUtils.generateEmailAddress());
        clickOnce(btnSubscribe);
    }

    public void scrollToFooter(){
        scrollIntoView(footer);
    }


    public void clickCategory(String categoryName){
        clickOn(find(By.xpath("//a[normalize-space()='" + categoryName + "']")));
    }

    public void clickSubCategory(String parentCategory, String subCategory){
        clickOn(find(By.xpath(
                "//div[@id='" + parentCategory + "']//a[normalize-space()='" + subCategory + "']"
        )));
    }

}
