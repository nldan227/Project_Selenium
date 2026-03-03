package bb.api.steps;

import bb.api.dataobjects.model.Agency;
import bb.api.requests.CreateAgencyRequest;
import bb.api.responses.CreateAgencyResponse;
import bb.api.services.CreateAgencyService;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAgencySteps {

    private final CreateAgencyService createAgencyService = new CreateAgencyService();
    private Response lastResponse;

    @Step
    public void createAgency(Agency agency){
        CreateAgencyRequest createAgencyRequest = new CreateAgencyRequest(agency.getName(), agency.getAgency_code());
        lastResponse = createAgencyService.createAgency(createAgencyRequest);
        CreateAgencyResponse res = lastResponse.as(CreateAgencyResponse.class);
        agency.setId(res.getData().getId());
    }

    @Step
    public void verifyDataCreateAgency(Agency agency){
        CreateAgencyResponse res = lastResponse.as(CreateAgencyResponse.class);
        String message = res.getMessage();
        System.out.println("Message: " + message);

        assertThat(lastResponse.getStatusCode()).isEqualTo(201);
        assertThat(res.getMessage()).isEqualTo("代理店の作成に成功しました");
        assertThat(res.getData().getName()).isEqualTo(agency.getName());
        assertThat(res.getData().getAgency_code()).isEqualTo(agency.getAgency_code());
    }
}
