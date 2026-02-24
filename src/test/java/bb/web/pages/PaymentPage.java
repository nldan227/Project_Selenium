package bb.web.pages;

import bb.utils.StringUtils;
import bb.web.common.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    @FindBy(xpath = "//form[@id='payment-form']//input[@name='name_on_card']")
    WebElementFacade inputNameOnCard;

    @FindBy(xpath = "//form[@id='payment-form']//input[@name='card_number']")
    WebElementFacade inputCardNumber;

    @FindBy(xpath = "//form[@id='payment-form']//input[@name='cvc']")
    WebElementFacade inputCVC;

    @FindBy(xpath = "//form[@id='payment-form']//input[@name='expiry_month']")
    WebElementFacade inputExMonth;

    @FindBy(xpath = "//form[@id='payment-form']//input[@name='expiry_year']")
    WebElementFacade inputExYear;

    @FindBy(xpath = "//form[@id='payment-form']//button[@id='submit']")
    WebElementFacade btnPayAndCf;

    public void clickBtnPayAndCf(){
        clickOnce(btnPayAndCf);
    }

    public void fillNameOnCard(){
        String name = StringUtils.generateFullName();
        clearAndType(inputNameOnCard, name);
    }

    public void fillCardNumber(){
        String number = StringUtils.generateRandomNumeric(9);
        clearAndType(inputCardNumber, number);
    }


    public void fillCVC(){
        String number = StringUtils.generateRandomNumeric(3);
        clearAndType(inputCVC, number);
    }

    public void fillExMonth(){
        clearAndType(inputExMonth, "02");
    }

    public void fillExYear(){
        clearAndType(inputExYear, "2030");
    }
}
