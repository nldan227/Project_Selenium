package bb.web.steps;

import bb.web.pages.CommonComponents;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonComponentsSteps extends UIInteractionSteps {

    CommonComponents commonComponents;

    @Step
    public void verifyHomePageIsDisplayed(String text){
        assertThat(commonComponents.isHeadingVisible(text)).isTrue();
    }

    @Step
    public void verifyHeadingIsVisible(String headingText) {
        assertThat(commonComponents.isHeadingVisible(headingText)).isTrue();
    }

    @Step
    public void verifyMessageIsVisbile(String message) {
        assertThat(commonComponents.isMessageVisible(message)).isTrue();
    }

    @Step
    public void acceptAlert() {
        commonComponents.acceptAlert();
    }

    @Step
    public void verifyFileDownloadSuccessfully(String path, String filePrefix) {
        assertThat(commonComponents.isFileDownloaded(path, filePrefix, 20)).isTrue();
    }
}
