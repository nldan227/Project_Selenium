package bb.pages;

import bb.common.BasePage;
import bb.dataobjects.model.ProductInfo;
import bb.utils.StringUtils;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@class='features_items']//div[@class='product-image-wrapper']")
    List<WebElementFacade> products;

    @FindBy(xpath = "//div[@class='product-details']//div[@class='product-information']")
    WebElementFacade productInfo;

    @FindBy(xpath = "//div[@class='product-information']//p[contains(text(),'Category')]/preceding-sibling::h2")
    WebElementFacade productName;

    @FindBy(xpath = "//div[contains(@class,'productinfo')]//p")
    List<WebElementFacade> productNames;

    @FindBy(xpath = "//div[contains(@class,'productinfo')]//h2")
    List<WebElementFacade> productPrices;

    @FindBy(xpath = "//div[@class='product-information']//p[contains(text(),'Category')]")
    WebElementFacade category;

    @FindBy(xpath = "//div[@class='product-information']//span[contains(text(),'Rs')]")
    WebElementFacade price;

    @FindBy(xpath = "//div[@class='product-information']//input[@id='quantity']")
    WebElementFacade inputQuantity;

    @FindBy(xpath = "//div[@class='product-information']//b[text()='Availability:']")
    WebElementFacade availability;

    @FindBy(xpath = "//div[@class='product-information']//b[text()='Condition:']")
    WebElementFacade condition;

    @FindBy(xpath = "//div[@class='product-information']//b[text()='Brand:']")
    WebElementFacade brand;

    @FindBy(xpath = "//div[@class='features_items']//a[contains(@href,'/product_details')]")
    List<WebElementFacade> btnViewProducts;

    @FindBy(xpath = "//section[@id='advertisement']//input[@id='search_product']")
    WebElementFacade inputSearchProduct;

    @FindBy(xpath = "//section[@id='advertisement']//button[@id='submit_search']")
    WebElementFacade btnSearchProduct;

    @FindBy(xpath = "//div[@class='product-overlay']//a[contains(@class,'add-to-cart')]")
    List<WebElementFacade> btnAddToCartOnOverlay;

    @FindBy(xpath = "//div[@class='product-information']//button[contains(@class,'cart')]")
    WebElementFacade btnAddToCartOnDetailProduct;

    @FindBy(xpath = "//div[@class='modal-dialog modal-confirm']//button[contains(@class, 'btn-success')]")
    WebElementFacade btnContinueShopping;

    @FindBy(xpath = "//div[@class='modal-dialog modal-confirm']//a[@href='/view_cart']")
    WebElementFacade btnViewCart;

    @FindBy(xpath = "//form[@id='review-form']//input[@id='name']")
    WebElementFacade inputName;

    @FindBy(xpath = "//form[@id='review-form']//input[@id='email']")
    WebElementFacade inputEmail;

    @FindBy(xpath = "//form[@id='review-form']//textarea[@id='review']")
    WebElementFacade inputReview;

    @FindBy(xpath = "//form[@id='review-form']//button[@id='button-review']")
    WebElementFacade btnSubmit;

    public void clickBtnSubmit() {
        clickOnce(btnSubmit);
    }

    public void inputName(String name) {
        clearAndType(inputName, name);
    }

    public void inputEmail(String email) {
        clearAndType(inputEmail, email);
    }

    public void inputReview(String review) {
        clearAndType(inputReview, review);
    }

    public boolean isListProductVisible() {
        if (products == null || products.isEmpty()) {
            return false;
        }

        for (WebElementFacade product : products) {
            if (!product.isVisible()) {
                return false;
            }
        }
        return true;
    }

    public boolean isProductDetailPageVisible() {
        return productInfo.isVisible();
    }

    public boolean isProductDetailInfoVisible() {
        return productName.isVisible() && category.isVisible() && price.isVisible() && availability.isVisible() && condition.isVisible() && brand.isVisible();
    }

    public void clickBtnViewProductByIndex(int number) {
        clickOnce(btnViewProducts.get(number-1));
    }

    public void searchProduct(String keyword) {
        clearAndType(inputSearchProduct, keyword);
        clickOnce(btnSearchProduct);
    }

    public boolean areAllProductNamesContainKeyword(String keyword) {
        for (WebElementFacade productName : productNames) {
            String nameText = productName.getText().toLowerCase();
            if (!nameText.contains(keyword.toLowerCase())) {
                System.out.println("Not match: " + nameText);
                return false;
            }
        }
        return true;
    }

    public void clickBtnAddCartOverlayByName(String productName){
        clickBtnAddCartOverlayByName(productName, null);
    }
    public void clickBtnAddCartOverlayByName(String productName, String area){

        String scopeXpath;

        if ("recommended".equalsIgnoreCase(area)) {
            scopeXpath = "//div[@id='recommended-item-carousel']";
        } else {
            scopeXpath = "//div[@class='features_items']";
        }

        WebElementFacade product = find(By.xpath(scopeXpath + "//div[@class='productinfo text-center'][.//p[normalize-space()='" + productName + "']]"));

        String name = product.find(By.xpath(".//p")).getText().trim();
        String priceText = product.find(By.xpath(".//h2")).getText();
        BigDecimal price = StringUtils.extractPrice(priceText);

        saveToCartMemory(name, price, 1);

        hover(product);
        WebElementFacade btnAddToCart = product.find(By.xpath(".//a[contains(@class,'add-to-cart')]"));
        clickOnce(btnAddToCart);

    }
    public void clickBtnAddCartOverlayByIndex(int number){

        int index = number - 1;

        String name = productNames.get(index).getText();
        String priceText = productPrices.get(index).getText();
        BigDecimal price = StringUtils.extractPrice(priceText);

        saveToCartMemory(name, price, 1);

        hover(products.get(index));
        clickOnce(btnAddToCartOnOverlay.get(index));
    }

    private void saveToCartMemory(String name, BigDecimal price, int quantity){
        Map<String, ProductInfo> cartMemory = Serenity.sessionVariableCalled("cart");

        if (cartMemory == null) {
            cartMemory = new HashMap<>();
        }

        if (cartMemory.containsKey(name)) {
            cartMemory.get(name).quantity += quantity;
        } else {
            cartMemory.put(name, new ProductInfo(name, price, quantity));
        }

        Serenity.setSessionVariable("cart").to(cartMemory);
    }


    public void clickBtnContinueShopping(){
        clickOnce(btnContinueShopping);
    }

    public void clickBtnViewCart(){
        clickOnce(btnViewCart);
    }

    public void clickBtnAddToCartOnDetailProduct(){
        String name = productName.getText().trim();
        String priceText = price.getText();
        BigDecimal productPrice = new BigDecimal(priceText.replaceAll("[^0-9.]", ""));

        int qty = Integer.parseInt(inputQuantity.getValue().trim());
        saveToCartMemory(name, productPrice, qty);

        clickOn(btnAddToCartOnDetailProduct);
    }

    public void increaseQuantity(int number){
        clearAndType(inputQuantity, String.valueOf(number));
    }





}
