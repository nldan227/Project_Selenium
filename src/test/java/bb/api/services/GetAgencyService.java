package bb.api.services;

import bb.api.common.BaseApiService;
import bb.api.common.TokenManager;
import bb.api.dataobjects.model.Agency;
import bb.api.endpoints.Endpoints;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

import java.util.HashMap;
import java.util.Map;

public class GetAgencyService extends BaseApiService {

    public Response getAgencyService(){
        Map<String, String> headers = new HashMap<>();
        headers.put("X-API-KEY", "secret");
        headers.put("Authorization", "Bearer " + TokenManager.getAccessToken());
        Agency agency = Serenity.sessionVariableCalled("createdAgency");
        return get(Endpoints.GetAgency + agency.getId(), headers, null);
    }

}
