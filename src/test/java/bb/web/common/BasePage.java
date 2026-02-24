package bb.web.common;

import bb.utils.DataUtils;
import bb.utils.LoggerUtil;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage extends PageObject {

    public static final int TIMEOUT_IN_SECONDS = (int) DataUtils.getWaitTimeoutInSecond();
    private static final int CLICK_POLL_MS = 200;
    private static final int DEFAULT_ALERT_TIMEOUT_SEC = 15;
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);


    // ------------------------------------------------------------
    // Open browser
    // ------------------------------------------------------------
    public void openBrowser() {
        super.open();
        String currentUrl = getDriver().getCurrentUrl();
        LOGGER.info("Opened page URL: {}", currentUrl);
        waitForAllLoadingCompleted();
    }

    public void openBrowserWithUrl(String url) {
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("URL must not be blank");
        }
        openUrl(url);
        String currentUrl = getDriver().getCurrentUrl();
        LoggerUtil.logInfo("Opened page URL: " + currentUrl);
        waitForAllLoadingCompleted();
    }

    // ------------------------------------------------------------
    // Wait factories
    // ------------------------------------------------------------

    protected WebDriverWait explicitWait(int timeoutSeconds) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutSeconds));
    }

    protected FluentWait<WebDriver> fluentWait(int timeoutSeconds) {
        return new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(CLICK_POLL_MS))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    // ------------------------------------------------------------
    // Locator helpers
    // ------------------------------------------------------------

    public By by(String locator) {
        String s = locator == null ? "" : locator.trim();
        if (s.isEmpty()) throw new IllegalArgumentException("Locator is blank");
        // XPath commonly starts with "/", "(", ".//"
        if (s.startsWith("/") || s.startsWith("(") || s.startsWith(".//")) return By.xpath(s);
        return By.cssSelector(s);
    }

    public WebElementFacade el(String locator) {
        return $(by(locator));
    }

    public List<WebElementFacade> els(String locator) {
        return findAll(by(locator));
    }

    // ------------------------------------------------------------
    // Basic waits
    // ------------------------------------------------------------

    public WebElementFacade waitVisible(String locator, int timeoutSeconds) {
        WebElementFacade e = el(locator);
        e.withTimeoutOf(Duration.ofSeconds(timeoutSeconds)).waitUntilVisible();
        return e;
    }

    public WebElementFacade waitClickable(String locator, int timeoutSeconds) {
        WebElementFacade e = el(locator);
        e.withTimeoutOf(Duration.ofSeconds(timeoutSeconds)).waitUntilClickable();
        return e;
    }

    public void waitInvisible(String locator, int timeoutSeconds) {
        fluentWait(timeoutSeconds).until(ExpectedConditions.invisibilityOfElementLocated(by(locator)));
    }

    public boolean isPresent(String locator) {
        try {
            return !els(locator).isEmpty();
        } catch (Exception ignore) {
            return false;
        }
    }

    public boolean isVisible(String locator) {
        try {
            return el(locator).isVisible();
        } catch (Exception ignore) {
            return false;
        }
    }

    public boolean isVisible(WebElementFacade element) {
        try {
            return element.isVisible();
        } catch (Exception ignore) {
            return false;
        }
    }

    // ------------------------------------------------------------
    // Scroll / Hover / JS helpers
    // ------------------------------------------------------------

    public void scrollIntoView(WebElementFacade element) {
        evaluateJavascript("arguments[0].scrollIntoView({behavior:'instant', block:'center', inline:'nearest'});", element);
    }

    public void scrollToTop() {
        evaluateJavascript("window.scrollTo(0, 0);");
    }

    public void scrollToBottom() {
        evaluateJavascript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void hover(WebElementFacade element) {
        new Actions(getDriver()).moveToElement(element).perform();
    }

    public void jsClick(WebElementFacade element) {
        evaluateJavascript("arguments[0].click();", element);
    }

    public void highlight(WebElementFacade element) {
        try {
            evaluateJavascript("arguments[0].style.border='2px solid red';", element);
        } catch (Exception ignore) {}
    }

    // ------------------------------------------------------------
    // Robust click
    // ------------------------------------------------------------

    public void click(WebElementFacade element) {
        click(element, TIMEOUT_IN_SECONDS);
    }

    public void click(WebElementFacade element, int timeoutSeconds) {
        long end = System.currentTimeMillis() + timeoutSeconds * 1000L;
        Throwable last = null;

        while (System.currentTimeMillis() < end) {
            try {
                scrollIntoView(element);
                element.waitUntilClickable();
                highlight(element);

                String text = safeText(element);
                LoggerUtil.logInfo("Click element" + (text.isEmpty() ? "" : " [text: " + text + "]"));

                element.click();
                waitForAllLoadingCompleted(timeoutSeconds);
                return;

            } catch (ElementClickInterceptedException e) {
                last = e;
                LoggerUtil.logWarn("Click intercepted -> retrying / JS fallback...");
                // Try JS click once per loop (helps when overlay intercepts but element is correct)
                try {
                    jsClick(element);
                    waitForAllLoadingCompleted(timeoutSeconds);
                    return;
                } catch (Exception jsEx) {
                    last = jsEx;
                }

            } catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
                last = e;
                LoggerUtil.logWarn("Retrying click... (" + e.getClass().getSimpleName() + ")");

            } catch (WebDriverException e) {
                // Generic webdriver exceptions can occur transiently
                last = e;
                LoggerUtil.logWarn("Retrying click... (WebDriverException)");
            }

            waitABit(CLICK_POLL_MS);
        }

        throw new RuntimeException("Cannot click element after timeout (" + timeoutSeconds + "s)", last);
    }

    public void clickOnce(WebElementFacade element, int timeoutSeconds) {
        try {
            scrollIntoView(element);
            element.withTimeoutOf(Duration.ofSeconds(timeoutSeconds)).waitUntilClickable();
            highlight(element);

            String text = safeText(element);
            LoggerUtil.logInfo("Click element" + (text.isEmpty() ? "" : " [text: " + text + "]"));

            element.click();
            waitForAllLoadingCompleted(timeoutSeconds);

        } catch (ElementClickInterceptedException e) {
            LoggerUtil.logError("Click intercepted (no retry)");
            throw new RuntimeException("Click intercepted", e);

        } catch (StaleElementReferenceException |
                 ElementNotInteractableException |
                 TimeoutException e) {
            LoggerUtil.logError("Click failed: " + e.getClass().getSimpleName());
            throw new RuntimeException("Click failed", e);

        } catch (WebDriverException e) {
            LoggerUtil.logError("WebDriverException when clicking");
            throw new RuntimeException("Click failed due to WebDriver error", e);
        }
    }

    public void clickOnce(WebElementFacade element) {
        clickOnce(element, TIMEOUT_IN_SECONDS);
    }

    public void click(String locator) {
        click(waitClickable(locator, TIMEOUT_IN_SECONDS), TIMEOUT_IN_SECONDS);
    }

    private String safeText(WebElementFacade element) {
        try {
            String t = element.getText();
            return t == null ? "" : t.trim();
        } catch (Exception ignore) {
            return "";
        }
    }

    // ------------------------------------------------------------
    // Type / Clear / Get value
    // ------------------------------------------------------------

    public void clearAndType(WebElementFacade element, String value) {
        scrollIntoView(element);
        element.waitUntilVisible();
        element.clear();
        element.sendKeys(value);
    }

    public void type(String locator, String value) {
        WebElementFacade element = waitVisible(locator, TIMEOUT_IN_SECONDS);
        clearAndType(element, value);
        waitForAllLoadingCompleted(TIMEOUT_IN_SECONDS);
    }

    public void pressKeys(CharSequence... keys) {
        new Actions(getDriver()).sendKeys(keys).perform();
    }

    public String getValue(String locator) {
        return waitVisible(locator, TIMEOUT_IN_SECONDS).getAttribute("value");
    }

    // ------------------------------------------------------------
    // Dropdown (native <select>)
    // ------------------------------------------------------------

    public void selectByVisibleText(String selectLocator, String text) {
        WebElement element = waitVisible(selectLocator, TIMEOUT_IN_SECONDS);
        new Select(element).selectByVisibleText(text);
        waitForAllLoadingCompleted(TIMEOUT_IN_SECONDS);
    }

    public void selectByValue(String selectLocator, String value) {
        WebElement element = waitVisible(selectLocator, TIMEOUT_IN_SECONDS);
        new Select(element).selectByValue(value);
        waitForAllLoadingCompleted(TIMEOUT_IN_SECONDS);
    }

    public List<String> texts(String locator) {
        return els(locator).stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    public void waitForAllLoadingCompleted() {
        waitForAllLoadingCompleted(TIMEOUT_IN_SECONDS);
    }

    public void waitForAllLoadingCompleted(int timeoutSeconds) {
        waitForDocumentReady(timeoutSeconds);
        waitForJQueryIdleIfPresent(timeoutSeconds);
    }

    public void waitForDocumentReady(int timeoutSeconds) {
        fluentWait(timeoutSeconds).until(driver -> {
            try {
                Object state = evaluateJavascript("return document.readyState");
                return state != null && "complete".equals(state.toString());
            } catch (Exception e) {
                return true;
            }
        });
    }

    public void waitForJQueryIdleIfPresent(int timeoutSeconds) {
        ExpectedCondition<Boolean> jQueryIdle = driver -> {
            try {
                Object hasJq = evaluateJavascript("return (typeof window.jQuery !== 'undefined')");
                if (hasJq == null || !Boolean.parseBoolean(hasJq.toString())) return true;

                Object active = evaluateJavascript(
                        "return (window.jQuery && typeof jQuery.active !== 'undefined') ? jQuery.active : " +
                                "((typeof $ !== 'undefined' && typeof $.active !== 'undefined') ? $.active : 0);"
                );

                long n = (active instanceof Number) ? ((Number) active).longValue() : Long.parseLong(active.toString());
                return n == 0;
            } catch (Exception e) {
                return true;
            }
        };
        explicitWait(timeoutSeconds).until(jQueryIdle);
    }

    public void waitSpinnerGone(String spinnerLocator, int timeoutSeconds) {
        waitInvisible(spinnerLocator, timeoutSeconds);
    }

    // ------------------------------------------------------------
    // Alert helpers
    // ------------------------------------------------------------

    public void waitForAlertAndAccept() {
        explicitWait(DEFAULT_ALERT_TIMEOUT_SEC).until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
    }

    public void waitForAlertAndDismiss() {
        explicitWait(DEFAULT_ALERT_TIMEOUT_SEC).until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().dismiss();
    }

    public String getAlertText() {
        explicitWait(DEFAULT_ALERT_TIMEOUT_SEC).until(ExpectedConditions.alertIsPresent());
        return getDriver().switchTo().alert().getText();
    }

    // ------------------------------------------------------------
    // Frame helpers
    // ------------------------------------------------------------

    public void switchToFrame(String frameLocator) {
        WebElement frame = waitVisible(frameLocator, TIMEOUT_IN_SECONDS);
        getDriver().switchTo().frame(frame);
    }

    public void switchToFrame(int index) {
        getDriver().switchTo().frame(index);
    }

    public void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }

    // ------------------------------------------------------------
    // Window helpers
    // ------------------------------------------------------------

    public String currentWindow() {
        return getDriver().getWindowHandle();
    }

    public void switchToNewWindow(String previousHandle, int timeoutSeconds) {
        long end = System.currentTimeMillis() + timeoutSeconds * 1000L;
        while (System.currentTimeMillis() < end) {
            Set<String> handles = getDriver().getWindowHandles();
            for (String h : handles) {
                if (!h.equals(previousHandle)) {
                    getDriver().switchTo().window(h);
                    return;
                }
            }
            waitABit(200);
        }
        throw new RuntimeException("No new window found after timeout (" + timeoutSeconds + "s)");
    }

    public void switchToWindowByTitle(String titleContains, int timeoutSeconds) {
        long end = System.currentTimeMillis() + timeoutSeconds * 1000L;
        String original = currentWindow();

        while (System.currentTimeMillis() < end) {
            for (String h : getDriver().getWindowHandles()) {
                getDriver().switchTo().window(h);
                String t = getDriver().getTitle();
                if (t != null && t.contains(titleContains)) return;
            }
            waitABit(200);
        }

        getDriver().switchTo().window(original);
        throw new RuntimeException("Cannot find window with title containing: " + titleContains);
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
        waitForAllLoadingCompleted(TIMEOUT_IN_SECONDS);
    }



}
