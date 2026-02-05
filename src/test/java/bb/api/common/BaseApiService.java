package bb.api.common;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import java.util.Collections;
import java.util.Map;

import bb.api.specifications.RequestSpecFactory;
import bb.api.specifications.ResponseSpecFactory;

public class BaseApiService {

    /**
     * Create a default request specification from RequestSpecFactory
     */
    protected RequestSpecification request() {
        return SerenityRest.given()
                .spec(RequestSpecFactory.defaultSpec())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }

    /**
     * Create a request with additional headers
     */
    protected RequestSpecification request(Map<String, ?> headers) {
        if (headers == null || headers.isEmpty()) return request();
        return request().headers(headers);
    }

    /**
     * Create a request with Bearer token authentication
     */
    protected RequestSpecification requestWithToken(String token) {
        if (token == null || token.isBlank()) return request();
        return request().auth().oauth2(token);
    }

    /**
     * Create a request with Bearer token authentication and additional headers
     */
    protected RequestSpecification requestWithToken(String token, Map<String, ?> headers) {
        RequestSpecification req = requestWithToken(token);
        if (headers == null || headers.isEmpty()) return req;
        return req.headers(headers);
    }

    // =========================
    // GET
    // =========================
    protected Response get(String endpoint) {
        return request()
                .when()
                .get(endpoint)
                .then()
                .spec(ResponseSpecFactory.defaultSpec())
                .extract().response();
    }

    protected Response get(String endpoint, Map<String, ?> queryParams) {
        return request()
                .queryParams(nullSafeMap(queryParams))
                .when()
                .get(endpoint)
                .then()
                .spec(ResponseSpecFactory.defaultSpec())
                .extract().response();
    }

    protected Response get(String endpoint, Map<String, ?> headers, Map<String, ?> queryParams) {
        return request(headers)
                .queryParams(nullSafeMap(queryParams))
                .when()
                .get(endpoint)
                .then()
                .spec(ResponseSpecFactory.defaultSpec())
                .extract().response();
    }

    // =========================
    // POST
    // =========================
    protected Response post(String endpoint, Object body) {
        return request()
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .spec(ResponseSpecFactory.defaultSpec())
                .extract().response();
    }

    protected Response post(String endpoint, Object body, Map<String, ?> headers) {
        return request(headers)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .spec(ResponseSpecFactory.defaultSpec())
                .extract().response();
    }

    protected Response postWithToken(String endpoint, Object body, String token) {
        return requestWithToken(token)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .spec(ResponseSpecFactory.defaultSpec())
                .extract().response();
    }

    protected Response postWithToken(String endpoint, Object body, String token, Map<String, ?> headers) {
        return requestWithToken(token, headers)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .spec(ResponseSpecFactory.defaultSpec())
                .extract().response();
    }

    // =========================
    // PUT
    // =========================
    protected Response put(String endpoint, Object body) {
        return request()
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .spec(ResponseSpecFactory.defaultSpec())
                .extract().response();
    }

    protected Response putWithToken(String endpoint, Object body, String token) {
        return requestWithToken(token)
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .spec(ResponseSpecFactory.defaultSpec())
                .extract().response();
    }

    // =========================
    // PATCH
    // =========================
    protected Response patch(String endpoint, Object body) {
        return request()
                .body(body)
                .when()
                .patch(endpoint)
                .then()
                .spec(ResponseSpecFactory.defaultSpec())
                .extract().response();
    }

    protected Response patchWithToken(String endpoint, Object body, String token) {
        return requestWithToken(token)
                .body(body)
                .when()
                .patch(endpoint)
                .then()
                .spec(ResponseSpecFactory.defaultSpec())
                .extract().response();
    }

    // =========================
    // DELETE
    // =========================
    protected Response delete(String endpoint) {
        return request()
                .when()
                .delete(endpoint)
                .then()
                .spec(ResponseSpecFactory.defaultSpec())
                .extract().response();
    }

    protected Response deleteWithToken(String endpoint, String token) {
        return requestWithToken(token)
                .when()
                .delete(endpoint)
                .then()
                .spec(ResponseSpecFactory.defaultSpec())
                .extract().response();
    }

    // =========================
    // Helper
    // =========================
    /**
     * Return an empty map if the provided map is null
     */
    private Map<String, ?> nullSafeMap(Map<String, ?> map) {
        return map == null ? Collections.emptyMap() : map;
    }
}
