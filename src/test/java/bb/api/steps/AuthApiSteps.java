package bb.api.steps;

import bb.api.requests.LoginAiruRequest;
import bb.api.requests.LoginRequest;
import bb.api.responses.LoginAiruResponse;
import bb.api.responses.LoginResponse;
import bb.api.services.AuthApiService;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import bb.api.common.TokenManager;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthApiSteps {

    private final AuthApiService authService = new AuthApiService();
    private Response lastResponse;

    @Step
    public void login(String phone, String password) {
        lastResponse = authService.login(new LoginRequest(phone, password));
    }

    @Step
    public void loginAiru(String username, String password) {
        lastResponse = authService.login(new LoginAiruRequest(username, password));
    }

    @Step
    public void saveToken() {
        LoginResponse res = lastResponse.as(LoginResponse.class);
        String token = res.getData().getToken();
        assertThat(token).isNotBlank();
        assertThat(lastResponse.getStatusCode()).isEqualTo(200);
        assertThat(res.getData().getName()).isEqualTo("tran xuan hung");
        TokenManager.saveAccessToken(token);
    }


    @Step
    public void saveTokenAiru() {
        LoginAiruResponse res = lastResponse.as(LoginAiruResponse.class);

        String access_token = res.getData().getAccess_token();
        String message = res.getMessage();
        System.out.println("Message: " + message);

        assertThat(access_token).isNotBlank();
        assertThat(lastResponse.getStatusCode()).isEqualTo(200);
        assertThat(res.getMessage()).isEqualTo("データが正常に作成されました");

        TokenManager.saveAccessToken(access_token);
        String token = TokenManager.getAccessToken();
        System.out.println("TOKEN = " + token);
    }
}
