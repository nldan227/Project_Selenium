package bb.pages;

import bb.common.BasePage;
import bb.utils.DataUtils;
import bb.utils.LoggerUtil;
import org.openqa.selenium.By;

public class CommonComponents extends BasePage {

    public boolean isHeadingVisible(String text){
        String xpath = "//*[self::h1 or self::h2 or self::h3 or self::h4]" + "[normalize-space(.)='" + text + "']";
        return isVisible(waitVisible(xpath, 10));
    }

    public boolean isMessageVisible(String text){
        String xpath = "//*[self::p or self::span or self::div]" + "[normalize-space(.)='" + text + "']";
        return isVisible(xpath);
    }

}
