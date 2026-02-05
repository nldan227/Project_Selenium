package bb.api.steps;

import bb.api.common.TokenManager;
import bb.api.dataobjects.model.User;
import bb.api.requests.CreateUserRequest;
import bb.api.responses.CreateUserResponse;
import bb.api.responses.LoginAiruResponse;
import bb.api.services.AuthApiService;
import bb.api.services.CreateUserApiService;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserApiSteps {

    private final CreateUserApiService createUserApiService = new CreateUserApiService();
    private Response lastResponse;

    @Step
    public void createUser(User user){
        CreateUserRequest request = new CreateUserRequest(
                user.getName(),
                user.getRole(),
                user.getAgencyId(),
                user.getEmail(),
                user.getPassword(),
                user.getPasswordConfirmation()
        );

        lastResponse = createUserApiService.createUser(request);
    }

    @Step
    public void verifyDataCreateUser(User user){
        CreateUserResponse res = lastResponse.as(CreateUserResponse.class);
        String message = res.getMessage();
        System.out.println("Message: " + message);

        assertThat(lastResponse.getStatusCode()).isEqualTo(201);
        assertThat(res.getMessage()).isEqualTo("ユーザーの作成に成功しました");
        assertThat(res.getData().getName()).isEqualTo(user.getName());
        assertThat(res.getData().getEmail()).isEqualTo(user.getEmail());
        assertThat(res.getData().getRole()).isEqualTo(user.getRole());
    }
}
