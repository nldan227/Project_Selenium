package bb.api.steps;

import bb.api.dataobjects.model.Agency;
import bb.api.dataobjects.model.User;
import bb.api.requests.CreateUserRequest;
import bb.api.responses.CreateAgencyResponse;
import bb.api.responses.CreateUserResponse;
import bb.api.services.CreateUserApiService;
import bb.api.services.GetAgencyService;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class GetAgencySteps {

    private final GetAgencyService getAgencyService = new GetAgencyService();
    private Response lastResponse;

    @Step
    public void getAgency(){
        lastResponse = getAgencyService.getAgencyService();
    }

    @Step
    public void verifyDataGetAgency(Agency agency){
        CreateAgencyResponse res = lastResponse.as(CreateAgencyResponse.class);
        String message = res.getMessage();
        System.out.println("Message: " + message);

        assertThat(lastResponse.getStatusCode()).isEqualTo(200);
        assertThat(res.getMessage()).isEqualTo("代理店の詳細情報が正常に取得されました");
        assertThat(res.getData().getName()).isEqualTo(agency.getName());
        assertThat(res.getData().getAgency_code()).isEqualTo(agency.getAgency_code());
    }
}
