package bb.api.services;

import bb.api.common.BaseApiService;
import bb.api.endpoints.Endpoints;
import bb.api.requests.LoginAiruRequest;
import bb.api.requests.LoginRequest;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AuthApiService extends BaseApiService {

    public Response login(LoginRequest request) {
        return post(Endpoints.LOGIN, request);
    }

    public Response login(LoginAiruRequest request) {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-API-KEY", "secret");
        return post(Endpoints.LOGIN, request, headers);
    }
}
