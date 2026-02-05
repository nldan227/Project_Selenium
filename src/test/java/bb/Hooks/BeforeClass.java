package bb.Hooks;

import bb.defs.HomeDefs;
import bb.defs.RegisterDefs;
import bb.utils.StringUtils;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import org.apache.poi.ss.formula.eval.EvaluationException;

public class BeforeClass {

    @Steps
    HomeDefs homeDefs;

    @Steps
    RegisterDefs registerDefs;

    @Before(value= "@existEmail", order = 1)
    public void registerEmail(){
       homeDefs.navigateToAutomationExercise();
       homeDefs.clickOnSignupOrLogin();

       String email = StringUtils.generateEmailAddress();
       String password = StringUtils.generateRandomNumeric(10);
       Serenity.setSessionVariable("existEmail").to(email);

       registerDefs.registerWithNameAndEmail(StringUtils.generateFirstName(), email);
       registerDefs.clickSignupBtn();
       registerDefs.fillAccDetail("Mrs", StringUtils.generateFirstName(), StringUtils.generateRandomNumeric(10), "1-January-2000");
       registerDefs.fillAddressDetail(StringUtils.generateFirstName(), StringUtils.generateLastName(), "AGH", "2 CT", "3 CT", "Canada" , "Ontario" , "Toronto" , "M5H2N2" , StringUtils.generatePhoneNumber());
       registerDefs.clickBtnCreateAcc();
       registerDefs.clickBtnContinue();
       homeDefs.clickBtnLogout();
    }

    @Before(value = "@deleteInfo", order = 1)
    public void deleteInfo() {
        System.out.println("Before - delete INFO");
    }

    @Before(value = "@createAccount", order = 1)
    public void deleteProduct() {

        System.out.println("Before - Create ACCOUNT");
    }

    @Before(value = "@deleteCategory", order = 2)
    public void deleteCategory() {
        System.out.println("Before - delete CATEGORY");
    }
}
