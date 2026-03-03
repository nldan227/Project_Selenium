package bb.api.services;

import bb.api.common.BaseApiService;
import bb.api.common.TokenManager;
import bb.api.endpoints.Endpoints;
import bb.api.requests.CreateAgencyRequest;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class CreateAgencyService extends BaseApiService  {

    public Response createAgency(CreateAgencyRequest request){
        Map<String, String> headers = new HashMap<>();
        headers.put("X-API-KEY", "secret");
        return postWithToken(Endpoints.CreateAgency, request, TokenManager.getAccessToken(), headers);
    }
}
