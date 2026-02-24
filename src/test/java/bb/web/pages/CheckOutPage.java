package bb.web.pages;

import bb.web.common.BasePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CheckOutPage extends BasePage {

    @FindBy(xpath = "//div[@id='ordermsg']/textarea[@name='message']")
    WebElementFacade description;

    @FindBy(xpath = "//a[@href='/payment']")
    WebElementFacade btnPlaceOrder;

    @FindBy(xpath = "//a[contains(@class, 'check_out')]")
    WebElementFacade btnDownloadInvoice;

    public void clickBtnDownloadInvoice(){
        clickOnce(btnDownloadInvoice);
    }

    public boolean isAddressInfoDisplayedCorrectly(){

        String title = Serenity.sessionVariableCalled("title");
        String firstname = Serenity.sessionVariableCalled("firstname");
        String lastname = Serenity.sessionVariableCalled("lastname");
        String company = Serenity.sessionVariableCalled("company");
        String address1 = Serenity.sessionVariableCalled("address1");
        String address2 = Serenity.sessionVariableCalled("address2");
        String city = Serenity.sessionVariableCalled("city");
        String country = Serenity.sessionVariableCalled("country");
        String phone = Serenity.sessionVariableCalled("phone");
        String state = Serenity.sessionVariableCalled("state");
        String zipcode = Serenity.sessionVariableCalled("zipcode");
        String expectedName = title + ". " + firstname + " " + lastname;
        String expectedCityStateZip = city + " " + state + " " + zipcode;

        return isAddressBlockDisplayedCorrectly("address_delivery", expectedName, company, address1, address2, expectedCityStateZip, country, phone)
                && isAddressBlockDisplayedCorrectly("address_invoice",  expectedName, company, address1, address2, expectedCityStateZip, country, phone);
    }

    public boolean isAddressBlockDisplayedCorrectly(String blockId, String expectedName, String expectedCompany, String expectedAddress1, String expectedAddress2, String expectedCityStateZip, String expectedCountry, String expectedPhone){

        String name = find(By.xpath("//ul[@id='"+blockId+"']//li[contains(@class,'address_firstname')]")).getText().trim();
        List<WebElementFacade> addressLines = findAll(By.xpath("//ul[@id='"+blockId+"']//li[contains(@class,'address_address1')]"));
        String company = addressLines.get(0).getText().trim();
        String address1 = addressLines.get(1).getText().trim();
        String address2 = addressLines.get(2).getText().trim();
        String cityStateZip = find(By.xpath("//ul[@id='"+blockId+"']//li[contains(@class,'address_city')]")).getText().trim();
        String country = find(By.xpath("//ul[@id='"+blockId+"']//li[contains(@class,'address_country_name')]")).getText().trim();
        String phone = find(By.xpath("//ul[@id='"+blockId+"']//li[contains(@class,'address_phone')]")).getText().trim();

        System.out.println("-------- VERIFY ADDRESS BLOCK: " + blockId + " --------");
        System.out.println("Name       | UI = [" + name + "] | Expected = [" + expectedName + "]");
        System.out.println("Company    | UI = [" + company + "] | Expected = [" + expectedCompany + "]");
        System.out.println("Address1    | UI = [" + address1 + "] | Expected = [" + expectedAddress1 + "]");
        System.out.println("Address2    | UI = [" + address2 + "] | Expected = [" + expectedAddress2 + "]");
        System.out.println("City/State | UI = [" + cityStateZip + "] | Expected = [" + expectedCityStateZip + "]");
        System.out.println("Country    | UI = [" + country + "] | Expected = [" + expectedCountry + "]");
        System.out.println("Phone      | UI = [" + phone + "] | Expected = [" + expectedPhone + "]");

        if (!name.equals(expectedName)) return false;
        if (!address1.equals(expectedAddress1)) return false;
        if (!address2.equals(expectedAddress2)) return false;
        if (!cityStateZip.equals(expectedCityStateZip)) return false;
        if (!country.equals(expectedCountry)) return false;
        if (!phone.equals(expectedPhone)) return false;

        return true;
    }


    public void fillDescription(String text){
        clearAndType(description, text);
    }

    public void clickBtnPlaceOrder(){
        clickOnce(btnPlaceOrder);
    }



}

