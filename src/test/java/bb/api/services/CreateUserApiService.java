package bb.api.services;

import bb.api.common.BaseApiService;
import bb.api.common.TokenManager;
import bb.api.endpoints.CreateUserEndpoints;
import bb.api.requests.CreateUserRequest;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class CreateUserApiService extends BaseApiService {

    public Response createUser(CreateUserRequest request) {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-API-KEY", "secret");
        return postWithToken(CreateUserEndpoints.CreateUser, request, TokenManager.getAccessToken(), headers);
    }
}
