package bb.steps;

import bb.pages.CommonComponents;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractionSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonComponentsSteps extends UIInteractionSteps {
    @Steps
    CommonComponents commonComponents;

    public void verifyHomePageIsDisplayed(String text){
        assertThat(commonComponents.isHeadingVisible(text)).isTrue();
    }

    public void verifyHeadingIsVisible(String headingText) {
        assertThat(commonComponents.isHeadingVisible(headingText)).isTrue();
    }

    public void verifyMessageIsVisbile(String message) {
        assertThat(commonComponents.isMessageVisible(message)).isTrue();
    }

}
