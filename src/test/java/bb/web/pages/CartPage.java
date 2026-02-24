package bb.web.pages;

import bb.dataobjects.model.ProductInfo;
import bb.utils.StringUtils;
import bb.web.common.BasePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public class CartPage extends BasePage {

    @FindBy(xpath = "//td[@class='cart_description']//h4")
    List<WebElementFacade> cartNames;

    @FindBy(xpath = "//td[@class='cart_price']/p")
    List<WebElementFacade> cartPrices;

    @FindBy(xpath = "//td[@class='cart_quantity']//button")
    List<WebElementFacade> cartQuantities;

    @FindBy(xpath = "//td[@class='cart_total']/p[@class='cart_total_price']")
    List<WebElementFacade> cartTotals;

    @FindBy(xpath = "//section[@id='cart_items']//li[text()='Shopping Cart']")
    WebElementFacade breadcrumbCart;

    @FindBy(xpath = "//section[@id='cart_items']//a[contains(@class,'check_out')]")
    WebElementFacade btnCheckOut;

    @FindBy(xpath = "//div[@class='modal-dialog modal-confirm']//a[@href='/login']")
    WebElementFacade btnRegisterLogin;

    Map<String, ProductInfo> cartMemory = Serenity.sessionVariableCalled("cart");

    public void clickDeleteByProductName(String productName){
        WebElementFacade deleteBtn = find(By.xpath(
                "//a[normalize-space()='" + productName + "']" +
                        "/ancestor::tr//a[contains(@class,'cart_quantity_delete')]"
        ));
        clickOn(deleteBtn);
    }

    public boolean isProductRemovedFromCart(String productName){
        return findAll(By.xpath("//a[normalize-space()='" + productName + "']")).isEmpty();
    }

    public void clickBtnRegisterOrLogin(){
        clickOnce(btnRegisterLogin);
    }

    public boolean isCartPageDisplayed(){
        return breadcrumbCart.isDisplayed();
    }

    public boolean isCartQuantityMatch(){
        if (cartMemory == null) {
            System.out.println("cartMemory is null");
            return false;
        }

        if (cartNames.size() != cartMemory.size()) {
            System.out.println("Size not match");
            return false;
        }

        return true;
    }

    private ProductInfo getUiProductInfo(int i){
        String uiName = cartNames.get(i).getText().trim();

        String priceText = cartPrices.get(i).getText();
        BigDecimal uiPrice = StringUtils.extractPrice(priceText);

        int uiQty = Integer.parseInt(cartQuantities.get(i).getText().trim());

        System.out.println("UI -> " + uiName + " | price=" + uiPrice + " | qty=" + uiQty);

        return new ProductInfo(uiName, uiPrice, uiQty);
    }

    public boolean isQuantityDisplayCorrectInCart(){
        for (int i = 0; i < cartNames.size(); i++) {

            ProductInfo ui = getUiProductInfo(i);
            ProductInfo expected = cartMemory.get(ui.name);

            if (expected == null) return false;

            if (ui.quantity != expected.quantity) {
                System.out.println("Quantity mismatch for " + ui.name + " | expected=" + expected.quantity + " | actual=" + ui.quantity);
                return false;
            }
        }
        return true;
    }

    public boolean isPriceDisplayCorrectInCart(){

        for (int i = 0; i < cartNames.size(); i++) {

            ProductInfo ui = getUiProductInfo(i);
            ProductInfo expected = cartMemory.get(ui.name);

            if (expected == null) return false;

            if (ui.price.compareTo(expected.price) != 0) {
                System.out.println("Price mismatch for " + ui.name);
                return false;
            }
        }
        return true;
    }

    public boolean isTotalDisplayCorrectInCart() {

        for (int i = 0; i < cartNames.size(); i++) {

            ProductInfo ui = getUiProductInfo(i);
            ProductInfo expected = cartMemory.get(ui.name);

            BigDecimal expectedTotal = expected.price.multiply(
                    BigDecimal.valueOf(expected.quantity)
            );


            String totalText = cartTotals.get(i).getText();
            BigDecimal uiTotal = StringUtils.extractPrice(totalText);

            if (uiTotal.compareTo(expectedTotal) != 0) {
                System.out.println("Total mismatch for " + ui.name + " | expected=" + expectedTotal + " | ui=" + uiTotal);
                return false;
            }
        }
        return true;
    }

    public boolean isCartInfoDisplayCorrectly(){
        return isQuantityDisplayCorrectInCart() && isPriceDisplayCorrectInCart() && isTotalDisplayCorrectInCart();
    }

    public void clickBtnCheckout() {
        clickOnce(btnCheckOut);
    }

}
