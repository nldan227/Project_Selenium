package bb.api.services;

import bb.api.common.BaseApiService;
import bb.api.endpoints.AuthEndpoints;
import bb.api.requests.LoginAiruRequest;
import bb.api.requests.LoginRequest;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AuthApiService extends BaseApiService {

    public Response login(LoginRequest request) {
        return post(AuthEndpoints.LOGIN, request);
    }

    public Response login(LoginAiruRequest request) {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-API-KEY", "secret");
        return post(AuthEndpoints.LOGIN, request, headers);
    }
}
